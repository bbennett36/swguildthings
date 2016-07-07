/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.SandPdto.Circle;
import com.mycompany.SandPdto.Rectangle;
import com.mycompany.SandPdto.Square;
import com.mycompany.SandPdto.Triangle;

/**
 *
 * @author apprentice
 */
public class SandPController {
    public static void main(String[] args) {
        
        Square square = new Square(5, 20);
        
        Rectangle r = new Rectangle(3, 18);
        
        Triangle t = new Triangle(5, 10);
        
        Circle c = new Circle(5, 0);
        
        System.out.println("Square");
        square.area();
        square.perimeter();
        
        System.out.println("Rectangle");
        r.area();
        r.perimeter();
        
        System.out.println("Triangle");
        t.area();
        t.perimeter();
        
        System.out.println("Circle");
        c.area();
        c.perimeter();
        
        
        
    }
}
