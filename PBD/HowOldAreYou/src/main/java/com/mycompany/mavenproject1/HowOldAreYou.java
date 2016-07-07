/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class HowOldAreYou {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        System.out.print("Hey whats your name? ");
        String name = read.nextLine();

        System.out.println("Ok, " + name + ", how old are you?");
        int age = read.nextInt();

        if (age < 16) {
            System.out.println("You cant drive, " + name);
        }
        if (age < 18) {
            System.out.println("You cant vote, " + name);
        }

        if (age < 25) {
            System.out.println("You cant rent a car, " + name);
        }

        if (age > 25) {
            System.out.println("You can do anything thats legal, " + name);
        }
    }
}
