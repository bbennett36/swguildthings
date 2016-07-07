/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.variablesandnames;

/**
 *
 * @author apprentice
 */
public class VariablesAndNames {
     public static void main( String[] args )
    {
        int cars, drivers, passengers, cars_not_driven, cars_driven;
        double space_in_a_car, carpool_capacity, average_passengers_per_car;

        //100 cars
        cars = 100;
        //4.0 cars because it is a double data type.
        space_in_a_car = 4.0;
        //30 drivers because it is an int.
        drivers = 30;
        //90 passengers because it is a int.
        passengers = 90;
        //difference between cars and drivers showing number of cars not driven.
        cars_not_driven = cars - drivers;
        //cars driven = drivers because there is 1 car for every driver.
        cars_driven = drivers;
        //capacity = # of seats(space in car), * the number of cars driven.
        carpool_capacity = cars_driven * space_in_a_car;
        // calculate avg passengers by dividing by passengers by cars driven.
        average_passengers_per_car = passengers / cars_driven;


        System.out.println( "There are " + cars + " cars available." );
        System.out.println( "There are only " + drivers + " drivers available." );
        System.out.println( "There will be " + cars_not_driven + " empty cars today." );
        System.out.println( "We can transport " + carpool_capacity + " people today." );
        System.out.println( "We have " + passengers + " to carpool today." );
        System.out.println( "We need to put about " + average_passengers_per_car + " in each car." );
    }
    
    
    
    
}
