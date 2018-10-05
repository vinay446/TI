/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.glovision.ti.service;

import com.glovision.ti.dao.UserDao;
import com.glovision.ti.model.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author glodeveloper
 */
@Transactional
@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userdao;

    @Override
    public User findById(String emailID) {
        return userdao.findById(emailID);
    }

    @Override
    public void SaveOrUpdateUser(User user) {
        userdao.SaveOrUpdateUser(user);
    }

    @Override
    public void deleteUser(String emailID) {
        userdao.deleteUser(emailID);
    }

    @Override
    public List<User> findallUsers() {
        return userdao.findallUsers();
    }

    @Override
    public boolean isUseremailIDUnique(String emailID) {
        // TODO Auto-generated method stub
        User user = userdao.findById(emailID);
        return user == null;
    }

}
