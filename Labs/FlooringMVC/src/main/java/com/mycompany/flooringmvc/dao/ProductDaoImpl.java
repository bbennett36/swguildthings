/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmvc.dao;

import com.mycompany.flooringmvc.dto.Product;
import com.mycompany.flooringmvc.dto.Tax;
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
public class ProductDaoImpl implements ProductDaoInterface {

    List<Product> products = new ArrayList<>();

     private int getNextId() {
        int result = 0;
        for (Product p : products) {
            if (p.getId() > result) {
                result = p.getId();
            }
        }
        result++;
        return result;
    }

    public ProductDaoImpl() {
        products = decode();
    }

    @Override
    public Product create(Product product) {

        product.setId(getNextId());
        products.add(product);

        encode();

        return product;

    }

    @Override
    public Product get(int id) {

        for (Product myProduct : products) {
            if (myProduct.getId() == id) {
                return myProduct;
            }
        }
        return null;

    }

    @Override
    public void update(Product product) {

        

        products.removeIf(a -> a.getId() == product.getId());
        products.add(product);

        encode();

//        return found;

    }

    @Override
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

            out.println("ID,ProductType,CostPerSquareFoot,LaborCostPerSquareFoot");

            for (Product myProduct : products) {
                
                 out.print(myProduct.getId());
                out.print(TOKEN);

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
//            Logger.getLogger(OrderApp.class.getName()).log(Level.SEVERE, null, ex);
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
//                if(stringParts != [3])  {
//                
//            }
                Product myProduct = new Product();

                int id = Integer.parseInt(stringParts[0]);
                myProduct.setId(id);
                myProduct.setProductType(stringParts[1]);
                double mcs = Double.parseDouble(stringParts[2]);
                myProduct.setMatCostSqf(mcs);
                double lcs = Double.parseDouble(stringParts[3]);
                myProduct.setLaborCostSqf(lcs);

                products.add(myProduct);

            }

        } catch (FileNotFoundException ex) {
//            Logger.getLogger(OrderApp.class.getName()).log(Level.SEVERE, null, ex);
        }

        return products;

    }

    @Override
    public List<Product> getProducts() {
        return products;
    }
}
