/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.contactlist.dto;

import java.util.Date;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author apprentice
 */
public class Contact {

    private int id;

    @NotEmpty(message = "You must supply first name")
    private String firstName;

    @NotEmpty(message = "You must supply last name")
    private String lastName;

    @NotEmpty(message = "You must supply a company")
    private String company;

    @NotEmpty(message = "You must supply a phone number")
    private String phone;

    @NotEmpty(message = "You must supply email")
    private String email;
    
    private Date lastContacted;

    public Date getLastContacted() {
        return lastContacted;
    }

    public void setLastContacted(Date lastContacted) {
        this.lastContacted = lastContacted;
    }
    

    public String getCompany() {
        return company;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
