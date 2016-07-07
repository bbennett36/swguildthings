/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.dto.Order;
import com.mycompany.flooring.OrderApp;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author apprentice
 */
public class OrderDao {

    List<Order> orders = new ArrayList();
    Map<String, List<Order>> groupOrders = new HashMap<>();

    private int nextId = 1;

    private int getNextId() {
        int result = 0;
        for (Order myOrder : orders) {
            if (myOrder.getId() > result) {
                result = myOrder.getId();
            }
        }
        result++;
        return result;
    }

    public OrderDao() {
        groupOrders = decode();
    }

    public Order create(Order order) {

        order.setId(getNextId());
        orders.add(order);

        encode();
        return order;

    }

    public Order get(Integer id) {

        for (Order myOrder : orders) {
            if (myOrder.getId() == id) {
                return myOrder;
            }
        }
        return null;

    }

    public Order getDate(String date) {

        for (Order myOrder : orders) {
            if (myOrder.getDate().equals(date)) {
                return myOrder;
            }
        }
        return null;

    }

    public void update(Order order) {

        Order found = null;

        for (Order myOrder : orders) {
            if (myOrder.getDate().equals(order.getDate())) {
                found = myOrder;
            }
        }

        orders.remove(found);
        orders.add(found);

        encode();
    }

    public void updateOrder(Order order) {

        Order found = null;

        for (Order myOrder : orders) {
            if (myOrder.getId() == order.getId()) {
                found = myOrder;
            }
        }

        orders.remove(found);
        orders.add(found);

        encode();
    }

    public void delete(Order order) {

        Order found = null;

        for (Order myOrder : orders) {
            if (myOrder.getId() == order.getId()) {
                found = myOrder;
                break;
            }
        }

        orders.remove(found);

        encode();
    }

    private void encode() {

        final String TOKEN = ",";
//        List<String> dates = new ArrayList();

        Map<String, List<Order>> groupOrders = new HashMap<>();
        for (Order myOrders : orders) {
            DateFormat df = new SimpleDateFormat("ddMMyyyy");
            Date date = myOrders.getDate();
            String reportDate = df.format(date);
            if (groupOrders.containsKey(reportDate)) {
                groupOrders.get(reportDate).add(myOrders);

            } else {
                List<Order> newOrder = new ArrayList();
                newOrder.add(myOrders);
                groupOrders.put(reportDate, newOrder);
            }
        }

        //delete all the files that have no orders
        try {

            for (String date : groupOrders.keySet()) {

                PrintWriter out = new PrintWriter(new FileWriter("Order_" + date + ".txt"));

                out.println("OrderNumber,CustomerName,State,TaxRate,ProductType,Area,CostPerSquareFoot,LaborCostPerSquareFoot,MaterialCost,LaborCost,Tax,Total");

                for (Order myOrder : groupOrders.get(date)) {

//                for (Order myOrder : orders) {
                    out.print(myOrder.getId());
                    out.print(TOKEN);

                    out.print(myOrder.getName());
                    out.print(TOKEN);

                    out.print(myOrder.getState());
                    out.print(TOKEN);

                    out.print(myOrder.getTax());
                    out.print(TOKEN);

                    out.print(myOrder.getProduct());
                    out.print(TOKEN);

                    out.print(myOrder.getArea());
                    out.print(TOKEN);

                    out.print(myOrder.getMatCostSqf());
                    out.print(TOKEN);

                    out.print(myOrder.getLaborCostSqf());
                    out.print(TOKEN);

                    out.print(myOrder.getMaterialCost());
                    out.print(TOKEN);

                    out.print(myOrder.getLaborCost());
                    out.print(TOKEN);

                    out.print(myOrder.getTaxTotal());
                    out.print(TOKEN);

                    out.print(myOrder.getTotal());
                    out.println();

                    out.flush();
                }
                out.close();

            }

        } catch (IOException ex) {
            Logger.getLogger(OrderApp.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    private Map<String, List<Order>> decode() {

        File dir = new File(".");
        File[] files = dir.listFiles((File dir1, String name) -> name.startsWith("Order_"));

        for (File txtfile : files) {

            String fname = txtfile.getName();
//            int index = fname.indexOf(".txt");
            String date = fname.substring(6, 14);

            try {

                Scanner read = new Scanner(new BufferedReader(new FileReader(txtfile)));

                int line = 0;
                while (read.hasNextLine()) {
                    String currentLine = read.nextLine();

                    String[] stringParts = currentLine.split(",");

                    line++;
                    if (line == 1) {
                        continue;
                    }

                    Order myOrder = new Order();

                    int id = Integer.parseInt(stringParts[0]);
                    myOrder.setId(id);
                    myOrder.setName(stringParts[1]);
                    myOrder.setState(stringParts[2]);
//                SimpleDateFormat dateFormat = new SimpleDateFormat("MM-DD-YYYY");
//                Date date2 = null;
//                try {
//                    //Parsing the String
//                    date2 = dateFormat.parse(stringParts[4]);
//                } catch (ParseException e) {
//                    
//                }
//                myOrder.setDate(date2);
                    double tax = Double.parseDouble(stringParts[3]);
                    myOrder.setTax(tax);
                    myOrder.setProduct(stringParts[4]);
                    double area = Double.parseDouble(stringParts[5]);
                    myOrder.setArea(area);
                    double mcs = Double.parseDouble(stringParts[6]);
                    myOrder.setMatCostSqf(mcs);
                    double lcs = Double.parseDouble(stringParts[7]);
                    myOrder.setLaborCostSqf(lcs);
                    double matcost = Double.parseDouble(stringParts[8]);
                    myOrder.setMaterialCost(matcost);
                    double lc = Double.parseDouble(stringParts[9]);
                    myOrder.setLaborCost(lc);
                    double taxtotal = Double.parseDouble(stringParts[10]);
                    myOrder.setTaxTotal(taxtotal);
                    double total = Double.parseDouble(stringParts[11]);
                    myOrder.setTotal(total);
//                    myOrder.setDate(date);

                    orders.add(myOrder);

                }

                groupOrders.put(date, orders);

            } catch (FileNotFoundException ex) {
                Logger.getLogger(OrderApp.class
                        .getName()).log(Level.SEVERE, null, ex);
            }

        }
        return groupOrders;
    }

    public List<Order> getOrders() {
        return orders;
    }

}
