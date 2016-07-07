/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dumbcalculator;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class DumbCalculator {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        
        System.out.println("Enter your first number: ");
        double num1 = read.nextDouble();
        
        System.out.println("Enter your second number: ");
        double num2 = read.nextDouble();
        
        System.out.println("Enter your third number: ");
        double num3 = read.nextDouble();
        
        double answer = (num1 + num2 + num3) / 2;
        System.out.println("(number1 + number2 + number3) / 2 is " + answer);
    }
}
