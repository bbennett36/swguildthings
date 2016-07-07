/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.week1projects;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class LuckySevensApp implements Game {

    Scanner read = new Scanner(System.in);

 
    public void run() {

        System.out.println("How many dollars do you have? ");
        int bet = read.nextInt();

        int rolls = 0;
        int maxMoney = 0;
        int maxRolls = 0;

        while (bet > 0) {
            if (bet > maxMoney) {
                maxMoney = bet;
                maxRolls = rolls;
            }
            int total = rollDice();
            if (total == 7) {
                bet += 4;
            } else {
                bet -= 1;
            }

            rolls++;
        }

        System.out.println("You are broke after " + rolls + " rolls");
        System.out.println("You should of quit after " + maxRolls + " rolls when you had $" + maxMoney);
    }

    public int rollDice() {
        Random generator = new Random();
        int dice1 = generator.nextInt(6) + 1;
        int dice2 = generator.nextInt(6) + 1;
        int total = dice1 + dice2;
        return total;
    }

    @Override
    public String getName() {
        return "LuckySevens";
    }
}
