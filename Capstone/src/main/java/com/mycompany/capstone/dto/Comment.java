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
public class Comment {  
    private int id;
    private String comment;
    private Date commentDate;
    //private int userId;
    private String userName;
    private int blogPostId;

    public int getBlogPostId() {
        return blogPostId;
    }

    public String getComment() {
        return comment;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public int getId() {
        return id;
    }

//    public int getUserId() {
//        return userId;
//    }

    public void setBlogPostId(int blogPostId) {
        this.blogPostId = blogPostId;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public void setUserId(int userId) {
//        this.userId = userId;
//    }
//    

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
}
