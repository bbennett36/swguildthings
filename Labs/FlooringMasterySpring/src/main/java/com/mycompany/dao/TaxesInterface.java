/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.dto.Tax;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface TaxesInterface {

    public Tax create(Tax tax);

    public Tax get(String state);

    public double getTax(String state);

    public void update(Tax tax);

    public void delete(Tax tax);

    public List<Tax> getTaxes();
}
