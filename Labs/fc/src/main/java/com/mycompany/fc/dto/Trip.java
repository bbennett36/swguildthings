/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fc.dto;

/**
 *
 * @author apprentice
 */
public class Trip {
    
    private int id;
    private int busId;
    private String destCity;

    public void setBusId(int busId) {
        this.busId = busId;
    }

    public void setDestCity(String destCity) {
        this.destCity = destCity;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBusId() {
        return busId;
    }

    public String getDestCity() {
        return destCity;
    }

    public int getId() {
        return id;
    }
    
    
    
    
}
