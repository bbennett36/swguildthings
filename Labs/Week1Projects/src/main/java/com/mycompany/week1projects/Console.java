/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.week1projects;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class Console implements Game, InterestCalcInterface {

    Scanner read = new Scanner(System.in);

    @Override
    public void run() {

        int yearCount = 1;
        
        System.out.println("What is the annual interest rate? ");
        double aRate = read.nextDouble();
        double qRate = aRate / 4;

        System.out.println("What is the initial amount of principal? ");
        double principle = read.nextDouble();

        System.out.println("# of years to stay in fund? ");
        int years = read.nextInt();

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

    @Override
    public String getName() {
        return "InterestCalc";
    }
}
