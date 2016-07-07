/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.interestcalc;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */ 
public class Console{
    Scanner read = new Scanner(System.in);

        public double quaRate() {
            System.out.println("What is the annual interest rate? ");
            double aRate = read.nextDouble();
            double rate4 = aRate / 4;
            return rate4;
        }

        public double getPrinciple()    {
            System.out.println("What is the initial amount of principal? ");
            double principle = read.nextDouble();
            return principle;
        }

        public int getYears()   {
            System.out.println("# of years to stay in fund? ");
            int years = read.nextInt();
            return years;
        }
         
    public void run(int yearCount, int years, double qRate, double principle) {
        
        double newPrinciple = 0;
        double interestCalc;
        while (yearCount <= years) {

            double beginPrinciple = principle;
            interestCalc = 0;

            for (int i = 1; i <= 4; i++) {
                newPrinciple = principle * (1 + (qRate / 100));
                interestCalc += principle * (qRate / 100);
                principle = newPrinciple;
            }

            System.out.println("The current year is: " + yearCount);
            System.out.println("Principal at the beginning of the year " + beginPrinciple);
            System.out.println("Total amount of interest earned for this year: " + interestCalc);
            System.out.println("The principle at the end of the year is " + newPrinciple);

            yearCount++;
            System.out.println(" ");
        }
    }
}
