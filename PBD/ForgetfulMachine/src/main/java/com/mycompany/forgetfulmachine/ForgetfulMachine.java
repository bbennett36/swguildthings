/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.forgetfulmachine;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class ForgetfulMachine {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Give me a word!");
        reader.nextLine();
      
        System.out.println("Give me another word!");
        reader.nextLine();
        
        System.out.println("Great, now your favorite number?");
        reader.nextLine();
        System.out.println("And your second-favorite number...");
        reader.nextLine();
        
        System.out.println("Whew!  Wasn't that fun?");
    }
}
