/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.glovision.ti.controller;

import com.glovision.ti.model.Login;
import com.glovision.ti.model.User;
import com.glovision.ti.service.UserService;
import com.glovision.ti.util.util;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
public class UserController {

    private static Logger log = Logger.getLogger(UserController.class);

    @Autowired
    private UserService service;

    @RequestMapping(value = "/checklogin", method = RequestMethod.POST)
    public @ResponseBody
    Login checklogin(ModelMap model, @RequestBody Login login) {
        log.debug("Check login..."+login.getEmailID()+">"+login.getPassword()+">"+login.getMessage()+">"+login.isStatus());        
        if (service.isUseremailIDUnique(login.getEmailID())) {
            log.info("Requested EmailID does not exist in database");
            login.setPassword(null);
            login.setStatus(false);
            login.setMessage("Requested EmailID does not exist..");
            return login;
        }
        User user = service.findById(login.getEmailID());
        if (user.getPassword().equals(util.encryptString(login.getPassword()))) {
            log.info("login success");
            login.setPassword(null);
            login.setStatus(true);
            return login;
        }
        login.setPassword(null);
        login.setMessage("Access Denied, Incorrect login credentials..");
        login.setStatus(false);
        return login;
    }

}
