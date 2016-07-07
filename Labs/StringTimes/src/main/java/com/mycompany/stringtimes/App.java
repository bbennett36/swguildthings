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
public class App {
    public static void main(String[] args) {
        StringTimes st = new StringTimes();
        
        String hello = st.StringTimes("Hello", 6);
        System.out.println(hello);
    }
}
