/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bmicalc;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class BMICalc {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        
        System.out.println("Your height (feet only): ");
        double fheight = read.nextDouble();
        
        System.out.println("Your height (inches): ");
        double iheight = read.nextDouble();
        
        double totalinches = (fheight * 12) + iheight;
        
        double mheight = totalinches * 0.0254;
        
        System.out.println("Enter your weight in pounds");
        double pweight = read.nextDouble();
        
        double kgweight = pweight * 0.453592;
        
        double bmi = kgweight / (mheight * mheight);
        
        System.out.println("Your BMI is: " + bmi);
    }
}
