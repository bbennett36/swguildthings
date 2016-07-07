/*
 * To change this license header, choose License Headers in Project Properties.w
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.consoleio.ConsoleIO;
import com.mycompany.dao.ProductDao;
import com.mycompany.dao.ProductDaoInterface;
import com.mycompany.dao.TaxesDao;
import com.mycompany.dao.TaxesInterface;
import com.mycompany.dto.Product;
import com.mycompany.dto.Tax;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class AdminController {
    ConsoleIO ci = new ConsoleIO();
    Scanner read = new Scanner(System.in);
    ProductDaoInterface pdao;
    TaxesInterface tdao;
    displayProducts d;
    displayTaxes dt;
    
    public AdminController(ProductDaoInterface pdao, TaxesInterface tdao, displayProducts d, displayTaxes dt)   {
        this.pdao = pdao;
        this.tdao = tdao;
        this.d = d;
        this.dt = dt;
    }
    
    
    public void adminMenu() {
        boolean runAgain = true;
        while (runAgain) {

            ci.displayString("-------------------------------");
            ci.displayString("          Admin Panel");
            ci.displayString("-------------------------------");
            ci.displayString("What do you want to edit?");
            ci.displayString("1. Products");
            ci.displayString("2. Taxes");
            ci.displayString("3. Exit Admin Panel");
            ci.displayString("-------------------------------");
            int select = read.nextInt();

            switch (select) {
                case 1:
                    productMenu();
                    break;
                case 2:
                    taxesMenu();
                    break;
                case 3:
                    runAgain = false;
                    break;
                default:
                    ci.displayString("Invalid choice!");
                    break;
            }
        }
    }

    public void productMenu() {
        boolean runAgain = true;
        while (runAgain) {

            ci.displayString("---------------------------------");
            ci.displayString("          Product Menu");
            ci.displayString("---------------------------------");
            ci.displayString("Please choose an option below: ");
            ci.displayString("1. Display Products");
            ci.displayString("2. Add Product");
            ci.displayString("3. Edit Product");
            ci.displayString("4. Remove Product");
            ci.displayString("5. Return to Admin Panel");
            ci.displayString("---------------------------------");

            int selection = read.nextInt();
            switch (selection) {
                case 1:
                    d.displayProducts();
                    break;
                case 2:
                    addProduct();
                    break;
                case 3:
                    editProduct();
                    break;
                case 4:
                    removeProduct();
                    break;
                case 5:
                    runAgain = false;
                    break;
                default:
                    ci.displayString("Invalid choice!");
                    runAgain = true;
                    break;
            }
        }

    }

   

    public void addProduct() {

        String type = ci.getWord("Enter Product Type: ");
        double mat = ci.getDouble("Enter Material cost per sq ft: ");
        double lab = ci.getDouble("Enter Labor cost per sq ft: ");

        Product myProduct = new Product();
        myProduct.setProductType(type);
        myProduct.setMatCostSqf(mat);
        myProduct.setLaborCostSqf(lab);
        pdao.create(myProduct);

    }

    public void editProduct() {
        List<Product> products = pdao.getProducts();

        ci.displayString("-----------------");
        ci.displayString("List of products");
        ci.displayString("-----------------");

        for (Product myP : products) {
            ci.displayString(myP.getProductType());
        }

        String search = ci.getWord("Enter the product type that you want to edit");


                Product myProduct = pdao.get(search);
                if(myProduct != null)   {
                String type = ci.getWord("Enter Product Type: ");
                double mat = ci.getDouble("Enter Material cost per sq ft: ");
                double lab = ci.getDouble("Enter Labor cost per sq ft: ");

                myProduct.setProductType(type);
                myProduct.setMatCostSqf(mat);
                myProduct.setLaborCostSqf(lab);
                pdao.update(myProduct);
                } else  {
                    ci.displayString("This product does not exist!");
                }

    }

    public void removeProduct() {
        List<Product> products = pdao.getProducts();

        ci.displayString("-----------------");
        ci.displayString("List of products");
        ci.displayString("-----------------");

        for (Product myP : products) {
            ci.displayString(myP.getProductType());
        }

        String search = ci.getWord("Enter the product type that you want to delete");

        Product delete = new Product();
        delete.setProductType(search);
        pdao.delete(delete);

    }

    public void taxesMenu() {
        boolean runAgain = true;
        while (runAgain) {

            ci.displayString("--------------------------------");
            ci.displayString("            Tax Menu");
            ci.displayString("--------------------------------");
            ci.displayString("Please choose an option below: ");
            ci.displayString("1. Display Tax Rates");
            ci.displayString("2. Add State & Tax Rate");
            ci.displayString("3. Edit State & Tax Rate");
            ci.displayString("4. Remove State");
            ci.displayString("5. Return to Admin Panel");
            ci.displayString("--------------------------------");

            int selection = read.nextInt();
            switch (selection) {
                case 1:
                    dt.displayTaxes();
                    break;
                case 2:
                    addTaxes();
                    break;
                case 3:
                    editTax();
                    break;
                case 4:
                    removeTax();
                    break;
                case 5:
                    runAgain = false;
                    break;
                default:
                    ci.displayString("Invalid choice!");
                    break;
            }
        }
    }

   

    public void addTaxes() {

        String state = ci.getWord("Enter State Abbreviation: ");
        state = state.toUpperCase();
        double rate = ci.getDouble("Enter Tax Rate: ");

        Tax t = new Tax();
        t.setState(state);
        t.setTaxRate(rate);
        tdao.create(t);

    }

    public void editTax() {
        List<Tax> taxes = tdao.getTaxes();

        ci.displayString("-----------------");
        ci.displayString("List of Tax Rates");
        ci.displayString("-----------------");

        for (Tax t : taxes) {
            ci.displayString(t.getState());
        }

        String search = ci.getWord("Enter the State that you want to edit");
        search = search.toUpperCase();


                Tax newTax = tdao.get(search);
                if(newTax != null)  {
                String state = ci.getWord("Enter State Abbreviation: ");
                state = state.toUpperCase();
                double rate = ci.getDouble("Enter Tax Rate: ");

                newTax.setState(state);
                newTax.setTaxRate(rate);
                tdao.update(newTax);
                } else  {
                    ci.displayString("State doesnt exist!");
                }

    }

    public void removeTax() {
        List<Tax> taxes = tdao.getTaxes();

        ci.displayString("-----------------");
        ci.displayString("List of Tax Rates");
        ci.displayString("-----------------");

        for (Tax t : taxes) {
            ci.displayString(t.getState());
        }

        String search = ci.getWord("Enter the state that you want to delete");
        search = search.toUpperCase();

        Tax delete = new Tax();
        delete.setState(search);
        tdao.delete(delete);
    }
    
}
