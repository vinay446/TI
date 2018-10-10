/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.glovision.ti.controller;

import com.glovision.ti.model.Login;
import com.glovision.ti.model.SystemProps;
import com.glovision.ti.model.User;
import com.glovision.ti.service.SystemPropsService;
import com.glovision.ti.service.UserService;
import com.glovision.ti.util.SessionUtil;
import com.glovision.ti.util.util;
import com.org.util.DateUtil;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author glodeveloper
 */
@Controller
@Scope("request")
public class UserController {

    private static Logger log = Logger.getLogger(UserController.class);

    @Autowired
    private UserService service;

    @Autowired
    private SystemPropsService props;

    @Autowired
    private SessionUtil sessionutil;

    /**
     * Checks login parameters entered by user with database
     *
     * @param model
     * @param login JSON format of login request parameters
     * @param request
     * @param response
     * @return JSON response
     */
    @RequestMapping(value = "/checklogin", method = RequestMethod.POST)
    public @ResponseBody
    Login checklogin(ModelMap model, @RequestBody Login login, HttpServletRequest request, HttpServletResponse response) {
        log.debug("Check login..." + login.getEmailID() + ">" + login.getPassword() + ">" + login.getMessage() + ">" + login.isStatus());
        if (service.isUseremailIDUnique(login.getEmailID())) {
            log.info("Requested EmailID does not exist in database");
            login.setPassword(null);
            login.setStatus(false);
            login.setMessage("Requested EmailID does not exist..");
            return login;
        }
        User user = service.findById(login.getEmailID());
        if (user.getIsActive() == 0) {
            log.info("User is inactive");
            login.setPassword(null);
            login.setStatus(false);
            login.setMessage("UserID is not activated. Please activate your account");
            return login;
        }
        if (user.getPassword().equals(util.encryptString(login.getPassword()))) {
            log.info("login success");
            if (login.isRememberme()) {
                savecookies(response, login.getEmailID(), login.getPassword());
            }
            HttpSession session = request.getSession();
            SystemProps systemprops = props.findByPropID(user.getContactEmail() + "#map");
            String mapused = systemprops.getValue()==null? "google":systemprops.getValue();
            session.setAttribute("userID", login.getEmailID());
            sessionutil.setAccountID(user.getAccountID());
            sessionutil.setRoleID(user.getRoleID());
            sessionutil.setUserID(user.getUserID());
            sessionutil.setDisplayName(user.getDisplayName());
            sessionutil.setPropertyValue(mapused);
            model.addAttribute("sessionutil", sessionutil);
            login.setPassword(null);
            login.setStatus(true);
            user.setLastLoginTime(DateUtil.getEpoch());
            return login;
        }
        login.setPassword(null);
        login.setMessage("Access Denied, Incorrect login credentials..");
        login.setStatus(false);
        return login;
    }

    /**
     * saves username and password in cookies
     *
     * @param response
     * @param emailID
     * @param password
     */
    private void savecookies(HttpServletResponse response, String emailID, String password) {
        Cookie c1 = new Cookie("emailID", emailID);
        Cookie c2 = new Cookie("password", password);
        c1.setMaxAge(60 * 60 * 24 * 365 * 10);
        c2.setMaxAge(60 * 60 * 24 * 365 * 10);
        response.addCookie(c1);
        response.addCookie(c2);
        log.debug("username and passsword saved into cookies");
    }
}
