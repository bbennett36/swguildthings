/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author apprentice
 */
public class Lambdas {

    static List<Address> addresses = new ArrayList();

    public static void main(String[] args) {

        Address one = new Address();
        one.setCity("Akron");
        one.setStreetAddress("343 Main st");

        addresses.add(one);

        Address two = new Address();
        two.setCity("Cleveland");
        two.setStreetAddress("343 Wall st");

        addresses.add(two);

        Address three = new Address();
        three.setCity("Pittsburgh");
        three.setStreetAddress("343 First st");

        addresses.add(three);

        List<Address> results = findAddresssesInCity("Cleveland");
        
        List<Address> results2 = findAddressesInCityLambda("Akron");
        for(Address r : results2)   {
            System.out.println(r.getCity());
        }

    }

    public static List<Address> findAddresssesInCity(String city) {

        List<Address> results = new ArrayList();

        for (Address a : addresses) {
            if (a.getCity().equals(city)) {
                results.add(a);
            }

            if (a.getStreetAddress().contains("Wall")) {
                results.add(a);
            }
        }
        return results;

    }

    public static List<Address> findAddressesInCityLambda(String city) {

//        addresses.stream().filter((Address a) -> {
//            return a.getCity().equals(city);
//        }
//        );
//        addresses
//                .stream()
//                .filter(a -> a.getCity().equals(city))
//                .forEach(e -> System.out.println(e.getCity()));

        return addresses
                .stream()
                .filter(a -> a.getCity().equals(city))
                .collect(Collectors.toList());

    }

}
