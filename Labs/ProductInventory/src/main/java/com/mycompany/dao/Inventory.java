/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.dto.Product;
import com.mycompany.productinventory.App;
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
public class Inventory extends Product {
    
    List<Product> products = new ArrayList();
    
    public Inventory() {
        products = decode();
    }
    
    public Product create(Product product)    {
        List<Product> getInt = getProducts();
        int size = getInt.size();
        
        
//        products.setId(size);
        products.add(product);
        
        encode();
        
        return product;
        
    }
    
    public void addTo(Product product, double quant)  {
        
        for(Product p : products)   {
            if(p.getId() == product.getId())    {
                double result = p.getQuantity() + quant;
                p.setQuantity(result);
            }
        }
        encode();
        
    }
    
    public void removeFrom(Product product, double quant)  {
        
        for(Product p : products)   {
            if(p.getId() == product.getId())    {
                if(quant < p.getQuantity()) {
                double result = p.getQuantity() - quant;
                p.setQuantity(result);
                }
            }
        }
        encode();
        
    }
    
    public Product get(Integer id) {
        
        for(Product p : products)   {
            if(p.getId() == id)   {
                return p;
            }
        }
        return null;
    }
    
    public void update(Product product)  {
        
        Product found = null;
        
        for(Product p : products)    {
            if(p.getId() == product.getId())   {
                found = p;
            }
        }
        
        products.remove(found);
        products.add(found);
        
        encode();
        
    }
    
    public double valueOfProduct(int id)   {
        
        double value = 0;
        for(Product p : products)   {
            if(p.getId() == id)    {
                value = p.getQuantity() * p.getPrice();
            }
        }
        return value;
        
    }
    
    public double valueOfInventory()   {
        
        double value = 0;
        for(Product p : products)   {
                value += p.getQuantity() * p.getPrice();
        }
        return value;
        
    }
    
    public void delete(Product product)    {
        
        for(Product p : products)  {
            if(p.getId() == product.getId())   {
                products.remove(p);
            }
        }
        
        encode();
        
    }
    
    
    
    private void encode() {

        final String TOKEN = "::";

        try {
            PrintWriter out = new PrintWriter(new FileWriter("products.txt"));

            for (Product p : products) {
                out.print(p.getId());
                out.print(TOKEN);

                out.print(p.getName());
                out.print(TOKEN);

                out.print(p.getWeight());
                out.print(TOKEN);

                out.print(p.getPrice());
                out.print(TOKEN);

                out.print(p.getQuantity());
                out.println();
                
                 out.flush();
            }

           
            out.close();

        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private List<Product> decode() {

        List<Product> products = new ArrayList<>();

        try {
            Scanner read = new Scanner(new BufferedReader(new FileReader("products.txt")));

            while (read.hasNextLine()) {
                String currentLine = read.nextLine();

                String[] stringParts = currentLine.split("::");

                Product myProduct = new Product();

                int gid = Integer.parseInt(stringParts[0]);
                myProduct.setId(gid);
                myProduct.setName(stringParts[1]);
                double w = Double.parseDouble(stringParts[2]);
                myProduct.setWeight(w);
                double p = Double.parseDouble(stringParts[3]);
                myProduct.setPrice(p);
                double q = Double.parseDouble(stringParts[4]);
                myProduct.setQuantity(q);
                

                products.add(myProduct);

            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

        return products;

    }
    

    public List<Product> getProducts() {
        return products;
    }
    
    
    
    
}
