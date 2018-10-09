/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.glovision.ti.controller;

import com.glovision.ti.util.SessionUtil;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author glodeveloper
 */
@Controller
@Scope("request")
public class CommonController {
    
    @Autowired
    SessionUtil sessionutil;

    private static Logger log = Logger.getLogger(CommonController.class);

    /**
     * * Request from web.xml if 404 (page not found) Exception raises
     *
     * @param model
     * @return to custom 404 page other than apache
     */
    @RequestMapping(value = "/404")
    public String error404(ModelMap model) {
        log.warn("User requested a resource which is not available");
        return "404";
    }

    /**
     * * Request from web.xml if 500 (Internal Server Error) Exception raises
     *
     * @param model
     * @return to custom 404 page other than apache
     */
    @RequestMapping(value = "/500")
    public String error500(ModelMap model) {
        log.fatal("Un handled internal server error occured..");
        return "500";
    }
    
    
    /**
     * Mapping for login page
     * @param model
     * @return 
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginpage(ModelMap model) {
        return "redirect:/";
    }
    
    /**
     * Mapping for home page
     * @return 
     */
    @RequestMapping(value="/home",method=RequestMethod.GET)
    public String homepage(ModelMap model){
        model.addAttribute("sessionutil",sessionutil);
        return "home";
    }
    
    /**
     * Session logout 
     * @param request
     * @param message
     * @return 
     */
    @RequestMapping(value="/logout",method=RequestMethod.GET)
    public String logout(HttpServletRequest request,@RequestParam("msg") String message){
        HttpSession session = request.getSession();
        session.invalidate();
        sessionutil.invalidate();
        return "redirect:/?msg="+message;
    }
}
