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
public class RPS implements Game {

    Scanner read = new Scanner(System.in);


    Random generator = new Random();

    public void run() {

        int userWins = 0;
        int ties = 0;
        int compWins = 0;

        String playAgain;

        do {

            int played = 0;

            System.out.print("How many rounds do you want to play? (1-10):");
            int rounds = read.nextInt();

            while (rounds < 1 || rounds > 10) {
                System.out.print("Invalid number of rounds. Try again: ");
                rounds = read.nextInt();
            }

            while (played < rounds) {

                System.out.print("Choose 1.Rock 2.Paper 3.Scisscors (Please type number):");
                int num = read.nextInt();
                int answer = validInput(num);

                int comp = generator.nextInt(2) + 1;

                if (answer == comp) {
                    System.out.println("Tie!");
                    ties++;
                } else if (answer == 1 && comp == 2) {
                    System.out.println("Computer wins!");
                    compWins++;
                } else if (answer == 1 && comp == 3) {
                    System.out.println("User wins!");
                    userWins++;
                } else if (answer == 2 && comp == 1) {
                    System.out.println("User wins!");
                    userWins++;
                } else if (answer == 2 && comp == 3) {
                    System.out.println("Computer wins!");
                    compWins++;
                } else if (answer == 3 && comp == 1) {
                    System.out.println("Computer wins!");
                    compWins++;
                } else if (answer == 3 && comp == 2) {
                    System.out.println("User wins!");
                    userWins++;
                } else {
                    System.out.println("Invalid choice");
                }

                played++;

            }

            displayWins(userWins, compWins, ties);

            findWinner(userWins, compWins);

            userWins = 0;
            ties = 0;
            compWins = 0;

            System.out.println("Do you want to play again? (\"yes\" or \"no\") ");
            playAgain = read.next();
        } while (playAgain.equals("yes"));
        System.out.println("Thanks for playing!");

    }

    public int validInput(int num) {
        while (num < 1 || num > 3) {
            System.out.print("Choose 1.Rock 2.Paper 3.Scisscors (Please type number):");
            num = read.nextInt();
        }
        return num;
    }

    public void displayWins(int userWins, int compWins, int ties) {
        System.out.println(" ");
        System.out.println("User Wins: " + userWins);
        System.out.println("Computer Wins: " + compWins);
        System.out.println("Number of ties: " + ties);
    }

    public void findWinner(int userWins, int compWins) {
        if (userWins > compWins) {
            System.out.println("User is the overall winner!");
        } else if (compWins > userWins) {
            System.out.println("Computer is the overall winner!");
        } else {
            System.out.println("User and Computer tied!");
        }
    }

    @Override
    public String getName() {
        return "RPSGame";
    }
}
