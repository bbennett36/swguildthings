/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmvc.dao;


import com.mycompany.flooringmvc.dto.Tax;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface TaxesInterface {

    public Tax create(Tax tax);

    public Tax get(int id);

    public double getTax(String state);

    public void update(Tax tax);

    public void delete(Tax tax);

    public List<Tax> getTaxes();
}
