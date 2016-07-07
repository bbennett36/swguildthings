/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lesson7projects;

//import com.mycompany.dao.InventoryDao;
//import com.mycompany.dto.Change;
//import com.mycompany.dto.Item;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class VendingController implements RunProjects {

    Scanner read = new Scanner(System.in);
    ConsoleIO ci = new ConsoleIO();
    InventoryDao dao = new InventoryDao();
    Change ch = new Change();
    double balance = 0;

    public void run() {

        boolean runAgain = true;
        while (runAgain) {
            ci.displayString("**********************************************************************");
            displayInventory();
            ci.displayString("**********************************************************************");
            displayBalance();
            ci.displayString("");
            ci.displayString("Please choose an option below: ");
            ci.displayString("1. Put money in");
            ci.displayString("2. Select Item");
            ci.displayString("3. Refund Money");
            ci.displayString("4. Exit");
            int selection = read.nextInt();

            switch (selection) {
                case 1:
                    inputMoney();
                    break;
                case 2:
                    selectItem();
                    break;
                case 3:
                    refundMoney();
                    break;
                case 4:
                    runAgain = false;
                    break;
            }

        }
    }

    public void inputMoney() {

        balance = ci.getDouble("How much money would you like to put in?");

    }

    public void displayBalance() {
        ci.displayString("Balance: " + balance);
    }

    public void displayInventory() {

        List<Item> items = dao.getItems();

        for (Item myItem : items) {
            if (myItem.getQuanity() > 0) {
                ci.displayString("|#" + myItem.getId() + "          |Item:" + myItem.getItemName() + "          |Cost:"
                        + myItem.getItemCost() + "          |Quantity:" + myItem.getQuanity());
            }

        }
    }

    public void selectItem() {

        List<Item> items = dao.getItems();
        int id = ci.enterInt("Choose selection # for the item you want to purchase: ");

        for (Item myItem : items) {
            if (id == myItem.getId()) {
                if (balance >= myItem.getItemCost()) {
                    dao.removeItem(myItem);
                    balance = balance - myItem.getItemCost();
                } else {
                    ci.displayString("You do not have sufficient funds to buy this item!");
                }
            }
        }

    }

    public void refundMoney() {
        ci.displayString("Your refund amount: " + balance);
        ch.getChange(balance);
        balance = 0;
    }

    @Override
    public String getName() {
        return "VendingMachine";
    }

}
