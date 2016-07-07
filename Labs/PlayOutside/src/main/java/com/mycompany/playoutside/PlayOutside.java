/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.playoutside;

/**
 *
 * @author apprentice
 */
public class PlayOutside {

    /**
     * The children in Cleveland spend most of the day playing outside. In
     * particular, they play if the temperature is between 60 and 90
     * (inclusive). Unless it is summer, then the upper limit is 100 instead of
     * 90. Given an int temperature and a boolean isSummer, return true if the
     * children play and false otherwise.
     * @param temp
     * @param isSummer
     * @return 
     */

    public boolean PlayOutside(int temp, boolean isSummer) {
        
        if (temp >= 60 && temp <= 90) {
            return true;
        } else if (isSummer == true && temp >= 60 && temp <= 100) {
           return true;
        } else {
            return false;
        }
    }

}
