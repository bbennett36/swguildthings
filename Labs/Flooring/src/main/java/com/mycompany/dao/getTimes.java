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
    
//    @Pointcut("execution(* com.mycompany.*.*(..))")
//    public void displayOrders() { }

//    @Around("execution(* com.mycompany.controller.OrderController.run(..))")
    public Object go(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("Going to call the method.");
        Object output = pjp.proceed();
        System.out.println("Method execution completed.");
        long elapsedTime = System.currentTimeMillis() - start;
        System.out.println("Method execution time: " + elapsedTime + " milliseconds.");
        return output;
    }
//    AuditDao adao = new AuditDao();
    
//    @Around("execution(* com.mycompany.dao.OrderDao.create(..))")
//     public Object go(ProceedingJoinPoint pjp) throws Throwable {
//        Object output = pjp.proceed();
////        Order order = (Order) output;
////        adao.createNew(order);
//        return output;
//    }
    
//    public Object go()  {
//        return null;
//    }

}

