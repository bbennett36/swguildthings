/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dto;

/**
 *
 * @author apprentice
 */
public class Checking extends Account {

    private final int OVERDRAFT = -100;

    public Checking() {

    }

    public Checking(int pin) {
        super(pin);
    }

    @Override
    public double withdraw(double money) {
        if((balance - money) - 10 > OVERDRAFT)  {
            if(money > balance) {
                 super.withdraw(money);
                 balance = balance - 10;
                 return balance;
            }
            else    {
                super.withdraw(money);
                return balance;
            }
        }
        else    {
            System.out.println("You cannot overdraft more then $100!");
            return balance;
        }

    }

    @Override
    public double deposit(double money) {
        super.deposit(money);
        return balance;
    }

}
