/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.dto.Product;
import com.mycompany.flooring.OrderApp;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author apprentice
 */

public class ProductDao {

    List<Product> products = new ArrayList<>();

    private int nextId = 1;

    public ProductDao() {
        products = decode();
    }

    public Product create(Product product) {

//        product.setId(nextId);
//        nextId++;
        products.add(product);

        encode();

        return product;

    }

    public Product get(String type) {

        for (Product myProduct : products) {
            if (myProduct.getProductType().equals(type)) {
                return myProduct;
            }
        }
        return null;

    }

    public void update(Product product) {

        Product found = null;

        for (Product myProduct : products) {
            if (myProduct.getProductType().equals(product.getProductType())) {
                found = myProduct;
            }
        }

        products.remove(found);
        products.add(found);

        encode();
    }

    public void delete(Product product) {

        Product found = null;

        for (Product myProduct : products) {
            if (myProduct.getProductType().equals(product.getProductType())) {
                found = myProduct;
                break;
            }
        }

        products.remove(found);

        encode();
    }

    private void encode() {

        final String TOKEN = ",";

        try {
            PrintWriter out = new PrintWriter(new FileWriter("Products.txt"));

            out.println("ProductType,CostPerSquareFoot,LaborCostPerSquareFoot");
            
            for (Product myProduct : products) {

                out.print(myProduct.getProductType());
                out.print(TOKEN);

                out.print(myProduct.getMatCostSqf());
                out.print(TOKEN);

                out.print(myProduct.getLaborCostSqf());
                out.println();
                
                out.flush();

            }

           
            out.close();

        } catch (IOException ex) {
            Logger.getLogger(OrderApp.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private List<Product> decode() {

        List<Product> products = new ArrayList();

        try {
            Scanner read = new Scanner(new BufferedReader(new FileReader("Products.txt")));

            int line = 0;
            
            while (read.hasNextLine()) {
                String currentLine = read.nextLine();

                
                String[] stringParts = currentLine.split(",");

                line++;
                if (line == 1) {
                    continue;
                }
                
                Product myProduct = new Product();
                
                
                myProduct.setProductType(stringParts[0]);
                double mcs = Double.parseDouble(stringParts[1]);
                myProduct.setMatCostSqf(mcs);
                double lcs = Double.parseDouble(stringParts[2]);
                myProduct.setLaborCostSqf(lcs);

                products.add(myProduct);

            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(OrderApp.class.getName()).log(Level.SEVERE, null, ex);
        }

        return products;

    }

    public List<Product> getProducts() {
        return products;
    }

}
