/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.luckysevens;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author apprentice
 */
public class LuckySevens {

    public static void main(String[] args) {
        
        Console console = new Console();
        
        int bet = console.getBet();
        
        console.run(bet);
        
    }
}
