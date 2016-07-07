/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.converter;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class converter {

    public static void main(String[] args) {
        ConsoleIO ci = new ConsoleIO();
        Scanner read = new Scanner(System.in);

        ci.displayString("Choose converter");
        ci.displayString("1.USD to EURO/EURO to USD");
        ci.displayString("2.C to F/ F to C");
        ci.displayString("3.Pound to KG/KG to LB ");
        int selection = read.nextInt();

        switch (selection) {
            case 1:
                currency();
                break;
            case 2:
                temp();
                break;
            case 3:
        }
    }

    public static void temp() {

        ConsoleIO ci = new ConsoleIO();
        Scanner read = new Scanner(System.in);

        ci.displayString("Convert:");
        ci.displayString("1. F to C");
        ci.displayString("2. C to F");
        int selection = read.nextInt();

        double f;
        double c;

        DecimalFormat df2 = new DecimalFormat("");
        switch (selection) {
            case 1:
                f = ci.enterInt("Enter Fahrenheit temperature");
                c = calcFtoC(f);
                ci.displayString("Fahrenheit: " + df2.format(f));
                ci.displayString("Celsius: " + df2.format(c));
                break;
            case 2:
                c = ci.enterInt("Enter Celsius temperature");
                f = calcCtoF(c);
                ci.displayString("Celsius: " + df2.format(c));
                ci.displayString("Fahrenheit: " + df2.format(f));
                break;
        }
    }

    public static double calcFtoC(double f) {
        double c = (f - 32) * 5 / 9;
        return c;
    }

    public static double calcCtoF(double c) {
        double f = Math.round(c * 1.8 + 32);
        return f;
    }

    public static void currency() {

        ConsoleIO ci = new ConsoleIO();
        Scanner read = new Scanner(System.in);

        double euro;
        double dollars;

        ci.displayString("Convert:");
        ci.displayString("1. dollars to euros");
        ci.displayString("2. euros to dollars");
        int selection = read.nextInt();

//        DecimalFormat df = new DecimalFormat(".##");
        DecimalFormat df2 = new DecimalFormat(".00");
        switch (selection) {
            case 1:
                dollars = ci.getDouble("Enter USD amount");
                euro = calcDtE(dollars);
                ci.displayString("Dollars: " + df2.format(dollars));
                ci.displayString("Euros: " + df2.format(euro));
                break;
            case 2:
                euro = ci.getDouble("Enter Euro amount");
                dollars = calcEtD(euro);
                ci.displayString("Euros: " + df2.format(euro));
                ci.displayString("Dollars: " + df2.format(dollars));
                break;
        }
    }

    public static double calcDtE(double dollars) {
        double euro = dollars * 0.898154;
        return euro;
    }

    public static double calcEtD(double euro) {
        double dollars = euro * 1.11160021521;
        return dollars;
    }
}
