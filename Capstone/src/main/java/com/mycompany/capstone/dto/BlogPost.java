/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.capstone.dto;

import java.util.Date;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author apprentice
 */
public class BlogPost {
    
    private int id;
    
    @NotEmpty(message = "Required Field")
    private String title;    
    
    private String body;
    private Image blogImage;
    private Date startDate;
    private Date expirationDate;
    private User author;
    private String authorName;
    private int statusId;
    private String status;
    private Category category;
    private String categoryName;
    public Date creationDate;
    private int lastModifiedBy;
    private Date lastModifiedDate;
    private List<Hashtag> hashtagList;
//    private String urlSlug;

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
    
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public Image getBlogImage() {
        return blogImage;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public User getAuthor() {
        return author;
    }

    public int getStatusId() {
        return statusId;
    }

    public Category getCategory() {
        return category;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public int getLastModifiedBy() {
        return lastModifiedBy;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public List<Hashtag> getHashtagList() {
        return hashtagList;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setBlogImage(Image blogImage) {
        this.blogImage = blogImage;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setLastModifiedBy(int lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public void setHashtagList(List<Hashtag> hashtagList) {
        this.hashtagList = hashtagList;
    }

//    public String getUrlSlug() {
//        return urlSlug;
//    }
//
//    public void setUrlSlug(String urlSlug) {
//        this.urlSlug = urlSlug;
//    }
//    
    
}
