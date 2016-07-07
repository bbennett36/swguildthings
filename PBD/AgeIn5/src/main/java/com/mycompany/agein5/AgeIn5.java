/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.agein5;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class AgeIn5 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        
        System.out.print("Hello user what is your name? ");
        String name = read.nextLine();
        
        System.out.print("Hi, " + name + "! How old are you? ");
        int age = read.nextInt();
        
        System.out.println("Did you know that in five years you will be " + (age + 5) + " years old?");
        
        System.out.println("And five years ago you were " + (age - 5) + "! Imagine that!");
        
    }
    
}
