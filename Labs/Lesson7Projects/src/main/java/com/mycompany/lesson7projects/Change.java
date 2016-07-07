/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lesson7projects;

/**
 *
 * @author apprentice
 */
public class Change {
    
    private int remain;
    private int dollars;
    private int quarters;
    private int nickels;
    private int dimes;
    private int pennies;
    
    public void getChange(double balance)  {
        remain = (int) (balance * 100);
        calculateDollars();
        System.out.println("Dollars:  " + dollars);
        calculateQuarters();
        System.out.println("Quarters: " + quarters);
        calculateDimes();
        System.out.println("Dimes:    " + dimes);
        calculateNickels();
        System.out.println("Nickels:  " + nickels);
        calculatePennies();
        System.out.println("Pennies:  " + pennies);
    }
    
    public int calculateDollars()   {
        dollars = remain / 100;
        remain = remain % 100;
        return dollars;
    }
    
    public int calculateQuarters()  {
        quarters = remain / 25;
        remain = remain % 25;
        return quarters;
    }
    
    public int calculateDimes() {
        dimes = remain / 10;
        remain = remain % 10;
        return dimes;
    }
    
    public int calculateNickels()   {
        nickels = remain / 5;
        remain = remain % 5;
        return nickels;
    }
    
    public int calculatePennies()   {
        pennies = remain;
        return pennies;
    }

    public int getDimes() {
        return dimes;
    }

    public int getNickels() {
        return nickels;
    }

    public int getPennies() {
        return pennies;
    }

    public int getQuarters() {
        return quarters;
    }

    public int getDollars() {
        return dollars;
    }
    
    
    
    
}
