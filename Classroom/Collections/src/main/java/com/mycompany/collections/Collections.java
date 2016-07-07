/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author apprentice
 */
public class Collections {

    public static void main(String[] args) {

        List myList = new ArrayList();

        myList.add(1);
        myList.add(23);

        Iterator it32 = myList.iterator();

        while (it32.hasNext()) {
            int value = (int) it32.next();
            System.out.println(value);
        }

        for (Object value : myList) {
            System.out.println(value);
        }

        List<String> stringList = new ArrayList();

        stringList.add("Jones");
        stringList.add("Sally");
        //stringList.add(1);

        for (String myString : stringList) {
            System.out.println(myString);
        }

        Iterator<String> it = stringList.iterator();

        while (it.hasNext()) {
            String theString = it.next();
        }

        System.out.println("");
        stringList.remove(1);

        int size = stringList.size();

        System.out.println(size);

        boolean exists = stringList.contains("Jones");

        Map<String, Integer> populations = new HashMap();

        //myMap.put(1, "x");
        //myMap.put("x", 2);
        populations.put("USA", 30000000);
        populations.put("Canada", 30000000);
        populations.put("UK", 60000000);
        populations.put("Japan", 13000000);

        System.out.println("Map size is: " + populations.size());

        int usaValue = populations.get("USA");
        System.out.println("Usa population: " + usaValue);

        Set<String> keySet = populations.keySet();

        Iterator iterator = keySet.iterator();

        /**
         * Loop the iterator until we reach the last element of the HashMap
         */
        while (iterator.hasNext()) {
            /**
             * next() method returns the next key from Iterator instance. return
             * type of next() method is Object so we need to do DownCasting to
             * String
             */
            String key = (String) iterator.next();

            /**
             * once we know the 'key', we can get the value from the HashMap by
             * calling get() method
             */
            Integer value = (Integer) statecaps.get(key);

            System.out.println("Key: " + key + ", Value: " + value);
        }
            for (String key : keySet) {
                int value = populations.get(key);
                System.out.println(key);
            }

            Collection<Integer> values = populations.values();

            for (Integer value : values) {
                System.out.println(value);
            }
        }

    

    private List<String> getStringList() {

        List<String> myStringList = new ArrayList();
        return myStringList;
    }

}
