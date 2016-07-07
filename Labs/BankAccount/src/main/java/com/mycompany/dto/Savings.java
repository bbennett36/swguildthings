/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dto;

/**
 * w
 *
 * @author apprentice
 */
public class Savings extends Account {
//

    private double interest = 0;
    private double penalty = 0;
//    private double balance;

    public Savings() {

    }

    public Savings(Integer pin) {
        super(pin);
    }

    @Override
    public double withdraw(double money) {
        if (money > balance) {
            System.out.println("You do not have enough money!");
            return balance;
        } else {
            balance += interest;
            balance -= penalty;
            super.withdraw(money);
            return balance;

        }
    }

    @Override
    public double deposit(double money) {
        super.deposit(money);
        return balance;
    }

}
