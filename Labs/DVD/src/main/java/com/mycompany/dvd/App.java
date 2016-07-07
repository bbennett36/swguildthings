/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvd;

import com.mycompany.dvd.controller.DVDController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author apprentice
 */
public class App {
    public static void main(String[] args) {
        
//    DVDController dc = new DVDController();
    
//    dc.run();
    
    ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    
    DVDController controller = ctx.getBean("controller", DVDController.class);
    controller.run();
    
    }
}
