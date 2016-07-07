/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.dto.Product;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface ProductDaoInterface {
    
    public Product create(Product product);

    public Product get(String type);

    public void update(Product product);

    public void delete(Product product);
    
    public List<Product> getProducts();
    
}
