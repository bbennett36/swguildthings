/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdmvc.dto;

import java.util.List;

/**
 *
 * @author apprentice
 */
public class Note {
    
    private int id;
    private int movieId;
    private String note;

    public void setId(int id) {
        this.id = id;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

  
    public int getId() {
        return id;
    }

    public int getMovieId() {
        return movieId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    
    
    
}
