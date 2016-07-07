package com.mycompany.addressbookmvc.dao;



import com.mycompany.addressbookmvc.dto.Address;
import java.util.List;
import java.util.Map;


public interface AddressBookDao {

    public Address create(Address address);
    public void update(Address address);
    public Address get(Integer id);
    public void delete(Address address);

    public List<Address> list();
    public List<Address> searchByLastName(String lastName);
    public List<Address> searchByCity(String city);
    public List<Address> searchByState(String state);
    public List<Address> searchByZip(String zip);


}