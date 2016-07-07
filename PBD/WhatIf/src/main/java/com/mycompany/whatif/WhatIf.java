/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.whatif;

/**
 *
 * @author apprentice
 */
public class WhatIf {

    public static void main(String[] args) {
        int people = 20;
        int cats = 30;
        int dogs = 15;

        if (people == cats) {
            System.out.println("Too many cats!  The world is doomed!");
        }
        //if more cats than dogs then print statement
        if (people == cats) {
            System.out.println("Not many cats!  The world is saved!");
        }
        //if more people than cats then print statement
        if (people < dogs) {
            System.out.println("The world is drooled on!");
        }
        //if more dogs than people then print statement
        if (people > dogs) {
            System.out.println("The world is dry!");
        }
        //if more people than dogs then print statement
        dogs += 5;
        
        if (people >= dogs) {
            System.out.println("People are greater than or equal to dogs.");
        }
        //if people are greater than or equal too dogs then print statement
        if (people <= dogs) {
            System.out.println("People are less than or equal to dogs.");
        }
        //if dogs are greater than or equal too people then print statement
        if (people == dogs) {
            System.out.println("People are dogs.");
        }
        //if same number of people and dogs then people are dogs
        
        //the curly braces are used after the if statement too execute code if the if statement is true
        
    }
}
