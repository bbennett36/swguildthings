/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.arrays;

/**
 *
 * @author apprentice
 */
public class Arrays {
    public static void main(String[] args) {
        
        //10 games, random scores.
        //min/max/average
        int count = 0;
       
        int prevnum = 0;
        
        int[] scores = {
            55, 23, 54, 61, 69, 70, 98, 87, 73, 100
        };
        
        int min = scores[1];
        int max = scores[1];
        for (int num : scores)  {
            System.out.println("Element: " + num);
            count = count + num;  
            while(num < min)   {
                min = num;
            }
            while(num > max)    {
                max = num;
            }
        }
        int avg = count / scores.length;
        System.out.println("Average: " + avg);
        System.out.println("Minimum: " + min);
        System.out.println("Maximum: " + max);
        
    }
}
