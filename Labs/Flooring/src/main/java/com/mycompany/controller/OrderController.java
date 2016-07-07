/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.dao.OrderDao;
import com.mycompany.dto.Order;
import com.mycompany.dao.ProductDao;
import com.mycompany.dao.TaxesDao;
import com.mycompany.dto.Product;
import com.mycompany.dto.Tax;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class OrderController {

    OrderDao dao = new OrderDao();
    ProductDao pdao = new ProductDao();
    TaxesDao tdao = new TaxesDao();
    AdminController ac = new AdminController();
    ConsoleIO ci = new ConsoleIO();
    Order order = new Order();
    Scanner read = new Scanner(System.in);
    File f = null;
    
    public OrderController(OrderDao dao, ProductDao pdao, TaxesDao tdao)    {
        this.dao = dao;
        this.pdao = pdao;
        this.tdao = tdao;
    }
    
    

    public void run() {
        boolean runAgain = true;
        while (runAgain) {

            ci.displayString("-------------------------------");
            ci.displayString("           Order Menu");
            ci.displayString("-------------------------------");
            ci.displayString("Please choose an option below: ");
            ci.displayString("1. Display Orders");
            ci.displayString("2. Add Order");
            ci.displayString("3. Edit Order");
            ci.displayString("4. Remove Order");
            ci.displayString("5. Save Order");
            ci.displayString("6. Exit");
            ci.displayString("7. Enter Admin Panel");
            ci.displayString("-------------------------------");
            int selection = read.nextInt();

            switch (selection) {
                case 1:
                    displayOrders();
                    break;
                case 2:
                    addOrder();
                    break;
                case 3:
                    editOrder();
                    break;
                case 4:
                    removeOrder();
                    break;
                case 5:
//                    test();
                    break;
                case 6:
                    runAgain = false;
                    break;
                case 7:
                    String password = ("bennett");
                    String upass = ci.getWord("Enter password: ");
                    if (upass.equals(password)) {
                        ac.adminMenu();
                    } else {
                        ci.displayString("Incorret password, returning to menu...");
                    }

            }

        }
    }

    public void displayOrders() {
        List<Order> orders = dao.getOrders();

        String search = ci.getWord("Enter a date to search: ");
        for (Order myOrder : orders) {
            if (search.equals(myOrder.getDate())) {
                ci.displayString("|Id:" + myOrder.getId() + "       |FName:" + myOrder.getName() + "        |State: " + myOrder.getState() + "       |Tax" + myOrder.getTax() + "        |ProductType:" + myOrder.getProduct()
                        + "     |Area: " + myOrder.getArea() + "     |LaborCost" + myOrder.getLaborCost()
                        + "     |LaborCostSqF: " + myOrder.getLaborCostSqf() + "        |MatCostSqF:" + myOrder.getMatCostSqf() + "     |MaterialCost" + myOrder.getMaterialCost()
                        + "     |Tax:" + myOrder.getTax() + "       |Total:" + myOrder.getTotal());
            }
        }
    }

    public void addOrder() {
        List<Tax> taxes = tdao.getTaxes();
        List<Product> products = pdao.getProducts();

        SimpleDateFormat df = new SimpleDateFormat("ddMMyyyy");
        Date date = null;
        String sdate = ci.getWord("Enter date: (MMDDYYYY)");
         try {
            date = df.parse(sdate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String name = ci.getWord("Enter Name: ");
        String state = ("");
        boolean stateTrue = false;
        while (!stateTrue) {
            state = ci.getWord("Enter state: ");
            state = state.toUpperCase();
            for (Tax myTaxes : taxes) {
                if (state.equals(myTaxes.getState())) {
                    stateTrue = true;
                }
            }
        }

        double tax = tdao.getTax(state);
        boolean typeTrue = false;
        String type = ("");
        while (!typeTrue) {
            type = ci.getWord("Enter product type:");
            for (Product p : products) {
                if (type.equals(p.getProductType())) {
                    typeTrue = true;
                }
            }
        }

        double results[] = getCosts(type);

        Double area = ci.getDouble("Area: ");

        double mcs = results[0];
        double lcs = results[1];
        double lc = Math.ceil(lcs * area);
        double mc = Math.ceil(mcs * area);
        double pretotal = Math.ceil(lc + mc);
        double ttax = tax / 100;
        double taxtotal = pretotal * ttax;

        Double total = pretotal + taxtotal;

        Order myOrder = new Order();
        myOrder.setName(name);
        myOrder.setProduct(type);
        myOrder.setState(state);
        myOrder.setArea(area);
        myOrder.setDate(date);
        myOrder.setLaborCost(lc);
        myOrder.setLaborCostSqf(lcs);
        myOrder.setMatCostSqf(mcs);
        myOrder.setMaterialCost(mc);
        myOrder.setTax(tax);
        myOrder.setTaxTotal(taxtotal);
        myOrder.setTotal(total);

        String commit = ci.getWord("Are you sure you want to make this order? (y/n)");
        commit = commit.toLowerCase();
        if (commit.equals("y")) {
            dao.create(myOrder);
            ci.displayString("Order was created!");
        } else {
            ci.displayString("Going back to menu....");
        }
        

    }

    public void editOrder() {
        List<Order> orders = dao.getOrders();
        List<Tax> taxes = tdao.getTaxes();
        List<Product> products = pdao.getProducts();

        for (Order o : orders) {
            ci.displayString("|ID:" + o.getId() + "  |Date:" + o.getDate());
        }

        int orderId = ci.enterInt("Enter an order ID to edit: ");

        String udate = ci.getWord("Enter a date to search: ");

        Order myOrder = dao.get(orderId);
        Order date2 = dao.getDate(udate);

        if (myOrder != null && date2 != null) {

            String date = ci.getWord("Enter date: (MM/DD/YYYY)");

            String name = ci.getWord("Enter Name: ");
            String state = ("");
            boolean stateTrue = false;
            while (!stateTrue) {
                state = ci.getWord("Enter state: ");
                state = state.toUpperCase();
                for (Tax myTaxes : taxes) {
                    if (state.equals(myTaxes.getState())) {
                        stateTrue = true;
                    }
                }
            }

            double tax = tdao.getTax(state);
            boolean typeTrue = false;
            String type = ("");
            while (!typeTrue) {
                type = ci.getWord("Enter product type:");
                for (Product p : products) {
                    if (type.equals(p.getProductType())) {
                        typeTrue = true;
                    }
                }
            }

            double results[] = getCosts(type);

            Double area = ci.getDouble("Area: ");

            double mcs = results[0];
            double lcs = results[1];
            double lc = Math.ceil(lcs * area);
            double mc = Math.ceil(mcs * area);
            double pretotal = Math.ceil(lc + mc);
            double ttax = tax / 100;
            double taxtotal = pretotal * ttax;

            Double total = pretotal + taxtotal;

            myOrder.setName(name);
            myOrder.setProduct(type);
            myOrder.setState(state);
            myOrder.setArea(area);
//            myOrder.setDate(date);
            myOrder.setLaborCost(lc);
            myOrder.setLaborCostSqf(lcs);
            myOrder.setMatCostSqf(mcs);
            myOrder.setMaterialCost(mc);
            myOrder.setTax(tax);
            myOrder.setTaxTotal(taxtotal);
            myOrder.setTotal(total);

            dao.update(myOrder);
        } else {
            ci.displayString("Order doesnt exist!");
        }

    }

    public void removeOrder() {
        List<Order> orders = dao.getOrders();
        
        for(Order o : orders)   {
            ci.displayString("|ID:" + o.getId() + "  |Date:" + o.getDate());
        }
        

        int orderSearch = ci.enterInt("Enter an order ID to delete: ");
        String date = ci.getWord("Enter a date to delete: ");

        Order myOrder = new Order();
        myOrder.setId(orderSearch);
//        myOrder.setDate(date);
        dao.delete(myOrder);

    }

    public void saveOrder() {

    }

    

    public double[] getCosts(String type) {
        List<Product> produtcs = pdao.getProducts();

        double mcs = 0;
        double lcs = 0;
        
        for (Product myProduct : produtcs) {
            if (type.equals(myProduct.getProductType())) {
                mcs = myProduct.getMatCostSqf();
                lcs = myProduct.getLaborCostSqf();
            }
        }

        return new double[]{mcs,lcs};

    }

    

}
