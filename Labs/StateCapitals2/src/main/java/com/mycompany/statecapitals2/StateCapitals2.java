/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.statecapitals2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author apprentice
 */
public class StateCapitals2 {
    public static void main(String[] args) {
        
        
        
        HashMap<String, ArrayList<Object>> statecaps =new HashMap<>();
        
        ArrayList<Object> montgomery = new ArrayList<>();
        
        montgomery.add("Montgomery");
        montgomery.add(10000);
        montgomery.add("100");
        
        ArrayList<Object> juneau = new ArrayList<>();
        
        juneau.add("Juneau");
        juneau.add(20000);
        juneau.add("200");
        
       
       statecaps.put("Alabama", montgomery);
       statecaps.put("Alaska", juneau);
       
       for (Map.Entry<String, ArrayList<Object>> entry : statecaps.entrySet()) {
            String key = entry.getKey();
            ArrayList<Object> values = entry.getValue();
            System.out.println(key + " - " + values);
        }
       
       
//        statecaps.put("Alaska", "Juneau");
//        statecaps.put("Arizona", "Phoenix");
//        statecaps.put("Arkansas", "Little Rock");
//        statecaps.put("California", "Sacramento");
//        statecaps.put("Colorado", "Denver");
//        statecaps.put("Connecticut", "Hartford");
//        statecaps.put("Delaware", "Dover");
//        statecaps.put("Florida", "Tallahassee");
//        statecaps.put("Georgia", "Atlanta");
//            Set<String> keySet = statecaps.keySet();
//            System.out.println("States: ");
//            for (String key : keySet) {
//            System.out.println(key);
//            }
//            System.out.println("");
//     
//
//        Set<ArrayList<String>> values = (Set<ArrayList<String>>) statecaps.values();
//
//         System.out.println("Capitals: ");
//        for (ArrayList<String> value : values) {
//            System.out.println(value);
//        }
        
    }
        
        
        
        
    }
    
    
    
    
    
    
    
//    private String stateName;
//    private long population;
//    private int squareMilage;
//    
//    public StateCapitals2() {
//        
//    }
//    public void runStateCapitals2() {
//        StateCapitals statecaps = new StateCapitals;
//    }
//    
//    public String getStateName()    {
//        return this.stateName;
//    }
//    
//    public long getPopulation() {
//        return this.population;
//    }
//    
//    public int findSquare() {
//        return this.squareMilage;
//    }

