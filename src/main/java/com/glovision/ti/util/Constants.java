/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.glovision.ti.util;

import java.io.File;

/**
 *
 * @author glodeveloper
 */
public class Constants {

    public static final String ApplicationVersion = "1.0";
    public static final String userhome = System.getProperty("user.home");
    public static final String osname = System.getProperty("os.name");
    public static final String javaversion = System.getProperty("java.runtime.version");
    public static final String Configfolder = userhome + File.separator + "TI";
    public static final String Configfile = Configfolder + File.separator + "TI.properties";
}
