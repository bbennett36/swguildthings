/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.consoleio.ConsoleIO;
import com.mycompany.dao.OrderDaoImpl;
import com.mycompany.dao.OrderDaoInterface;
import com.mycompany.dto.Order;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class displayOrders {
    
    OrderDaoInterface dao;
    ConsoleIO ci = new ConsoleIO();
    
    public displayOrders(OrderDaoInterface dao)    {
        this.dao = dao;
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
//        getTime();
    }
    
}
