/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.askingquestions;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class AskingnQuestions {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        int age, feet, inch;
        double weight;

        System.out.println("How old are you? ");
        age = keyboard.nextInt();

        System.out.println("How many feet are you? ");
        feet = keyboard.nextInt();

        System.out.println("How many inches? ");
        inch = keyboard.nextInt();

        System.out.println("How much do you weigh? ");
        weight = keyboard.nextDouble();

        System.out.println("So you're " + age + " old, " + feet + "'" + inch + "\"" + " tall and " + weight + " heavy.");
    }
}
