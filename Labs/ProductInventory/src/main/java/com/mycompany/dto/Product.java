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
public class Product {
    
    protected int id;
    protected String name;
    protected double weight;
    protected double price;
    protected double quantity;
    
    
    
    public Product(int id)  {
        this.id = id;
    }
    
    public Product()    {
        
    }
    
    public double getValue(double price, double quantity)    {
        double value = price * quantity;
        return value;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
    

    public void setWeight(double weight) {
        this.weight = weight;
    }


    public double getWeight() {
        return weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getQuantity() {
        return quantity;
    }
    
    
    
    
    
}
