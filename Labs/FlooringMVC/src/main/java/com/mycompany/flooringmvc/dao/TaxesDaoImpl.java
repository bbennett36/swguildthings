/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmvc.dao;


import com.mycompany.flooringmvc.dto.Tax;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class TaxesDaoImpl implements TaxesInterface {
    
       List<Tax> taxes = new ArrayList<>();


    private int getNextId() {
        int result = 0;
        for (Tax t : taxes) {
            if (t.getId() > result) {
                result = t.getId();
            }
        }
        result++;
        return result;
    }

    public TaxesDaoImpl() {
        taxes = decode();
    }

       @Override
    public Tax create(Tax tax) {
        tax.setId(getNextId());

        taxes.add(tax);

        encode();

        return tax;

    }

       @Override
    public Tax get(int id) {

        return taxes.stream()
                .filter(a -> a.getId() == id)
                .findFirst()
                .orElse(null);

    }
    
       @Override
    public double getTax(String state) {
        double tax = 0;
        
        for (Tax myTaxes : taxes) {
            if (state.equals(myTaxes.getState())) {
                tax = myTaxes.getTaxRate();
            }

        }
        return tax;
    }
    

       @Override
    public void update(Tax tax) {

        taxes.removeIf(a -> a.getId() == tax.getId());
        taxes.add(tax);

        encode();
    }

       @Override
    public void delete(Tax tax) {

        Tax found = null;

        for (Tax myTax : taxes) {
            if (myTax.getState().equals(tax.getState())) {
                found = myTax;
                break;
            }
        }

        taxes.remove(found);

        encode();
    }

    private void encode() {

        final String TOKEN = ",";

        try {
            PrintWriter out = new PrintWriter(new FileWriter("Taxes.txt"));

            out.println("ID,State,TaxRate");

            for (Tax myTax : taxes) {

                out.print(myTax.getId());
                out.print(TOKEN);
                
                out.print(myTax.getState());
                out.print(TOKEN);

                out.print(myTax.getTaxRate());
                out.println();
                
                 out.flush();

            }

            out.close();

        } catch (IOException ex) {
//            Logger.getLogger(OrderApp.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private List<Tax> decode() {

        List<Tax> taxes = new ArrayList();

        try {
            Scanner read = new Scanner(new BufferedReader(new FileReader("Taxes.txt")));

            int line = 0;

            while (read.hasNextLine()) {
                String currentLine = read.nextLine();

                String[] stringParts = currentLine.split(",");

                line++;
                if (line == 1) {
                    continue;
                }

                Tax myTax = new Tax();
                
                int id = Integer.parseInt(stringParts[0]);
                myTax.setId(id);
                myTax.setState(stringParts[1]);
                double tax = Double.parseDouble(stringParts[2]);
                myTax.setTaxRate(tax);

                taxes.add(myTax);

            }

        } catch (FileNotFoundException ex) {
//            Logger.getLogger(OrderApp.class.getName()).log(Level.SEVERE, null, ex);
        }

        return taxes;

    }

       @Override
    public List<Tax> getTaxes() {
        return taxes;
    }

    
}
