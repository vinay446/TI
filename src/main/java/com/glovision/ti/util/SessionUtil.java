/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.glovision.ti.util;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * This method is used to inject spring-mvc session dependencies directly by
 * spring controller and in controller methods we can get values directly by
 * using @scope("request") annotation and @Autowire annotation the controller in
 * this approach MUST be request scoped. The default is for Spring to create a
 * global singleton instance of the controller, and this would not work as a
 * singleton is shared by all requests Pros: Clean testable controller as in
 * approach two, with the added benefit of the session now only holds the
 * relevant session data. Cons: A new instance of the controller is created for
 * each request. This is fine if the controller is “small”, but if it is
 * expensive to create (ie the constructor is slow for some reason), scalability
 * would be a problem. Also, this approach is harder to understand because of
 * the request scoped controller.
 *
 * @author vinay
 */
@Component
@Scope("session")
public class SessionUtil {
    
    String userID;
    
    String accountID;
        
    String roleID;
    
    String notes;

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void invalidate(){
        this.userID =null;
        this.accountID = null;
        this.roleID = null;
    }
    
    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }
    

    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }
    
    
}
