/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.countingmachinerevisited;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class CountingMachineRevisited {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        System.out.print("Count from: ");
        int num1 = read.nextInt();
        System.out.print("Count to:");
        int num2 = read.nextInt();
        
        for(int i = num1; i <= num2; i++)   {
            System.out.println(i);
        }
    }
}
