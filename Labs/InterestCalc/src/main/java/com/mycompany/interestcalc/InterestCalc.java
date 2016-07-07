/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.interestcalc;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class InterestCalc {

    public static void main(String[] args) {

        Console console = new Console();

        double qRate = console.quaRate();

        double principle = console.getPrinciple();

        int years = console.getYears();

        int yearCount = 1;

        console.run(yearCount, years, qRate, principle);

    }
}
