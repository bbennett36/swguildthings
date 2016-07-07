/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmvc.dto;

import static java.time.Instant.MIN;
import static java.time.LocalDate.MIN;
import static java.time.OffsetTime.MIN;
import java.util.Date;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author apprentice
 */
public class Order {

    private int id;

//    @NotEmpty(message = "You must enter a date")
    private Date date;

    @NotEmpty(message = "You must enter a name!")
    private String name;

    private String state;
    
    private int stateId;

    private String product;
    
    private int productId;

    @Min(1)
    private double area;

    private double matCostSqf;

    private double laborCostSqf;

    private double materialCost;

    private double laborCost;

    private double tax;

    private double taxTotal;

    private double total;

    public double getArea() {
        return area;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getLaborCost() {
        return laborCost;
    }

    public double getLaborCostSqf() {
        return laborCostSqf;
    }

    public double getMatCostSqf() {
        return matCostSqf;
    }

    public double getMaterialCost() {
        return materialCost;
    }

    
    public double getTax() {
        return tax;
    }

    public double getTotal() {
        return total;
    }

   

    public void setId(int id) {
        this.id = id;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLaborCost(double laborCost) {
        this.laborCost = laborCost;
    }

    public void setLaborCostSqf(double laborCostSqf) {
        this.laborCostSqf = laborCostSqf;
    }

    public void setMatCostSqf(double matCostSqf) {
        this.matCostSqf = matCostSqf;
    }

    public void setMaterialCost(double materialCost) {
        this.materialCost = materialCost;
    }

   
    public void setTax(double tax) {
        this.tax = tax;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public double getTaxTotal() {
        return taxTotal;
    }

    public void setTaxTotal(double taxTotal) {
        this.taxTotal = taxTotal;
    }

    public String getProduct() {
        return product;
    }

    public int getProductId() {
        return productId;
    }

    public String getState() {
        return state;
    }

    public int getStateId() {
        return stateId;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }

    

}
