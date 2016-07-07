/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.objectbasics;

/**
 *
 * @author apprentice
 */
public class ObjectBasics {

    public static void main(String[] args) {

        BankAccount account = new BankAccount(56);
        account.deposit(45);
    

        double currentBalance = account.getBalance();
        System.out.println(currentBalance);

    }
}
