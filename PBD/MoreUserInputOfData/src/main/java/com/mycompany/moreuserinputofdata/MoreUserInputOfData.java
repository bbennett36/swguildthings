/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.moreuserinputofdata;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class MoreUserInputOfData {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Please enter the following information so I can sell it for a profit!");
        
        System.out.print("First name: ");
        String fname = reader.nextLine();
        
        System.out.print("Last name: ");
        String lname = reader.nextLine();
        
        System.out.print("Grade (9-12): ");
        int grade = reader.nextInt();
        
        System.out.print("Student ID: ");
        int id = reader.nextInt();
        
        System.out.print("Login: ");
        String login = reader.next();
        
        System.out.print("GPA (0.0 - 4.0): ");
        double gpa = reader.nextDouble();
        
        System.out.println("Your information: ");
        System.out.println("Login: " + login);
        System.out.println("ID: " + id);
        System.out.println("Name: " + lname + ", " + fname);
        System.out.println("GPA: " + gpa);
        System.out.println("Grade: " + grade);
    }
}
