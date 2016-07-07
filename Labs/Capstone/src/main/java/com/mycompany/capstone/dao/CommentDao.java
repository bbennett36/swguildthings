/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.capstone.dao;

import com.mycompany.capstone.dto.Comment;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface CommentDao {
    
    public Comment create(Comment comment);
    public Comment get(int id);
    public void update(Comment comment);
    public void delete(Comment comment);
    public List<Comment> listComments();
    
}
