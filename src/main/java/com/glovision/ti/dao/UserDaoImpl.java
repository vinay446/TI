/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.glovision.ti.dao;

import com.glovision.ti.model.User;
import com.glovision.ti.util.util;
import java.util.List;
import org.hibernate.Query;
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
        Query query = getSession().createSQLQuery("select * from User where contactEmail =:emailID");
        query.setParameter("emailID", emailID);
        List<Object[]> list = query.list();
        for (Object[] arr : list) {
            User user = new User();
            user.setAccountID((String) arr[0]);
            user.setUserID((String) arr[1]);
            user.setUserType(util.parseInt(arr[2]));
            user.setRoleID((String) arr[3]);
            user.setPassword((String) arr[4]);
            user.setGender(util.parseInt(arr[5]));
            user.setNotifyEmail((String) arr[6]);
            user.setContactName((String) arr[7]);
            user.setContactPhone((String) arr[8]);
            user.setContactEmail((String) arr[9]);
            user.setTimeZone((String) arr[10]);
            user.setFirstLoginPageID((String) arr[11]);
            user.setPreferredDeviceID((String) arr[12]);
            user.setMaxAccessLevel(util.parseInt(arr[13]));
            user.setPasswdChangeTime(util.parseLong(arr[14]));
            user.setPasswdQueryTime(util.parseLong(arr[15]));
            user.setLastLoginTime(util.parseLong(arr[16]));
            user.setIsActive(util.parseInt(arr[17]));
            user.setDisplayName((String) arr[18]);
            user.setDescription((String) arr[19]);
            user.setNotes((String) arr[20]);
            user.setLastUpdateTime(util.parseLong(arr[21]));
            user.setCreationTime(util.parseLong(arr[22]));
            user.setExpirationTime(util.parseLong(arr[23]));
            return user;
        }
        return null;
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
