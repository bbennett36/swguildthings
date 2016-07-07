/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.methods;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class Methods {
    public static void main(String[] args) {
//        helloWorld();
//        
//        
//        double pi = calculatePi();
//        System.out.println(pi);
//        
//        doNothing(5);
//        
//        int sum = add(1,2);
//        
//        sum = add(3,4);
//        
//        System.out.println(sum);
//        
//        
        int operand1 = getUserInt("Entner the first number to be added: ");
        int operand2 = getUserInt("Enter the second number to be added: ");
        
        System.out.println(operand1 + operand2);
        
    }
    
    public static void helloWorld()    {
        System.out.println("Hello world");
    }
    
    public static double calculatePi() {
        return 3.145;
    }
    
    public static void doNothing(int silly)    {
        
    }
    
    public static int add1And1()   {
        return 1 + 1;
    }
    
    public static int add1And2()   {
        return 1 + 2;
    }
    
    public static int add(int number1, int number2)    {
        return number1 + number2;
    }
    
    
    
    public static int getUserInt(String prompt)  {
        Scanner read = new Scanner(System.in);
        System.out.println(prompt);
        String userInput = read.nextLine();
        int input = Integer.parseInt(userInput);
        
        if (input > 0)  {
            int otherInput = input;
        }
        
       
        
        
        return input;
    }
    
    
    
    
    
}
