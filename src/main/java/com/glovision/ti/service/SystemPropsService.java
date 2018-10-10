/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.glovision.ti.service;

import com.glovision.ti.model.SystemProps;

/**
 *
 * @author glodeveloper
 */
public interface SystemPropsService {

    /**
     * Returns SystemProps Database object for given PropertyID
     *
     * @param propertyID
     * @return
     */
    SystemProps findByPropID(String propertyID);

    /**
     * Saves given Property Object in database
     *
     * @param property
     */
    void saveorUpdateProperty(SystemProps property);

    /**
     * Deletes SystemProperty Object from database
     *
     * @param property
     */
    void deleteProperty(SystemProps property);
}
