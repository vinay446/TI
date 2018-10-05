/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.glovision.ti.dao;

import com.glovision.ti.model.User;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author glodeveloper
 */
@Repository("UserDao")
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory factory;

    private Session getSession() {
        return factory.getCurrentSession();
    }

    @Override
    public User findById(String emailID) {
        return (User) getSession().get(User.class, emailID);
    }

    @Override
    public void SaveOrUpdateUser(User user) {
        getSession().saveOrUpdate(user);
    }

    @Override
    public void deleteUser(String emailID) {
        getSession().delete(findById(emailID));
    }

    @Override
    public List<User> findallUsers() {
        return (List<User>) getSession().createCriteria(User.class).list();
    }

}
