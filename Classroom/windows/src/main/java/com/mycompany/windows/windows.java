/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.windows;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class windows {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        double glassPrice = 3.50;
        double trimPrice = 2.25;
        String stringHeight, stringWidth, stringPay;
        double area, height, width, cost, cost2, perimeter, cost3, pay, totalw;
        final double MAX_WINDOW_HEIGHT = 25.5;
        final double MAX_WINDOW_WIDTH = 18.75;
        final double MIN_WINDOW_HEIGHT = 1.0;
        final double MIN_WINDOW_WIDTH = 1.0;

        System.out.println("What is the height: ");
        stringHeight = reader.nextLine();
        height = Double.parseDouble(stringHeight);
        
        while(height > MAX_WINDOW_HEIGHT || height < MIN_WINDOW_HEIGHT)   {
            System.out.println("Your height is invalid, try again: ");
            stringHeight = reader.nextLine();
            height = Double.parseDouble(stringHeight);
        }

        System.out.println("What is the width: ");
        stringWidth = reader.nextLine();
        width = Double.parseDouble(stringWidth);
        
        while(width > MAX_WINDOW_WIDTH || width < MIN_WINDOW_WIDTH)   {
            System.out.println("Your width is invalid, try again: ");
            stringWidth = reader.nextLine();
            width = Double.parseDouble(stringWidth);
        }

        area = height * width;
        cost = glassPrice * area;
        perimeter = (height * 2) + (width * 2);
        cost2 = perimeter * trimPrice;
        cost3 = cost + cost2;

        System.out.println("Height: " + height);
        System.out.println("Width: " + width);
        System.out.println("Area: " + area);
        System.out.println("Perimeter: " + perimeter);

        System.out.println("The cost of the window: " + cost);
        System.out.println("The cost of the trim is: " + cost2);
        System.out.println("Total cost: " + cost3);

        System.out.println("How much do you want to pay");
        stringPay = reader.nextLine();

        pay = Double.parseDouble(stringPay);

        totalw = Math.floor(pay / cost3);

        System.out.println("You can buy: " + totalw + " windows");

    }

}
