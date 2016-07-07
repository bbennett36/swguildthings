/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmvc.dao;

import com.mycompany.flooringmvc.dto.Product;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface ProductDaoInterface {
    
    public Product create(Product product);

    public Product get(int id);

    public void update(Product product);

    public void delete(Product product);
    
    public List<Product> getProducts();
    
}
