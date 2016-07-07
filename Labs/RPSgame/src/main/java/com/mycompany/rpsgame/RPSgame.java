/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rpsgame;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author apprentice
 */
public class RPSgame {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        Random generator = new Random();

        int rock = 1;
        int paper = 2;
        int scissors = 3;

        System.out.println("Choose 1.Rock 2.Paper 3.Scisscors(Please type number) :");
        int answer = read.nextInt();

        int comp = generator.nextInt(2) + 1;
        
        if(answer == 1 && comp == 1)    {
            System.out.println("Tie!");
        }
        else if(answer == 1 && comp == 2)   {
            System.out.println("Computer wins!");
        }
        else if(answer == 1 && comp == 3)   {
            System.out.println("User wins!");
        }
        else if(answer == 2 && comp == 1)   {
            System.out.println("User wins!");
        }
        else if(answer == 2 && comp == 2)   {
            System.out.println("Tie!");
        }
        else if(answer == 2 && comp == 3)   {
            System.out.println("Computer wins!");
        }
        else if(answer == 3 && comp == 11)   {
            System.out.println("Computer wins!");
        }
        else if(answer == 3 && comp == 2)   {
            System.out.println("User wins!");
        }
        else if(answer == 3 && comp == 3)   {
            System.out.println("Tie!");
        }
        else    {
            System.out.println("Invalid choice");
        }
    }
}
