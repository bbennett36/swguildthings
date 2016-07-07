/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.league.dto;

/**
 *
 * @author apprentice
 */
public class Player {
    
    private String fName;
    private String lName;
    private int id;
    private double bAvg;

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }
    
    public int getId() {
        return id;
    }

    public String getfName() {
        return fName;
    }

    public double getbAvg() {
        return bAvg;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setbAvg(double bAvg) {
        this.bAvg = bAvg;
    }

   
    
}
