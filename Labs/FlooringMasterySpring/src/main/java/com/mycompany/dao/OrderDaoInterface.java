/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.dto.Order;
import java.util.List;
import java.util.Map;

/**
 *
 * @author apprentice
 */
public interface OrderDaoInterface {
//
//// private int getNextId();
//
////    public OrderDao();
//
    public Order create(Order order);

    public Order get(Integer id);

    public Order getDate(String date);

    public Order update(Order order);

    public void updateOrder(Order order);

    public Order delete(Order order);

    public List<Order> getOrders();

    public Map<String, List<Order>> getGroupOrders();
}
