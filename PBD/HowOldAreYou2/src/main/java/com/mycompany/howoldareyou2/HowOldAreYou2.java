/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.howoldareyou2;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class HowOldAreYou2 {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        System.out.print("Hey whats your name? ");
        String name = read.nextLine();

        System.out.println("Ok, " + name + ", how old are you?");
        int age = read.nextInt();

        if (age < 16) {
            System.out.println("You cant drive, " + name);
        }
        else if (age == 16 || age == 17)    {
            System.out.println("You can drive but not vote, " + name);
        }
        else if (age >= 18 && age <= 24) {
            System.out.println("You can vote but not rent a car, " + name);
        }
        else {
            System.out.println("You can do pretty much anything, " + name);
        }
    }
}
