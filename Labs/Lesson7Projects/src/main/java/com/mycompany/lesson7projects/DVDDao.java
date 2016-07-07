/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lesson7projects;

import com.mycompany.lesson7projects.AddressApp;
import com.mycompany.lesson7projects.DVD;
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
public class DVDDao {

    List<DVD> dvds = new ArrayList<>();

    private int nextId = 1;

    public DVDDao() {
        dvds = decode();
    }

    public DVD create(DVD dvd) {

        dvd.setId(nextId);
        nextId++;
        dvds.add(dvd);

        encode();

        return dvd;

    }

    public DVD get(Integer id) {

        for (DVD myDvd : dvds) {
            if (myDvd.getId() == id) {
                return myDvd;
            }
        }
        return null;

    }

    public void update(DVD dvd) {

        DVD found = null;

        for (DVD myDvd : dvds) {
            if (myDvd.getId() == dvd.getId()) {
                found = myDvd;
            }
        }

        dvds.remove(found);
        dvds.add(found);

        encode();
    }

    public void delete(DVD dvd) {

        DVD found = null;

        for (DVD myDvd : dvds) {
            if (myDvd.getId() == dvd.getId()) {
                found = myDvd;
                break;
            }
        }

        dvds.remove(found);

        encode();
    }

    private void encode() {

        final String TOKEN = "::";

        try {
            PrintWriter out = new PrintWriter(new FileWriter("dvds.txt"));

            for (DVD myDvd : dvds) {
                out.print(myDvd.getId());
                out.print(TOKEN);
                
                out.print(myDvd.getTitle());
                out.print(TOKEN);

                out.print(myDvd.getReleaseDate());
                out.print(TOKEN);

                out.print(myDvd.getmPAA());
                out.print(TOKEN);

                out.print(myDvd.getDirectorsName());
                out.print(TOKEN);

                out.print(myDvd.getStudio());
                out.print(TOKEN);
                
                out.print(myDvd.getNote());
                out.println();

            }

            out.flush();
            out.close();

        } catch (IOException ex) {
            Logger.getLogger(AddressApp.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private List<DVD> decode() {

        List<DVD> dvds = new ArrayList<>();
        
        try {
            Scanner read = new Scanner(new BufferedReader(new FileReader("dvds.txt")));

            while (read.hasNextLine()) {
                String currentLine = read.nextLine();

                String[] stringParts = currentLine.split("::");

                DVD myDvd = new DVD();

                int id = Integer.parseInt(stringParts[0]);
                myDvd.setId(id);
                if(!dvds.isEmpty()) {
                    int testid = myDvd.getId();
                    nextId = testid + 1;
                }
                myDvd.setTitle(stringParts[1]);
                myDvd.setReleaseDate(stringParts[2]);
                myDvd.setmPAA(stringParts[3]);
                myDvd.setDirectorsName(stringParts[4]);
                myDvd.setStudio(stringParts[5]);
                myDvd.setNote(stringParts[6]);
                
                dvds.add(myDvd);

            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(AddressApp.class.getName()).log(Level.SEVERE, null, ex);
        }

        return dvds;

    }

    public List<DVD> getDvds() {
        return dvds;
    }
}
