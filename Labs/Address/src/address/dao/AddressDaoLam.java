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
import java.util.Optional;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author apprentice
 */
public class AddressDaoLam {

    List<Address> addresses = new ArrayList<>();

    private int nextId = 1;
    private Object collectors;

    public AddressDaoLam() {
        addresses = decode();
    }

    public Address create(Address address) {
//
        address.setId(nextId);
        nextId++;
        addresses.add(address);

//        addresses.stream()
//                .map(address -> address.setId(nextId))
//                .collect(Collectors.toList()); //     
        encode();

        return address;
//
    }
//        for (Address myAddress : addresses) {
//            if (myAddress.getId() == id) {
//                return myAddress;
//            }
//        }

    public Address get(Integer id) {

//        Optional<Address> result = addresses.stream()
//        .filter(a -> a.getId() == id)
//        .findFirst();
//        return result.orElse(null);
        return addresses.stream()
                .filter(a -> a.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Address> getLastName(String lname) {

        return addresses
                .stream()
                .filter(a -> a.getlName().equals(lname))
                .collect(Collectors.toList());

    }

    public void update(Address address) {

//        Address found = null;
//        
//
//        for (Address myAddress : addresses) {
//            if (myAddress.getId() == address.getId()) {
//                found = myAddress;
//            }
//        }
        addresses.removeIf(a -> a.getId() == address.getId());

//        addresses.stream()
//                .filter(a -> a.getId() == address.getId())
//                .collect(Collectors.toList());
//        addresses.stream()
//                .map(Address::getId)
//                .collect(Collectors.toList()); //        
//        addresses.remove(found);
        addresses.add(address);

        encode();
    }

    public void delete(Address address) {

        addresses.removeIf(a -> a.getId() == address.getId());

        encode();
    }

    public Address getCity(String city) {

        return addresses.stream()
                .filter(a -> a.getCity().equals(city))
                .findFirst()
                .orElse(null);

    }

    public Address getZip(String zip) {

        return addresses.stream()
                .filter(a -> a.getZipCode().equals(zip))
                .findFirst()
                .orElse(null);

    }

    public Map<String, List<Address>> getState(String state) {

        Map<String, List<Address>> collect = addresses.stream()
                .collect(Collectors.groupingBy(Address::getCity));

        return collect;

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

    public List<Address> getAddresses() {
        return addresses;
    }

}
