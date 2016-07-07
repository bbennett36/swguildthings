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
public class AdminPage {
    
    private int id;
    private String pageName;
    private int sequence;
    private String pageBody;
    private int authorId;
    private Date creationDate;
    private int lastModifiedBy;
    private Date lastModifiedDate;

    public int getAuthorId() {
        return authorId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public int getId() {
        return id;
    }

    public int getLastModifiedBy() {
        return lastModifiedBy;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public String getPageBody() {
        return pageBody;
    }

    public String getPageName() {
        return pageName;
    }

    public int getSequence() {
        return sequence;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLastModifiedBy(int lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public void setPageBody(String pageBody) {
        this.pageBody = pageBody;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }
    
    
    
}
