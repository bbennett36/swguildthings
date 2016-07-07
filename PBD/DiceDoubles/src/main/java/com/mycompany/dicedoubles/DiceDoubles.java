/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dicedoubles;

import java.util.Random;

/**
 *
 * @author apprentice
 */
public class DiceDoubles {

    public static void main(String[] args) {
        System.out.println("HERE COMES THE DICE!");
        System.out.println("");
        Random r = new Random();

        int dice1 = (1 + r.nextInt(6));
        System.out.println("Roll #1: " + dice1);
        int dice2 = (1 + r.nextInt(6));
        System.out.println("Roll #2: " + dice2);

        int total = dice1 + dice2;
        System.out.println("Total is: " + total);

        while (dice1 != dice2) {
            System.out.println("");
            dice1 = (1 + r.nextInt(6));
            System.out.println("Roll #1: " + dice1);
            dice2 = (1 + r.nextInt(6));
            System.out.println("Roll #2: " + dice2);
            total = dice1 + dice2;
            System.out.println("Total is: " + total);
        }
    }

}
