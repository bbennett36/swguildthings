/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.addressbookmvc.dao;


import com.mycompany.addressbookmvc.dto.Address;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author apprentice
 */
public class AddressDaoLamdaImpl implements AddressBookDao {

    List<Address> addresses = new ArrayList();

    private int nextId = 1;

    public AddressDaoLamdaImpl() {
        addresses = decode();
    }

    @Override
    public Address create(Address address) {
        address.setId(nextId);
        nextId++;
        addresses.add(address);

        encode();
        
        return address;
    }

    @Override
    public Address get(Integer id) {
        return addresses.stream()
                .filter(a -> a.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Address> searchByLastName(String lname) {

        return addresses
                .stream()
                .filter(a -> a.getLastName().equals(lname))
                .collect(Collectors.toList());

    }

    @Override
    public void update(Address address) {
        addresses.removeIf(a -> a.getId() == address.getId());

        addresses.add(address);

        encode();
    }

    @Override
    public void delete(Address address) {

        addresses.removeIf(a -> a.getId() == address.getId());

        encode();
    }

    @Override
    public List<Address> searchByCity(String city) {
        return addresses.stream()
                .filter(a -> a.getCity().equals(city))
                .collect(Collectors.toList());
    }

    @Override
    public List<Address> searchByZip(String zip) {
        return addresses.stream()
                .filter(a -> a.getZip().equals(zip))
                .collect(Collectors.toList());
    }

    @Override
    public List<Address> list() {
        return addresses;
    }

    @Override
    public List<Address> searchByState(String state) {
         
        return addresses.stream()
                .filter(a -> a.getState().equals(state))
                .collect(Collectors.toList());
        
        
    }

    private void encode() {

        final String TOKEN = "::";

        try {
            PrintWriter out = new PrintWriter(new FileWriter("addresses.txt"));

            for (Address myAddress : addresses) {
                out.print(myAddress.getId());
                out.print(TOKEN);

                out.print(myAddress.getFirstName());
                out.print(TOKEN);

                out.print(myAddress.getLastName());
                out.print(TOKEN);

                out.print(myAddress.getStreetName());
                out.print(TOKEN);

                out.print(myAddress.getStreetNumber());
                out.print(TOKEN);

                out.print(myAddress.getState());
                out.print(TOKEN);

                out.print(myAddress.getCity());
                out.print(TOKEN);

                out.print(myAddress.getZip());
                out.println();
            }

            out.flush();
            out.close();

        } catch (IOException ex) {
//            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private List<Address> decode() {

        List<Address> addresses = new ArrayList<>();

        try {
            Scanner read = new Scanner(new BufferedReader(new FileReader("addresses.txt")));

            while (read.hasNextLine()) {
                String currentLine = read.nextLine();

                String[] stringParts = currentLine.split("::");

                Address myAddress = new Address();

                int id = Integer.parseInt(stringParts[0]);
                myAddress.setId(id);
                if (!addresses.isEmpty()) {
                    int testid = myAddress.getId();
                    nextId = testid + 1;
                }
                myAddress.setFirstName(stringParts[1]);
                myAddress.setLastName(stringParts[2]);
                myAddress.setStreetName(stringParts[3]);
                myAddress.setStreetNumber(stringParts[4]);
                myAddress.setState(stringParts[5]);
                myAddress.setCity(stringParts[6]);
                myAddress.setZip(stringParts[7]);

                addresses.add(myAddress);

            }

        } catch (FileNotFoundException ex) {
//            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

        return addresses;

    }

}
