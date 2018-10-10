/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.glovision.ti.service;

import com.glovision.ti.dao.SystemPropsDao;
import com.glovision.ti.model.SystemProps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author glodeveloper
 */
@Service("SystemPropsService")
@Transactional
public class SystemPropsServiceImpl implements SystemPropsService{

    @Autowired
    SystemPropsDao dao;
    
    @Override
    public SystemProps findByPropID(String propertyID) {
        return dao.findByPropID(propertyID);
    }

    @Override
    public void saveorUpdateProperty(SystemProps property) {
        dao.saveorUpdateProperty(property);
    }

    @Override
    public void deleteProperty(SystemProps property) {
        dao.deleteProperty(property);
    }
    
}
