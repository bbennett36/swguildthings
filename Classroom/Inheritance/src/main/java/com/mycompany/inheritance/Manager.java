/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.inheritance;

/**
 *
 * @author apprentice
 */
public class Manager extends Employee {
    
    public Manager()    {
//     super("Bill", "Jones");
        
        
        
    }
    
    public void doWork()   {
        super.doWork();
            System.out.println("Manager: Doing work. Life sucks");
    }
    
    public void doHire()  {
        System.out.println("MAnager: hiring");
    }
    
    public void doFire()  {
        System.out.println("Manager: firing");
    }
    
}
