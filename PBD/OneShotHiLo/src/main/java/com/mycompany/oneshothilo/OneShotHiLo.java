/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.oneshothilo;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class OneShotHiLo {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        System.out.println("Im thinking of a number between 1-100, try to guess it:");
        int userNum = read.nextInt();
        int compNum = getRand();
        if (userNum > compNum) {
            System.out.println("Sorry you guessed too high, I was thinking " + compNum);
        } else if (userNum < compNum) {
            System.out.println("Sorry you guessed too low, I was thinking " + compNum);
        }
        else if(userNum == compNum)   {
            System.out.println("You guessed it! What are the odds?");
        }
        else    {
            System.out.println("ERROR");
        }
    }

    public static int getRand() {
        Random r = new Random();
        int rnum = (1 + r.nextInt(100));
        return rnum;
    }
}
