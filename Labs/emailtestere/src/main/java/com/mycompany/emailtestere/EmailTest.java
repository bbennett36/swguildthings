/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.emailtestere;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 *
 * @author apprentice
 */
public class EmailTest {

    @SuppressWarnings("resource")
    public static void main(String args[]) {

        // Spring Bean file you specified in /src/main/resources folder
        String crunchifyConfFile = "spring-persistence.xml";
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(crunchifyConfFile);

        // @Service("crunchifyEmail") <-- same annotation you specified in CrunchifyEmailAPI.java
        EmailAPI emailAPI = (EmailAPI) context.getBean("crunchifyEmail");
        String toAddr = "bennettglob@gmail.com";
        String fromAddr = "bennettglob@gmail.com";

        // email subject
        String subject = "Hey.. This email sent by Crunchify's Spring MVC Tutorial";

        // email body
        String body = "There you go.. You got an email.. Let's understand details on how Spring MVC works -- By Crunchify Admin";
        emailAPI.crunchifyReadyToSendEmail(toAddr, fromAddr, subject, body);
    }

}
