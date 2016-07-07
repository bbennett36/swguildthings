/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankaccount;

import com.mycompany.controller.AccountController;

/**
 *
 * @author apprentice
 */
public class App {
    public static void main(String[] args) {
        AccountController ac = new AccountController();
        
        ac.run();
        
        
    }
}
