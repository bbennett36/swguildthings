/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tip;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class tip {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        
        System.out.println("Enter amount");
        String sAmount = read.nextLine();
        
        double amount = Double.parseDouble(sAmount);
        
        System.out.println("Enter tip percent");
        String sTip = read.nextLine();
        double tipPercent = Double.parseDouble(sTip);
        tipPercent = tipPercent / 100;
        double tip = tipPercent * amount;
        double total = tip + amount;
        
        System.out.println("Tip is " + tip + "total is" + total);
    }
}
