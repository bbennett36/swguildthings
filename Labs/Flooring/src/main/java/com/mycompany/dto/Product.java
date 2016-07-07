/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dto;

/**
 *
 * @author apprentice
 */
public class Product {
    
    private int id;
    private String productType;
    private double matCostSqf;
    private double laborCostSqf;

    public int getId() {
        return id;
    }

    public double getLaborCostSqf() {
        return laborCostSqf;
    }

    public double getMatCostSqf() {
        return matCostSqf;
    }

    public String getProductType() {
        return productType;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLaborCostSqf(double laborCostSqf) {
        this.laborCostSqf = laborCostSqf;
    }

    public void setMatCostSqf(double matCostSqf) {
        this.matCostSqf = matCostSqf;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }
    
    
}
