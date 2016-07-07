/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 *
 * @author apprentice
 */

//@Aspect
public class getTimes {
    

    public Object timer(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        Object output = pjp.proceed();
        long elapsedTime = System.currentTimeMillis() - start;
        System.out.println("That took: " + elapsedTime + " milliseconds!");
        return output;
    }

}

