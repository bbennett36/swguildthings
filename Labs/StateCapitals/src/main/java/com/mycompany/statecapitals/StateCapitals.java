/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.statecapitals;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author apprentice
 */
public class StateCapitals {

    Map<String, String> statecaps = new HashMap();
    public Map<String, String> makeMap() {

        statecaps.put("Alabama", "Montgomery");
        statecaps.put("Alaska", "Juneau");
        statecaps.put("Arizona", "Phoenix");
        statecaps.put("Arkansas", "Little Rock");
        statecaps.put("California", "Sacramento");
        statecaps.put("Colorado", "Denver");
        statecaps.put("Connecticut", "Hartford");
        statecaps.put("Delaware", "Dover");
        statecaps.put("Florida", "Tallahassee");
        statecaps.put("Georgia", "Atlanta");
        return statecaps;
    }

    public void printStates() {
        Set<String> keySet = statecaps.keySet();
        System.out.println("States: ");
        for (String key : keySet) {
            System.out.println(key);
        }
        System.out.println("");
    }

    public void printCapitals() {
        Collection<String> values = statecaps.values();

        System.out.println("Capitals: ");
        for (String value : values) {
            System.out.println(value);
        }
        System.out.println("");
    }

    public void printPairs() {
        Set<String> keySet = statecaps.keySet();
        Iterator iterator = keySet.iterator();

        System.out.println("State/Capital Pairs: ");

        while (iterator.hasNext()) {

            String key = (String) iterator.next();

            String value = (String) statecaps.get(key);

            System.out.println(key + " - " + value);
        }
    }

}
