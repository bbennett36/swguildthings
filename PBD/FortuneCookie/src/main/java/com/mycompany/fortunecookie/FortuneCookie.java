/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fortunecookie;

import java.util.Random;

/**
 *
 * @author apprentice
 */
public class FortuneCookie {
    public static void main(String[] args) {
        Random r = new Random();
        
        int choice = 1 + r.nextInt(6);
        String response = "";

        if (choice == 1) {
            response = "Today it's up to you to create the peacefulness you long for.";
        } else if (choice == 2) {
            response = "A friend asks only for your time not your money.";
        } else if (choice == 3) {
            response = "If you refuse to accept anything but the best, you very often get it.";
        } else if (choice == 4) {
            response = "A smile is your passport into the hearts of others.";
        } else if (choice == 5) {
            response = "A good way to keep healthy is to eat more Chinese food.";
        } else if (choice == 6) {
            response = "Hard work pays off in the future, laziness pays off now.";
        } else {
            response = "ERROR!";
        }
        System.out.println("Fortune cookie says: " + response);
        
        System.out.print(1 + r.nextInt(54));
        System.out.print(" - ");
        System.out.print(1 + r.nextInt(54));
        System.out.print(" - ");
        System.out.print(1 + r.nextInt(54));
        System.out.print(" - ");
        System.out.print(1 + r.nextInt(54));
        System.out.print(" - ");
        System.out.print(1 + r.nextInt(54));
        System.out.print(" - ");
        System.out.print(1 + r.nextInt(54));
    }
}
