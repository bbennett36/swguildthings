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
public class Employee {
    
    
    private String fName;
    private String lName;
    
    public Employee()   {
        System.out.println("Employee Constructor");
    }
    
    public Employee(String fName, String lName) {
        
    }
    
    public void doWork()    {
        System.out.println("Employee: Do Work!");
    }
    
    public void createObjectives()  {
        System.out.println("Employee objectives: Dont get fired");
        
    }
    
}
