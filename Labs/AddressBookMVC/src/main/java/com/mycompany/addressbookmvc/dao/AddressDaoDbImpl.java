/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.addressbookmvc.dao;

import com.mycompany.addressbookmvc.dto.Address;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author apprentice
 */
public class AddressDaoDbImpl implements AddressBookDao {

    private static final String SQL_INSERT_ADDRESS = "insert into address (FirstName, LastName, StreetNumber, StreetName, City, State, Zip) values (?,?,?,?,?,?,?)";
    private static final String SQL_GET_ADDRESS_LIST = "select * from address";
    private static final String SQL_GET_ADDRESS = "Select * from address where id = ?";
    private static final String SQL_UPDATE_ADDRESS = "UPDATE address SET FirstName = ?, LastName = ?, StreetNumber=?, StreetName=?, City=?, State=?, Zip=? WHERE id = ?";
    private static final String SQL_DELETE_ADDRESS = "delete from address where id=?";
    private static final String SQL_GET_LAST_NAMES = "select * from address where LastName = ?";
    private static final String SQL_GET_CITY = "select * from address where City = ?";
    private static final String SQL_GET_STATE = "select * from address where State = ?";
    private static final String SQL_GET_ZIP = "select * from address where Zip = ?";

    private JdbcTemplate jdbcTemplate;

    public AddressDaoDbImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Address create(Address address) {
        jdbcTemplate.update(SQL_INSERT_ADDRESS,
                address.getFirstName(),
                address.getLastName(),
                address.getStreetNumber(),
                address.getStreetName(),
                address.getCity(),
                address.getState(),
                address.getZip());

        Integer id = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);

        address.setId(id);

        return address;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void update(Address address) {

        jdbcTemplate.update(SQL_UPDATE_ADDRESS,
                address.getFirstName(),
                address.getLastName(),
                address.getStreetNumber(),
                address.getStreetName(),
                address.getCity(),
                address.getState(),
                address.getZip(),
                address.getId());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Address get(Integer id) {
        return jdbcTemplate.queryForObject(SQL_GET_ADDRESS, new AddressMapper(), id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(Address address) {
        jdbcTemplate.update(SQL_DELETE_ADDRESS, address.getId());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Address> list() {
        return jdbcTemplate.query(SQL_GET_ADDRESS_LIST, new AddressMapper());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Address> searchByLastName(String lastName) {
        return jdbcTemplate.query(SQL_GET_LAST_NAMES, new AddressMapper(), lastName);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Address> searchByCity(String city) {
        return jdbcTemplate.query(SQL_GET_CITY, new AddressMapper(), city);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Address> searchByState(String state) {
        return jdbcTemplate.query(SQL_GET_STATE, new AddressMapper(), state);

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Address> searchByZip(String zip) {
        return jdbcTemplate.query(SQL_GET_ZIP, new AddressMapper(), zip);
    }

    private static final class AddressMapper implements RowMapper<Address> {

        @Override
        public Address mapRow(ResultSet rs, int i) throws SQLException {

            Address address = new Address();

            address.setId(rs.getInt("id"));
            address.setFirstName(rs.getString("FirstName"));
            address.setLastName(rs.getString("LastName"));
            address.setStreetNumber(rs.getString("StreetNumber"));
            address.setStreetName(rs.getString("StreetName"));
            address.setCity(rs.getString("City"));
            address.setState(rs.getString("State"));
            address.setZip(rs.getString("Zip"));

            return address;

        }

    }

}
