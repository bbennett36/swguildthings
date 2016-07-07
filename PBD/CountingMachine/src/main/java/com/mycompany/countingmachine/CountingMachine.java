/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.countingmachine;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class CountingMachine {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        System.out.print("Count to: ");
        int num = read.nextInt();
        
        for(int i = 0; i <= num; i++)    {
            System.out.println(i);
        }
    }
}
