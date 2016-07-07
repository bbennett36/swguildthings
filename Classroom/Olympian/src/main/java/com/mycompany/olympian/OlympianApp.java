/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.olympian;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author apprentice
 */
public class OlympianApp {

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

//        SkiJumper jumper = (SkiJumper) ctx.getBean("skiJumper");
//        System.out.println(jumper.competeInEvent());
//
//        Event curlingEvent = new CurlingEvent();
//        Olympian olympian = new Olympian(curlingEvent);
//        
//        olympian.competeInEvent();

        Olympian usaSkiJumper = ctx.getBean("usaSkiJumper", Olympian.class);
        usaSkiJumper.competeInEvent();
        
        Olympian curlingDude = ctx.getBean("curlingDude", Olympian.class);
        curlingDude.competeInEvent();
    }
}
