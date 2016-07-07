/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dice;

import java.util.Random;

/**
 *
 * @author apprentice
 */
public class Dice {
    public static void main(String[] args) {
        System.out.println("HERE COMES THE DICE!");
        int total = rollDice();
        System.out.println("Total is: " + total);
    }
    public static int rollDice()   {
        Random r = new Random();
        int dice1 = (1 + r.nextInt(6));
        System.out.println("Roll #1: " + dice1);
        int dice2 = (1 + r.nextInt(6));
        System.out.println("Roll #2: " + dice2);
        return dice1 + dice2;
    }
}
