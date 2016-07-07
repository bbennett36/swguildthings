/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdmvc.dto;

import java.util.Date;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author apprentice
 */
public class DVD {

    private int id;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date releaseDate;

    @NotEmpty(message = "You must enter a title!")
    private String title;

    @NotEmpty(message = "You must enter a MPAA rating!")
    private String mPAA;

    @NotEmpty(message = "You must enter a directors name!")
    private String directorsName;

    @NotEmpty(message = "You must enter a studio!")
    private String studio;

//    @NotEmpty(message = "You must enter a note!")
//    private String note;

    public int getId() {
        return id;
    }

    public String getDirectorsName() {
        return directorsName;
    }

//    public String getNote() {
//        return note;
//    }

    public Date getReleaseDate() {
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

//    public void setNote(String note) {
//        this.note = note;
//    }

    public void setReleaseDate(Date releaseDate) {
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
