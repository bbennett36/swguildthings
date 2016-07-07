/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.simpleprogrammer;

/**
 *
 * @author apprentice
 */
public class SimpleCalculator {

    int num1;
    int num2;
    int total;

    public int addition(int num1, int num2) {
        total = num1 + num2;
        return total;
    }

    public int subtraction(int num1, int num2) {
        total = num1 - num2;
        return total;
    }
    
    public int multipication(int num1, int num2)    {
        total = num1 * num2;
        return total;
    }
    
    public int division(int num1, int num2) {
        total = num1 / num2;
        return total;
    }

}
