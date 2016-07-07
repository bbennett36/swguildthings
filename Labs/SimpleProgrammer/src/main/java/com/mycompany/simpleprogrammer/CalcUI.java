/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.simpleprogrammer;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class CalcUI {

    Scanner read = new Scanner(System.in);
    private String prompt;
    
    SimpleCalculator sc = new SimpleCalculator();

    public void runGame() {
        boolean playAgain = true;
        while (playAgain) {
            System.out.println("What do you want to perform?");
            System.out.println("Enter the number for choice");
            System.out.println("1.Addition 2.Subtraction 3.Division 4.Multipication 5.Exit Program");
            String schoice = read.nextLine();
            int choice = Integer.parseInt(schoice);
   
            switch (choice) {
                case 1:
                    getNums();
                    sc.addition(sc.num1, sc.num2);
                    System.out.println("Total: " + sc.total);
                    break;
                case 2:
                    getNums();
                    sc.subtraction(sc.num1, sc.num2);
                    System.out.println("Total: " + sc.total);
                    break;
                case 3:
                    getNums();
                    sc.division(sc.num1, sc.num2);
                    System.out.println("Total: " + sc.total);
                    break;
                case 4:
                    getNums();
                    sc.multipication(sc.num1, sc.num2);
                    System.out.println("Total: " + sc.total);
                    break;
                case 5:
                    playAgain = false;
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }
        System.out.println("Thanks for playing!");
    }

    public void getNums() {
        System.out.println("Enter first number: ");
        prompt = read.nextLine();
        sc.num1 = Integer.parseInt(prompt);
        System.out.println("Enter second number: ");
        prompt = read.nextLine();
        sc.num2 = Integer.parseInt(prompt);
    }


}
