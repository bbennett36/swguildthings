/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.SandPdto;

/**
 *
 * @author apprentice
 */
public class Circle extends Shape {
    
    private final double pi = 3.14;
    double r = this.height / 2;
    
     public Circle(double height, double width)  {
        super(height, width);
    }
     
    @Override
     public void perimeter()    {
         double perimeter = 2 * pi * r;
         System.out.println("Perimeter" + perimeter);
     }
     
    @Override
     public void area() {
         double area = pi*(r*r);
         System.out.println("Area: " + area);
     }
    
}
