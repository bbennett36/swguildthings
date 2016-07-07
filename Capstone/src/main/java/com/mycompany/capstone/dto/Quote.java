/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.capstone.dto;

import java.util.List;

/**
 *
 * @author apprentice
 */
public class Quote {
    
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNum;
    private String selectedMake;
    private String selectedModel;
    private String year;
    private String description;
    private String estimate;
    private List<String> makes;
    private List<String> model;

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
    
    public String getEstimate() {
        return estimate;
    }

    public void setEstimate(String estimate) {
        this.estimate = estimate;
    }
    
    public String getDescription() {
        return description;
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

  

    public String getYear() {
        return year;
    }

    public void setDescription(String description) {
        this.description = description;
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


    public void setYear(String year) {
        this.year = year;
    }

    public List<String> getMakes() {
        return makes;
    }


    public String getSelectedMake() {
        return selectedMake;
    }

    public String getSelectedModel() {
        return selectedModel;
    }

    public void setMakes(List<String> makes) {
        this.makes = makes;
    }

    public void setModel(List<String> model) {
        this.model = model;
    }

    public List<String> getModel() {
        return model;
    }


    public void setSelectedMake(String selectedMake) {
        this.selectedMake = selectedMake;
    }

    public void setSelectedModel(String selectedModel) {
        this.selectedModel = selectedModel;
    }
    
    
}
