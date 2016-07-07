/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.dao.Inventory;
import com.mycompany.dto.Product;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class ProductController {

    ConsoleIO ci = new ConsoleIO();
    Scanner read = new Scanner(System.in);
    Inventory dao = new Inventory();

    public void run() {
        boolean runAgain = true;
        while (runAgain) {
            ci.displayString("1. Add Product");
            ci.displayString("2. Add stock to existing");
            ci.displayString(("3. Remove stock from existsing"));
            ci.displayString("4. Total value of a product in stock");
            ci.displayString("5. Total value of entire inventory");
            int selection = read.nextInt();

            switch (selection) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    addToExisting();
                    break;
                case 3:
                    removeExisting();
                    break;
                case 4:
                    getValueOfProduct();
                    break;
                case 5:
                    valueOfInventory();
                    break;
                case 6:
                    runAgain = false;
                default:
                    ci.displayString("Invalid choice");
                    break;

            }

        }

    }

    public void addProduct() {

        int id = ci.enterInt("Enter id");
        String name = ci.getWord("Enter product name: ");
        double weight = ci.getDouble("Enter weight: ");
        double price = ci.getDouble("Enter sales price of product: ");
        double quant = ci.getDouble("Enter quantity");

        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setWeight(weight);
        product.setPrice(price);
        product.setQuantity(quant);
        dao.create(product);

    }

    public void addToExisting() {
        List<Product> products = dao.getProducts();

        for (Product p : products) {
            ci.displayString("ID: " + p.getId());
        }

        int id = ci.enterInt("Enter the ID that you want to add to: ");
        for (Product prod : products) {
            if (id == prod.getId()) {
                Product p = dao.get(prod.getId());
                double add = ci.enterInt("How many would you like to add? ");
                dao.addTo(p, add);
            }
        }

    }

    public void removeExisting() {

        List<Product> products = dao.getProducts();

        for (Product p : products) {
            ci.displayString("ID: " + p.getId());
        }

        int id = ci.enterInt("Enter the ID that you want to remove from: ");
        for (Product prod : products) {
            if (id == prod.getId()) {
                Product p = dao.get(prod.getId());
                double remove = ci.enterInt("How many would you like to remove? ");
                dao.removeFrom(p, remove);
            }
        }

    }

    public void getValueOfProduct() {

        List<Product> products = dao.getProducts();

        for (Product p : products) {
            ci.displayString("ID: " + p.getId());
        }

        int id = ci.enterInt("Enter the ID that you want to the value for: ");
        if (dao.get(id) != null) {
            double value = dao.valueOfProduct(id);
            Product get = dao.get(id);
            ci.displayString("Product name: " + get.getName() + " Value of product : " + value);
        } else {
            ci.displayString("ID doesnt exist");
        }

    }
    
    public void valueOfInventory()  {
        
        double value = 0;
        value = dao.valueOfInventory();
        ci.displayString("Value of inventory is: " + value);
    }

}
