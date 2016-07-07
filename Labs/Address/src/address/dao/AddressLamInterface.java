/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package address.dao;

import address.dto.Address;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author apprentice
 */
public interface AddressLamInterface {
    

    public Address create(Address address);

    public Address get(Integer id);

    public List<Address> getLastName(String lname);

    public void update(Address address);

    public void delete(Address address); 

    public Address getCity(String city);

    public Address getZip(String zip);
    
    public List<Address> getAddresses();

    public Map<String, List<Address>> getState(String state);
}
