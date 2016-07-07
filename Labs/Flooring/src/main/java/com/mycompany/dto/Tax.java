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
public class Tax {
    
    private int id;
    private String state;
    private double taxRate;

    public int getId() {
        return id;
    }

    public String getState() {
        return state;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }
    
    
}
