package com.mycompany.addressbookmvc.dto;

import org.hibernate.validator.constraints.NotEmpty;

public class Address {

    private int id;

    @NotEmpty(message = "You must enter first name!")
    private String firstName;

    @NotEmpty(message = "You must enter last name!")
    private String lastName;

    @NotEmpty(message = "You must enter street name!")
    private String streetName;

    @NotEmpty(message = "You must enter street number!")
    private String streetNumber;

    @NotEmpty(message = "You must enter city!")
    private String city;

    @NotEmpty(message = "You must enter state!")
    private String state;

    @NotEmpty(message = "You must enter zip!")
    private String zip;

//   
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

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
