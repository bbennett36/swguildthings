/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.factorizer;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class FactorizerObjects implements Game {

    Scanner read = new Scanner(System.in);


//    public int numFactor() {
//        System.out.print("What number would you like to factor? ");
//        int number = read.nextInt();
//        System.out.println(number);
//        return number;
//    }

    
    public void run() {
        int counter = 1;
        int factorCount = 0;
        int factorSum = 0;
        
        System.out.print("What number would you like to factor? ");
        int number = read.nextInt();
        System.out.println(number);

        if (counter < number) {
            System.out.println("The factors of " + number + " are: ");

            while (number % counter == 0) {
                System.out.println(counter);
                factorCount++;
                factorSum += counter;
                counter++;
            }

            System.out.println(number + " has " + (factorCount + 1) + " total factors");
            counter++;
        }

        if (factorSum == number) {
            System.out.println(number + " is a perfect number");
        } else {
            System.out.println(number + " is not a perfect number");
        }

        if (factorCount == 1) {
            System.out.println(number + " is a prime number");
        } else {
            System.out.println(number + " is not a prime number");
        }

    }
    

    @Override
    public String getName() {
        return "Factorizer";
    }
    
}
