/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.capstone.commandobject;

import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author apprentice
 */
public class UserCommand {
    
    private int id;
    @NotEmpty(message=" First Name Should not be empty  ")
    private String firstName;
    @NotEmpty(message=" Last Name Should not be empty  ")
    private String lastName;
    @NotEmpty(message=" User Name Should not be empty  ")
    private String username;
    @NotEmpty(message=" Password Should not be empty  ")
    private String password;
    @NotEmpty(message=" Email Should not be empty  ")
    private String email;
    private List<Integer> roleIdList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Integer> getRoleIdList() {
        return roleIdList;
    }

    public void setRoleIdList(List<Integer> roleIdList) {
        this.roleIdList = roleIdList;
    }    
}
