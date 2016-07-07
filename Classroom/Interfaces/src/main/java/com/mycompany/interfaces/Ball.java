/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.interfaces;

/**
 *
 * @author apprentice
 */
public class Ball implements Colorable, Debuggable {
    
    private String color;
    
    public void printStuff()    {
        System.out.println("Hey");
    }
    
    

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public void logError(String error) {
        System.out.println("Logging an error about a ball" + error);
    }
    
    
    
}
