/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.elseandif;

/**
 *
 * @author apprentice
 */
public class ElseAndIf {

    public static void main(String[] args) {
        int people = 30;
        int cars = 40;
        int buses = 15;

        if (cars > people) {
            System.out.println("We should take the cars."); //if more cars than people print statement
        } if (cars < people) { //deleting the else here runs this if and the else after instead of running all 3 at the same time.
            System.out.println("We should not take the cars."); //if more people than cars then print statement
        } else {
            System.out.println("We can't decide.");//if theres not more cars then people or more people than cars then print statement
        }

        if (buses > cars) {
            System.out.println("That's too many buses."); //if theres more buses than cars then prine statement
        } else if (buses < cars) {
            System.out.println("Maybe we could take the buses."); //if theres more cars than buses then print statemennt
        } else {
            System.out.println("We still can't decide."); //if theres not more buses than cars or more cars than buses then print this statement
        }

        if (people > buses) {
            System.out.println("All right, let's just take the buses."); //if more people than buses then print statement
        } else {
            System.out.println("Fine, let's stay home then.");//if theres not more people than buses then print this
        }
    }
}
