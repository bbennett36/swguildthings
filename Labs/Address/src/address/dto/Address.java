/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package address.dto;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Brennan
 */
public class Address {

    
    private int id;
    private String fName;
    private String lName;
    private String type;
    private String streetNum;
    private String street;
    private String state;
    private String city;
    private String country;
    private String poBox;
    private String zipCode;
    
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getPoBox() {
        return poBox;
    }

    public String getState() {
        return state;
    }

    public String getStreet() {
        return street;
    }

    public String getStreetNum() {
        return streetNum;
    }

    public String getType() {
        return type;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPoBox(String poBox) {
        this.poBox = poBox;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setStreetNum(String streetNum) {
        this.streetNum = streetNum;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }
    
}
