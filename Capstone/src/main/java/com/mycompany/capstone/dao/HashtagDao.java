/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.capstone.dao;

import com.mycompany.capstone.dto.Hashtag;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface HashtagDao {
    
    public Hashtag create(Hashtag hashtag);
    public Hashtag getById(int id);
    public Hashtag getByTag(String tag);
    public void update(Hashtag hashtag);
    public void delete(Hashtag hashtag);
    public int getCount(String tag);
    public List<Hashtag> listHashtags();
    
}
