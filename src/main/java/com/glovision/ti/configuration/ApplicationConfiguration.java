/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.glovision.ti.configuration;

import com.glovision.ti.util.Constants;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Properties;
import org.apache.log4j.Logger;

/**
 *
 * @author glodeveloper
 */
public class ApplicationConfiguration {

    static final Logger log = Logger.getLogger(ApplicationConfiguration.class);

    public Properties getapplicationproperties() {
        try {
            Properties properties = new Properties();
            File configfolder = new File(Constants.Configfolder);
            if (!configfolder.exists()) {
                configfolder.mkdirs();
            }
            File configfile = new File(Constants.Configfile);
            if (!configfile.exists()) {
                log.info("Config file does not exists creating new config file with default values...");
                configfile.createNewFile();
                BufferedWriter writer = new BufferedWriter(new FileWriter(configfile, true));
                writer.append("jdbc.driverClassName = com.mysql.jdbc.Driver\n"
                        + "jdbc.url = jdbc:mysql://localhost:3306/gts\n"
                        + "jdbc.username = root\n"
                        + "jdbc.password = gl0v1s10n\n"
                        + "hibernate.dialect = org.hibernate.dialect.MySQLDialect\n"
                        + "hibernate.show_sql = false\n"
                        + "hibernate.format_sql = true\n"
                        + "ssl.key=1234567890123456\n"
                        + "ssl.initvector=RandomInitVector\n"
                        + "sysadmin.username=sysadmin@glovision.co\n"
                        + "sysadmin.password=password\n"
                        + "#expire days for user account\n"
                        + "profileexpiredays=90\n"
                        + "#mailer properties\n"
                        + "mailerusername=glovisiontechnoservicesdrive@gmail.com\n"
                        + "mailerpassword=glovision123\n"
                        + "mail.smtp.socketFactory.fallback=true\n"
                        + "mail.smtp.host=smtp.gmail.com\n"
                        + "mail.smtp.socketFactory.port=587\n"
                        + "mail.smtp.port=587\n"
                        + "mail.smtp.starttls.enable=true\n"
                        + "mail.smtp.auth=true\n"
                        + "mail.smtp.ssl.trust=smtp.gmail.com");
                writer.close();
            }
            BufferedReader in = new BufferedReader(new FileReader(configfile.getAbsolutePath()));
            String str;
            while ((str = in.readLine()) != null) {
                if (!str.contains("=")) {
                    continue;
                }
                String[] data = str.split("=");
                properties.put(data[0].trim(), data[1].trim());
            }
            in.close();
            return properties;
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getStackTrace());
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println("starting...");
    }
}
