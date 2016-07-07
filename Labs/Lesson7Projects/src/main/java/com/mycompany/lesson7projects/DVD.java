/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lesson7projects;

import java.util.Date;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class DVD {
    
    private int id;
    private String title;
    private String releaseDate;
    private String mPAA;
    private String directorsName;
    private String studio; 
    private String note;

    public int getId() {
        return id;
    }

    public String getDirectorsName() {
        return directorsName;
    }

    public String getNote() {
        return note;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getStudio() {
        return studio;
    }

    public String getTitle() {
        return title;
    }

    public String getmPAA() {
        return mPAA;
    }

    public void setDirectorsName(String directorsName) {
        this.directorsName = directorsName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setmPAA(String mPAA) {
        this.mPAA = mPAA;
    }
    
    
}
