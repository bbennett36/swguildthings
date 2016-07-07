/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.keepguessing;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class KeepGuessing {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        Random r = new Random();
        
        System.out.println("I have chosen a number between 1 and 10, try to guess it:");
        System.out.print("Your guess: ");
        int userNum = read.nextInt();
        int compNum = (1 + r.nextInt(10));
        
        while(userNum != compNum)   {
            System.out.println("This is incorrect, guess again: ");
            System.out.print("Your guess: ");
            userNum = read.nextInt();
        }
        System.out.println("Thats right! youre a good guesser! ");
    }
   
}
