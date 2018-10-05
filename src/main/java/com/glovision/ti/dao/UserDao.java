/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.glovision.ti.dao;

import com.glovision.ti.model.User;
import java.util.List;

/**
 *
 * @author glodeveloper
 */
public interface UserDao {

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
}
