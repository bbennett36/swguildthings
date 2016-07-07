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
public abstract class Account {

    protected int pin;
    protected double balance;

    public Account(int pin) {
        this.pin = pin;
    }

    public Account() {

    }

    public double deposit(double money) {
        if (money >= 10000) {
            System.out.println("We contacted the bank manager to clear the\n"
                    + "deposit and will not allow them to withdraw any of that money");
            return balance;
        } else {
            this.balance += money;
            return balance;
        }
    }

    public double withdraw(double money) {
        balance -= money;
        return balance;
    }

    public double getBalance() {
        return balance;
    }

    public int getPin() {
        return pin;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

}
