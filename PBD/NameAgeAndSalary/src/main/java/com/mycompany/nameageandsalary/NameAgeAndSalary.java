/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.nameageandsalary;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class NameAgeAndSalary {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        
        System.out.println("What is your name?");
        String name = reader.nextLine();
        
        System.out.println("Hi " + name + ", how old are you?");
        int age = reader.nextInt();
        
        System.out.println("So you're " + age + " eh? That's not old at all!");
        
        System.out.println("How much do you make " + name + "?");
        double salary = reader.nextDouble();
        
        System.out.println(salary + "! I hope that's per hour and not per year! LOL!");
    }
}
