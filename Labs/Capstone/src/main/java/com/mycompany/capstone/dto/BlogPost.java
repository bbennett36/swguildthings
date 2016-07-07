/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.capstone.dto;

import java.util.Date;

/**
 *
 * @author apprentice
 */
public class BlogPost {
    
    private int id;
    private String title;
    private String body;
    private int imageId;
    private Date startDate;
    private Date expirationDate;
    private int authorId;
    private int statusId;
    private int categoryId;
    private Date creationDate;
    private int lastModifiedBy;
    private Date lastModifiedDate;

    public int getAuthorId() {
        return authorId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public int getId() {
        return id;
    }

    public int getImageId() {
        return imageId;
    }

    public int getLastModifiedBy() {
        return lastModifiedBy;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public int getStatusId() {
        return statusId;
    }

    public String getTitle() {
        return title;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public void setLastModifiedBy(int lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
    
    
   
    
}
