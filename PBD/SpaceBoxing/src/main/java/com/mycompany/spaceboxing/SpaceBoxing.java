/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spaceboxing;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class SpaceBoxing {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        System.out.print("Please enter your current weight: ");
        int weight = read.nextInt();

        System.out.println("I have information for the following planets (Type number): ");
        System.out.println("1. Venus 2. Mars 3. Jupiter");
        System.out.println("4. Saturn 5. Uranus 6. Neptune");
        System.out.println(" ");
        System.out.println("Which planet are you visiting? ");
        int answer = read.nextInt();

        double tweight;

        switch (answer) {
            case 1:
                tweight = weight * 0.78;
                System.out.println("Your weight would be " + tweight + " Venus");
                break;
            case 2:
                tweight = weight * 0.39;
                System.out.println("Your weight would be " + tweight + " Mars");
                break;
            case 3:
                tweight = weight * 2.65;
                System.out.println("Your weight would be " + tweight + " Jupiter");

                break;
            case 4:
                tweight = weight * 1.17;
                System.out.println("Your weight would be " + tweight + " Saturn");

                break;
            case 5:
                tweight = weight * 1.05;
                System.out.println("Your weight would be " + tweight + " Uranus");
                break;
            case 6:
                tweight = weight * 1.23;
                System.out.println("Your weight would be " + tweight + " Neptune");
                break;
            default:
                System.out.println("Invalid planet choice!");
        }
    }
}
