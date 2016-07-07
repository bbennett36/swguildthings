/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.statecapitals22;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author apprentice
 */
public class StateCapitals22 {

    Map<String, Object> mapInfo = new HashMap();

    private String stateName;
    private String capitalName;
    private long population;
    private int squareMilage;


    public void runStateCapitals2() {
        createCapitalObjects();
        printStateInfo();

        long minPop = getUserResponse("Please enter a minimum population:");
        System.out.println("");

        determineStates(minPop);
    }

    public void createCapitalObjects() {
        StateCapitals22 statecaps = new StateCapitals22();
        statecaps.stateName = "Alabama";
        statecaps.capitalName = "Montgomery";
        statecaps.population = 250000;
        statecaps.squareMilage = 2000;
        mapInfo.put(statecaps.stateName, statecaps);
        
        statecaps = new StateCapitals22();
        statecaps.stateName = "Alaska";
        statecaps.capitalName = "Juneau";
        statecaps.population = 3000000;
        statecaps.squareMilage = 1000;
        mapInfo.put(statecaps.stateName, statecaps);
        
        statecaps = new StateCapitals22();
        statecaps.stateName = "Arizona";
        statecaps.capitalName = "Phoenix";
        statecaps.population = 7 - 0000;
        statecaps.squareMilage = 4000;
        mapInfo.put(statecaps.stateName, statecaps);
    }

    public void printStateInfo() {
        Set<String> stateSet = mapInfo.keySet();

        for (String state : stateSet) {
            StateCapitals22 objCapital = (StateCapitals22) mapInfo.get(state);

            System.out.println(objCapital.stateName + ":" + objCapital.capitalName + " population: " + objCapital.population + " square mileage: " + objCapital.squareMilage);
        }
    }

    public long getUserResponse(String inputQuestion) {
        Scanner sc = new Scanner(System.in);

        long userResponse = 0;
        boolean isValid = false;

        System.out.println(inputQuestion);

        while (!isValid) {
            try {
                userResponse = Long.parseLong(sc.nextLine());
                isValid = true;
            } catch (Exception ex) {
                System.out.println(String.format("%s is an invalid number! %s", userResponse, inputQuestion));
            }
        }
        return userResponse;

    }

    public void determineStates(long minpop) {
        Set<String> stateSet = mapInfo.keySet();

        for (String state : stateSet) {
            StateCapitals22 objCapital = (StateCapitals22) mapInfo.get(state);

            long population = objCapital.getPopulation();

            if (population > minpop) {
                System.out.println(state);
            }
        }
    }

    public String getStateName() {
        return this.stateName;
    }

    public String getCapitalName() {
        return this.capitalName;
    }

    public long getPopulation() {
        return this.population;
    }

    public int findSquare() {
        return this.squareMilage;
    }

}
