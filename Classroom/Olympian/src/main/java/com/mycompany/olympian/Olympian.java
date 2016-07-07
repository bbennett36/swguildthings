/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.olympian;

/**
 *
 * @author apprentice
 */
public class Olympian {
 
    private Event event;
    private String country = "USA";
    
    public Olympian(Event event, String filename)   {
        this.event = event;
        System.out.println("My filename is: " + filename);
    }
    
    public String competeInEvent()  {
        System.out.println("Now competeing for " + country + ":");
        return event.compete();
    }
    
    public void setCountry(String country)  {
        this.country = country;
    }
    
    //construction injection
    //property/setter injection
    
}
