/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.capstone.dao;

import com.mycompany.capstone.dto.Category;
import java.util.List;


/**
 *
 * @author apprentice
 */
public interface CategoryDao {
    
    public Category create(Category category);
    public Category get(int id);
    public void update(Category category);
    public void delete(Category category);
    public List<Category> listCategories();
    
}
