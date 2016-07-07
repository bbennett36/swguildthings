/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package address.dao;

import address.dto.Address2;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author apprentice
 */
public interface AddressInterface {
    
    
    public Address2 create(Address2 address);

    public Address2 get(Integer id);

    public List<Address2> getLastName(String lname);

    public void update(Address2 address);

    public void delete(Address2 address);
    
    public Address2 getCity(String city);

    public Address2 getZip(String zip);

    public Map<String, List<Address2>> getState(String state);
    
     public List<Address2> getAddresses();
}

