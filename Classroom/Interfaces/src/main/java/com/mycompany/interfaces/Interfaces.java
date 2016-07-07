/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.interfaces;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class Interfaces {
    public static void main(String[] args) {
        
        Ball ball = new Ball();
        ball.printStuff();
        
        Colorable ball2 = new Ball();
        Colorable tv = new Television();
        
        ball2.setColor("Green");
        tv.setColor("Black");
        
        List<Colorable> list = new ArrayList();
        
        for (Colorable item : list) {
            printColor(item);
        }
        
        Debuggable debugBall = ball;
        
        debugBall.logError("Ball error");
        
        Colorable colorableBall = ball;
        
        
    }
    
    public static void printColor(Colorable item)  {
        System.out.println("My color is: " + item.getColor());
    }
    
}
