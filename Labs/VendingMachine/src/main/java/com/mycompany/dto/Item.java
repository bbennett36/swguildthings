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
public class Item {
    
    private int id;
    private String itemName;
    private double itemCost;
    private int quanity;

    public int getId() {
        return id;
    }

    public double getItemCost() {
        return itemCost;
    }

    public String getItemName() {
        return itemName;
    }

    public int getQuanity() {
        return quanity;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setItemCost(double itemCost) {
        this.itemCost = itemCost;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setQuanity(int quanity) {
        this.quanity = quanity;
    }
    
    
}
