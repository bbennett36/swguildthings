/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class ConsoleIO {
    Scanner read = new Scanner(System.in);
    String snum;

//    public void runGame()   {
//        enterInt("Enter a number: ");
//        validMinMax("Enter a number between 1-10: ");
//        getWord("Enter a word: ");
//        getFloat("Enter a float: ");
//        validFloat("Enter a float between 0.0 - 10.0: ");
//        getDouble("Enter a double: ");
//        validDouble("Enter a double between 0-10: ");
//        displayString("Print a word: ");
    

    public int enterInt(String prompt) {
        System.out.println(prompt);
        snum = read.nextLine();
        int num = Integer.parseInt(snum);
        return num;
    }

    public int validMinMax(String prompt) {
        int min = 0;
        int max = 10;
        System.out.println(prompt);
        snum = read.nextLine();
        int num2 = Integer.parseInt(snum);
        while (num2 < min || num2 > max) {
            System.out.println(prompt);
            snum = read.nextLine();
            num2 = Integer.parseInt(snum);
        }
        return num2;
    }

    public String getWord(String prompt) {
        System.out.println(prompt);
        String word = read.nextLine();
        return word;
    }

    public float getFloat(String prompt) {
        System.out.println(prompt);
        snum = read.nextLine();
        float dec = Float.parseFloat(snum);
        return dec;
    }

    public float validFloat(String prompt) {
        float fmin = 0.0f;
        float fmax = 10.0f;
        System.out.println(prompt);
        snum = read.nextLine();
        float userFloat = Float.parseFloat(snum);
        while (userFloat < fmin || userFloat > fmax) {
            System.out.println(prompt);
            snum = read.nextLine();
            userFloat = Float.parseFloat(snum);
        }
        return userFloat;
    }

    public double getDouble(String prompt) {
        System.out.println(prompt);
        snum = read.nextLine();
        double userD = Double.parseDouble(snum);
        return userD;
    }

    public double validDouble(String prompt) {
        double dMin = 0.0;
        double dMax = 10.0;
        System.out.println(prompt);
        snum = read.nextLine();
        double dob2 = Double.parseDouble(snum);
        while (dob2 < dMin || dob2 > dMax) {
            System.out.println(prompt);
            snum = read.nextLine();
            dob2 = Double.parseDouble(snum);
        }
        return dob2;
    }

    public void displayString(String prompt) {
        System.out.println(prompt);
//        String something = read.nextLine();
//        System.out.println(something);
        
    }
}
