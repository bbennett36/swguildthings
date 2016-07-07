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
public class App {
    public static void main(String[] args) {
        StateCapitals sc = new StateCapitals();
    
        sc.makeMap();
        sc.printStates();
        sc.printCapitals();
        sc.printPairs();
    }
    
   
}
