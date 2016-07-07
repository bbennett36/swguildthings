/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.littlequiz;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class LittleQuiz {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        System.out.println("Are you ready to take this quiz?");
        String answer = read.nextLine();

        System.out.println("Okay, here it comes!");

        System.out.println("Q1) What is the best programming language? (Type answer #)");
        System.out.println("1. .Net");
        System.out.println("2. Ruby");
        System.out.println("3. Java");
        System.out.println("4. Python");
        int answer1 = read.nextInt();

        int correct = 0;
        int total = 0;

        if (answer1 == 3) {
            System.out.println("Correct! Of course java is the best!");
            correct++;
            total++;
        } else {
            System.out.println("Incorrect! Java is the best");
            total++;
        }

        System.out.println("Are if and else statements fun? (Type answer #) ");
        System.out.println("1. Yes");
        System.out.println("2. No");
        int answer2 = read.nextInt();

        if (answer2 == 1) {
            System.out.println("Thats correct!");
            correct++;
            total++;
        } else {
            System.out.println("Incorrect! You dont like if else statements!?");
            total++;
        }

        System.out.println("What is the best job you can have? (Type answer #) ");
        System.out.println("1. Accountant");
        System.out.println("2. Software Developer");
        System.out.println("3. Cashier");
        System.out.println("4. Construction Worker");
        int answer3 = read.nextInt();

        if (answer3 == 2) {
            System.out.println("Correct!");
            correct++;
            total++;
        } else {
            System.out.println("Incorrect! Are you crazy?");
            total++;
        }

        System.out.println("Overall you got " + correct + " out of " + total + " correct");
        System.out.println("Thanks for playing!");
    }
}
