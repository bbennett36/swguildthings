/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package address.dao;

import address.dto.Address2;
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
    

    public Address2 create(Address2 address);

    public Address2 get(Integer id);

    public List<Address2> getLastName(String lname);

    public void update(Address2 address);

    public void delete(Address2 address); 

    public Address2 getCity(String city);

    public Address2 getZip(String zip);
    
    public List<Address2> getAddresses();

    public Map<String, List<Address2>> getState(String state);
}
