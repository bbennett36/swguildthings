/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.capstone.dao;

import com.mycompany.capstone.dto.BlogPost;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface BlogPostDao {
    
    
    public BlogPost create(BlogPost blogPost);
    public BlogPost get(int id);
    public void update(BlogPost blogPost);
    public void delete(BlogPost blogPost);
    public List<BlogPost> listPosts();
    
}
