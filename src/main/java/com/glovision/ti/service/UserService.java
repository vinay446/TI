/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.glovision.ti.service;

import com.glovision.ti.model.User;
import java.util.List;

/**
 *
 * @author glodeveloper
 */
public interface UserService {

    /**
     * Retreivs User Obj by emailID
     *
     * @param emailID
     * @return User Obj
     */
    User findById(String emailID);

    /**
     * Saves given obj to database
     *
     * @param user
     */
    void SaveOrUpdateUser(User user);

    /**
     * Deletes User Obj for given emailID
     *
     * @param emailID
     */
    void deleteUser(String emailID);

    /**
     * Retirves all Users
     */
    List<User> findallUsers();
    
    /**
     * Finds emailID in database 
     * @param emailID
     * @return true if emailID does not exists in database 
     */
    public boolean isUseremailIDUnique(String emailID);
}
