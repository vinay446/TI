/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.glovision.ti.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author glodeveloper
 */
@Entity
@Table(name = "User")
public class User implements Serializable {

    @Id
    @Column(name = "accountID")
    String accountID;

    @Id
    @Column(name = "userID")
    String userID;

    @Column(name = "userType")
    int userType;

    @Column(name = "roleID")
    String roleID;

    @Column(name = "password")
    String password;

    @Column(name = "gender")
    int gender;

    @Column(name = "notifyEmail")
    String notifyEmail;

    @Column(name = "contactName")
    String contactName;

    @Column(name = "contactPhone")
    String contactPhone;
    
    @Column(name = "contactEmail")
    String contactEmail;

    @Column(name = "timeZone")
    String timeZone;

    @Column(name = "firstLoginPageID")
    String firstLoginPageID;

    @Column(name = "preferredDeviceID")
    String preferredDeviceID;

    @Column(name = "maxAccessLevel")
    int maxAccessLevel;

    @Column(name = "passwdChangeTime")
    long passwdChangeTime;

    @Column(name = "passwdQueryTime")
    long passwdQueryTime;

    @Column(name = "lastLoginTime")
    long lastLoginTime;

    @Column(name = "isActive")
    int isActive;

    @Column(name = "displayName")
    String displayName;

    @Column(name = "description")
    String description;

    @Column(name = "notes")
    String notes;

    @Column(name = "lastUpdateTime")
    long lastUpdateTime;

    @Column(name = "creationTime")
    long creationTime;

    @Column(name = "expirationTime")
    long expirationTime;

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getNotifyEmail() {
        return notifyEmail;
    }

    public void setNotifyEmail(String notifyEmail) {
        this.notifyEmail = notifyEmail;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getFirstLoginPageID() {
        return firstLoginPageID;
    }

    public void setFirstLoginPageID(String firstLoginPageID) {
        this.firstLoginPageID = firstLoginPageID;
    }

    public String getPreferredDeviceID() {
        return preferredDeviceID;
    }

    public void setPreferredDeviceID(String preferredDeviceID) {
        this.preferredDeviceID = preferredDeviceID;
    }

    public int getMaxAccessLevel() {
        return maxAccessLevel;
    }

    public void setMaxAccessLevel(int maxAccessLevel) {
        this.maxAccessLevel = maxAccessLevel;
    }

    public long getPasswdChangeTime() {
        return passwdChangeTime;
    }

    public void setPasswdChangeTime(long passwdChangeTime) {
        this.passwdChangeTime = passwdChangeTime;
    }

    public long getPasswdQueryTime() {
        return passwdQueryTime;
    }

    public void setPasswdQueryTime(long passwdQueryTime) {
        this.passwdQueryTime = passwdQueryTime;
    }

    public long getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(long lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public long getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(long lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public long getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(long creationTime) {
        this.creationTime = creationTime;
    }

    public long getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(long expirationTime) {
        this.expirationTime = expirationTime;
    }
    
   
    
}
