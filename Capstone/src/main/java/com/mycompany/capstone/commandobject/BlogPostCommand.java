/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.capstone.commandobject;

import com.mycompany.capstone.dto.Category;
import com.mycompany.capstone.dto.Hashtag;
import com.mycompany.capstone.dto.Image;
import java.util.Date;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class BlogPostCommand {
    
    private int id;
    private String title;
    private String body;
    private Category category;
    private int categoryId;
    private String categoryName;
    private Integer statusId;
    private String status;    
    private Date startDate;
    private Date expirationDate;
    private Integer authorId;
    private Date creationDate;
    private List<String> hashtagList;
//    private String urlSlug;

    public String getCategoryName() {
        return categoryName;
    }

    
    
    public String getStatus() {
        return status;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
    
    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public List<String> getHashtagList() {
        return hashtagList;
    }

    public void setHashtagList(List<String> hashtagList) {
        this.hashtagList = hashtagList;
    }

//    public String getUrlSlug() {
//        return urlSlug;
//    }
//
//    public void setUrlSlug(String urlSlug) {
//        this.urlSlug = urlSlug;
//    }
    
    
    
}
