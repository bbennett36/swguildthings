/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.dao.AccountDao;
import com.mycompany.dao.CheckingDao;
import com.mycompany.dao.SavingDao;
import com.mycompany.dto.Account;
import com.mycompany.dto.Checking;
import com.mycompany.dto.Savings;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class AccountController {

    ConsoleIO ci = new ConsoleIO();
    Scanner read = new Scanner(System.in);
    SavingDao sdao = new SavingDao();
    CheckingDao cdao = new CheckingDao();
    AccountDao adao = new AccountDao();

    public void run() {
        boolean runAgain = true;
        while (runAgain) {

            ci.displayString("--------------");
            ci.displayString("1. Create Account");
            ci.displayString("2. Access Account");
            int selection = read.nextInt();

            switch (selection) {
                case 1:
                    createAccount();
                    break;
                case 2:
//                    accountMenu();
                    break;
            }

        }

    }

    public void createAccount() {
        List<Account> accounts = adao.getAccounts();

        boolean runAgain = true;
        while (runAgain) {
            ci.displayString("Do you want to make a");
            ci.displayString("1. Saving");
            ci.displayString("2. Checking");
            int selection = read.nextInt();

            switch (selection) {
                case 1:
                    int pin = ci.enterInt("Enter your new pin");
                    double balance = ci.getDouble("Enter starting balance");

                    Account savingAccount = new Savings();
                    savingAccount.setBalance(balance);
                    savingAccount.setPin(pin);
                    adao.create(savingAccount);
                    savingsPin();
                    break;
                case 2:
                    pin = ci.enterInt("Enter your new pin");
                    balance = ci.getDouble("Enter starting balance");

                    Account checkingAccount = new Checking();
                    checkingAccount.setBalance(balance);
                    checkingAccount.setPin(pin);
                    adao.create(checkingAccount);
                    checkingPin();
                    break;
            }
        }

//        int pin = ci.enterInt("Enter your new pin");
//        double balance = ci.getDouble("Enter starting balance");
//
//        Account savingAccount = new Savings();
//        Account checkingAccount = new Checking();
//        savingAccount.setBalance(balance);
//        savingAccount.setPin(pin);
//        Checking newChecking = new Checking();
//        newChecking.setBalance(balance);
//        newChecking.setPin(pin);
//        
//        Savings newSavings = new Savings();
//        newSavings.setBalance(balance);
//        newSavings.setPin(pin);
//        cdao.create(newChecking);
//        sdao.create(newSavings);
    }

    public void savingsPin() {
        List<Account> accounts = adao.getAccounts();

        boolean runAgain = true;
        while (runAgain) {

            ci.displayString("press 1 to conintue, 2 to exit");
            int select = read.nextInt();
            switch (select) {

                case 1:
                    int pin = ci.enterInt("Enter your pin number (0 to exit)");
                    if (pin == 0) {
                        runAgain = false;
                    } else {
                        Account account = adao.get(pin);
                        savingsMenu(account);
                    }
                    break;
                case 2:
                    runAgain = false;
                    break;
                default:
                    ci.displayString("Invalid choice");
                    break;
                            
            }
        }

    }

    public void checkingPin() {
        List<Account> accounts = adao.getAccounts();

         boolean runAgain = true;
        while (runAgain) {

            ci.displayString("press 1 to conintue, 2 to exit");
            int select = read.nextInt();
            switch (select) {

                case 1:
                    int pin = ci.enterInt("Enter your pin number (0 to exit)");
                    if (pin == 0) {
                        runAgain = false;
                    } else {
                        Account account = adao.get(pin);
                        checkingMenu(account);
                    }
                    break;
                case 2:
                    runAgain = false;
                    break;
                default:
                    ci.displayString("Invalid choice");
                    break;
                            
            }
        }

    }

    public void savingsMenu(Account account) {
//        Savings savings = (Savings) account;
//        Savings savings = account;

        boolean runAgain = true;
        while (runAgain) {
            ci.displayString("Balance: " + account.getBalance());
            ci.displayString("Would you like to");
            ci.displayString("1. Deposit");
            ci.displayString("2. Withdraw");
            ci.displayString("3. Exit");
            int selection = read.nextInt();

            switch (selection) {
                case 1:
                    int deposit = ci.enterInt("Enter deposit amount: ");
                    account.deposit(deposit);
                    break;
                case 2:
                    int w = ci.enterInt("Enter withdraw amount: ");
                    account.withdraw(w);
                    break;
                case 3:
                    runAgain = false;
                    break;
                default:
                    ci.displayString("Invalid choice");
                    break;

            }
        }

    }

    public void checkingMenu(Account account) {
//        Savings savings = (Savings) account;
//        Savings savings = account;

        boolean runAgain = true;
        while (runAgain) {
            ci.displayString("Balance: " + account.getBalance());
            ci.displayString("Would you like to");
            ci.displayString("1. Deposit");
            ci.displayString("2. Withdraw");
            ci.displayString("3. Exit");
            int selection = read.nextInt();

            switch (selection) {
                case 1:
                    int deposit = ci.enterInt("Enter deposit amount: ");
                    account.deposit(deposit);
                    break;
                case 2:
                    int w = ci.enterInt("Enter withdraw amount: ");
                    account.withdraw(w);
                    break;
                case 3:
                    runAgain = false;
                    break;
                default:
                    ci.displayString("Invalid choice");
                    break;

            }
        }

    }

}
