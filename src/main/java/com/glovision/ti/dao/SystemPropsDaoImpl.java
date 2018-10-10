/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.glovision.ti.dao;

import com.glovision.ti.model.SystemProps;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author glodeveloper
 */
@Repository("SystemPropsDao")
public class SystemPropsDaoImpl implements SystemPropsDao {

    @Autowired
    private SessionFactory factory;

    protected Session getSession() {
        return factory.getCurrentSession();
    }

    @Override
    public SystemProps findByPropID(String propertyID) {
        Criteria cr = getSession().createCriteria(SystemProps.class);
        cr.add(Restrictions.eq("propertyID", propertyID));
        return (SystemProps) cr.uniqueResult();
    }

    @Override
    public void saveorUpdateProperty(SystemProps property) {
        getSession().saveOrUpdate(property);
    }

    @Override
    public void deleteProperty(SystemProps property) {
        getSession().delete(property);
    }

    
}
