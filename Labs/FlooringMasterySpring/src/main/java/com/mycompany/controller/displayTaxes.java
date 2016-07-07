/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.consoleio.ConsoleIO;
import com.mycompany.dao.TaxesInterface;
import com.mycompany.dto.Tax;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class displayTaxes {
    
    ConsoleIO ci = new ConsoleIO();
    TaxesInterface tdao;
    public displayTaxes(TaxesInterface tdao)    {
        this.tdao = tdao;
    }
    
     public void displayTaxes() {
        List<Tax> taxes = tdao.getTaxes();

        ci.displayString("-----------------");
        ci.displayString("List of Tax Rates");
        ci.displayString("-----------------");

        for (Tax t : taxes) {
            ci.displayString("State:" + t.getState() + "|TaxRate:" + t.getTaxRate());
        }

    }
    
}
