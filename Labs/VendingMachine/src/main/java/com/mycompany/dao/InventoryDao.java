/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.dto.Item;
import com.mycompany.vendingmachine.App;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author apprentice
 */
public class InventoryDao {
    
     List<Item> items = new ArrayList<>();

    private int nextId = 1;

    public InventoryDao() {
        items = decode();
    }

    
    public Item create(Item item) {

        item.setId(nextId);
        nextId++;
        items.add(item);

        encode();

        return item;

    }

    public Item get(Integer id) {

        for (Item myItem : items) {
            if (myItem.getId() == id) {
                return myItem;
            }
        }
        return null;

    }

    public void update(Item item) {
        
        Item found = null;

        for (Item myItem : items) {
            if (myItem.getId() == item.getId()) {
                found = myItem;
            }
        }
        
        items.remove(found);
        items.add(found);

        encode();
    }

    public void delete(Item item) {

        Item found = null;

        for (Item myItem : items) {
            if (myItem.getId() == item.getId()) {
                found = myItem;
                break;
            }
        }

        items.remove(found);

        encode();
    }
    
     public void removeItem(Item item) {


        for (Item myItem : items) {
            if (myItem.getId() == item.getId()) {
                myItem.getQuanity();
                myItem.setQuanity(myItem.getQuanity() - 1);
                break;
            }
            
        }

        

        encode();
    }

    private void encode() {

        final String TOKEN = "::";

        try {
            PrintWriter out = new PrintWriter(new FileWriter("items.txt"));

            for (Item myItem : items) {
                out.print(myItem.getId());
                out.print(TOKEN);
                
                out.print(myItem.getItemName());
                out.print(TOKEN);

                out.print(myItem.getItemCost());
                out.print(TOKEN);

                out.print(myItem.getQuanity());
                out.println();
                
            }

            out.flush();
            out.close();

        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private List<Item> decode() {

        List<Item> items = new ArrayList<>();

        

        try {
            Scanner read = new Scanner(new BufferedReader(new FileReader("items.txt")));

            while (read.hasNextLine()) {
                String currentLine = read.nextLine();

                String[] stringParts = currentLine.split("::");

                Item myItem = new Item();

                int id = Integer.parseInt(stringParts[0]);
                myItem.setId(id);
                if(!items.isEmpty()) {
                    int testid = myItem.getId();
                    nextId = testid + 1;
                }
                myItem.setItemName(stringParts[1]);
                double cost = Double.parseDouble(stringParts[2]);
                myItem.setItemCost(cost);
                int quant = Integer.parseInt(stringParts[3]);
                myItem.setQuanity(quant);
                
                items.add(myItem);

            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

        return items;

    }

    
    
    public List<Item> getItems() {
        return items;
    }

    
}
