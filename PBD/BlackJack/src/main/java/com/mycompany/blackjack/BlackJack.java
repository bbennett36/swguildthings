/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.blackjack;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class BlackJack {
    
//    int one = 1;
//    int two = 2;
//    int three = 3;
//    int four = 4;
//    int five = 5;
//    int six = 6;
//    int seven = 7;
//    int eight = 8;
//    int nine = 9;
//    int ten = 10;
//    int jack = 10;
//    int queen = 10;
//    int[] king = {1,11};
    
    public void run()   {
       int userTotal = userTotal();
       int dealerTotal = dealerTotal();
       int newuTotal = userHit(userTotal);
       int newdTotal = dealerHit(dealerTotal);
       displayWinner(newuTotal, newdTotal);
    }
    
    
        Scanner read = new Scanner(System.in);
        Random r = new Random();
        String dHit = "yes";
        
        public int userTotal()  {
        int uCard1 = 1 + r.nextInt(11);
        int uCard2 = 1 + r.nextInt(11);
        int uTotal = uCard1 + uCard2;
        System.out.println("Card 1: " + uCard1);
        System.out.println("Card 2: " + uCard2);
        System.out.println("Total = " + uTotal);
        return uTotal;
        }
        
        public int dealerTotal()    {
        int dCard1 = 1 + r.nextInt(11);
        int dCard2 = 1 + r.nextInt(11);
        int dTotal = dCard1 + dCard2;
        System.out.println("Dealer Card 1: " + dCard1);
        return dTotal;
        }
        
        public int userHit(int uTotal)    {
        System.out.print("Would you like to hit? (\"yes\" or \"no\") ");
        String hit = read.nextLine();
        while(hit.equals("yes")) {
            int rCard = 1 + r.nextInt(11);
            uTotal += rCard;
            if(uTotal > 21) {
                System.out.println("Total = " + uTotal);
                System.out.println("You Busted!");
                uTotal = 0;
                dHit = "no";
                break;
            }
            else if(uTotal == 21)   {
                System.out.println("Total = " + uTotal + "! Blackjack!");
                break;  
            }
            else    {
                System.out.println("Total = " + uTotal);
                System.out.print("Would you like to hit? (\"yes\" or \"no\") ");
                hit = read.nextLine();
            }
        }
        return uTotal;
        }
        
        public int dealerHit(int dTotal)    {
        while(dHit.equals("yes"))   {
            int rCard = 1 + r.nextInt(11);
            dTotal += rCard;
            if(dTotal < 17) {
                dHit = "yes";
            }
            else if (dTotal > 21)   {
                System.out.println("Dealer Busted!");
                dTotal = 0;
                break;
            }
            else    {   
                break;
            }
        }
        return dTotal;
        }
        
        public void displayWinner(int uTotal, int dTotal) {
        System.out.println("User Total = " + uTotal);
        System.out.println("Dealer Total = " + dTotal);
        if(uTotal > dTotal) {
            System.out.println("User Wins!");
        }
        else    {
            System.out.println("Dealer Wins!");
        }   
        }
}
   