/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fc.dto;

import java.util.List;

/**
 *
 * @author apprentice
 */
public class Bus {
    
    private int id;
    private int numOfSeats;
    private String tripType;
    private String destCity;
    private List<Passenger> passengers;

    public int getNumOfSeats() {
        return numOfSeats;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setNumOfSeats(int numOfSeats) {
        this.numOfSeats = numOfSeats;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public String getDestCity() {
        return destCity;
    }

    public void setDestCity(String destCity) {
        this.destCity = destCity;
    }
    
    public int getId() {
        return id;
    }
    
    public String getTripType() {
        return tripType;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void setTripType(String tripType) {
        this.tripType = tripType;
    }
    
    
}
