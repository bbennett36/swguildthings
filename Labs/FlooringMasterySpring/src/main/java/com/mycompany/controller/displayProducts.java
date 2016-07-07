/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.consoleio.ConsoleIO;
import com.mycompany.dao.ProductDao;
import com.mycompany.dao.ProductDaoInterface;
import com.mycompany.dto.Product;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class displayProducts {
    
    ProductDaoInterface pdao;
    ConsoleIO ci = new ConsoleIO();
    
    displayProducts(ProductDaoInterface pdao)   {
        this.pdao = pdao;
    }
    
     public void displayProducts() {
        List<Product> products = pdao.getProducts();

        ci.displayString("-----------------");
        ci.displayString("List of products");
        ci.displayString("-----------------");

        for (Product myProduct : products) {
            ci.displayString("Type:" + myProduct.getProductType() + "|MaterialCostPerSqf:" + myProduct.getMatCostSqf() + "|LaborCostPerSqf:" + myProduct.getLaborCostSqf());
        }

    }
    
}
