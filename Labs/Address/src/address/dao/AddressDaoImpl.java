/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package address.dao;

import address.app.App;
import address.dto.Address;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author apprentice
 */
public class AddressDaoImpl implements AddressInterface {

    List<Address> addresses = new ArrayList<>();

    private int nextId = 1;

    public AddressDaoImpl() {
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
        for (Address myAddress : addresses) {
            if (myAddress.getId() == id) {
                return myAddress;
            }
        }
        return null;
    }

    @Override
    public List<Address> getLastName(String lname) {
        List<Address> lastNames = new ArrayList();

        for (Address myAddress : addresses) {
            if (myAddress.getlName().equals(lname)) {
                lastNames.add(myAddress);
            }
        }
        return lastNames;

    }

    @Override
    public void update(Address address) {

        Address found = null;

        for (Address myAddress : addresses) {
            if (myAddress.getId() == address.getId()) {
                found = myAddress;
            }
        }

        addresses.remove(found);
        addresses.add(found);

        encode();

    }

    @Override
    public void delete(Address address) {

        Address found = null;

        for (Address myAddress : addresses) {
            if (myAddress.getId() == address.getId()) {
                found = myAddress;
                break;
            }
        }

        addresses.remove(found);

        encode();

    }

    @Override
    public Address getCity(String city) {

        for (Address a : addresses) {
            if (a.getCity().equals(city)) {
                return a;
            }
        }
        return null;

    }

    @Override
    public Address getZip(String zip) {

        for (Address a : addresses) {
            if (a.getZipCode().equals(zip)) {
                return a;
            }
        }
        return null;

    }

    @Override
    public Map<String, List<Address>> getState(String state) {
        Map<String, List<Address>> addCity = new HashMap();
//        List<Address> addAddress = new ArrayList();

        for (Address a : addresses) {
            if (a.getState().equals(state)) {
                List<Address> users = addCity.get(a.getCity());
                if (users == null) {
                    users = new ArrayList<>();
                    addCity.put(a.getCity(), users);
                }
                users.add(a);

//                addCity.put(a.getCity(), add(a));
            }
        }
        return addCity;

    }

    private void encode() {

        final String TOKEN = "::";

        try {
            PrintWriter out = new PrintWriter(new FileWriter("addresses.txt"));

            for (Address myAddress : addresses) {
                out.print(myAddress.getId());
                out.print(TOKEN);

                out.print(myAddress.getfName());
                out.print(TOKEN);

                out.print(myAddress.getlName());
                out.print(TOKEN);

                out.print(myAddress.getType());
                out.print(TOKEN);

                out.print(myAddress.getStreetNum());
                out.print(TOKEN);

                out.print(myAddress.getStreet());
                out.print(TOKEN);

                out.print(myAddress.getState());
                out.print(TOKEN);

                out.print(myAddress.getCity());
                out.print(TOKEN);

                out.print(myAddress.getCountry());
                out.print(TOKEN);

                out.print(myAddress.getPoBox());
                out.print(TOKEN);

                out.print(myAddress.getZipCode());
                out.println();
            }

            out.flush();
            out.close();

        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
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
                myAddress.setfName(stringParts[1]);
                myAddress.setlName(stringParts[2]);
                myAddress.setType(stringParts[3]);
                myAddress.setStreetNum(stringParts[4]);
                myAddress.setStreet(stringParts[5]);
                myAddress.setState(stringParts[6]);
                myAddress.setCity(stringParts[7]);
                myAddress.setCountry(stringParts[8]);
                myAddress.setPoBox(stringParts[9]);
                myAddress.setZipCode(stringParts[10]);

                addresses.add(myAddress);

            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

        return addresses;

    }

    @Override
    public List<Address> getAddresses() {
        return addresses;
    }

}
