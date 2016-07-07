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
public class Rectangle extends Shape {
    
     public Rectangle(double height, double width)  {
        super(height, width);
    }
     
     @Override
     public void perimeter()    {
         double perimeter = (this.height * 2) + (this.width * 2);
         System.out.println("Perimeter: " + perimeter);
     }
     
     @Override
     public void area() {
         double area = (this.width * this.height);
         System.out.println("Area: " + area);
     }
    
}
