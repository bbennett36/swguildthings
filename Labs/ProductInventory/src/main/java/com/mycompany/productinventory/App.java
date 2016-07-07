/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.productinventory;

import com.mycompany.controller.ProductController;

/**
 *
 * @author apprentice
 */
public class App {
    public static void main(String[] args) {
        ProductController pc = new ProductController();
                
                pc.run();
    }
}
