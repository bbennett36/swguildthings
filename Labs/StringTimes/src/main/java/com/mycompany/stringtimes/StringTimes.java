/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stringtimes;

/**
 *
 * @author apprentice
 */
public class StringTimes {
    //Given a string and a non-negative int n, return a larger string that is n copies of the original string. 

    public String StringTimes(String str, int n) {
            String str2 = str;
        for (int i = 1; i < n; i++) {
            str2 += str;
        }
        return str2;
    }
}
