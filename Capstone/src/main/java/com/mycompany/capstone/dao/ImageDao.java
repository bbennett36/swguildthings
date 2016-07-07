/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.capstone.dao;


import com.mycompany.capstone.dto.Image;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface ImageDao {
    public Image create(Image adminPageImage);
    public Image get(int id);
    public void update(Image adminPageImage);
    public void delete(Image adminPageImage);
    public List<Image> listImages();
    
}
