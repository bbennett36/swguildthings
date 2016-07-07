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
public class Triangle extends Shape {
    
    
     public Triangle(double height, double base)  {
        super(height, base);
    }
    
   
     
    @Override
     public void perimeter()    {
         double perimeter = (height * 2 + this.width) / 2;
         System.out.println("Perimeter: " + perimeter);
     }
     
    @Override
     public void area() {
         double area = (this.width * height) / 2;
         System.out.println("Area: " + area);
     }
    
}
