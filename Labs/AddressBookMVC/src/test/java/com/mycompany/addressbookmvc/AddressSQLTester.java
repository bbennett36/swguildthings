/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.addressbookmvc;

import com.mycompany.addressbookmvc.dao.AddressBookDao;
import com.mycompany.addressbookmvc.dao.AddressDaoDbImpl;
import com.mycompany.addressbookmvc.dto.Address;
import java.util.List;
import javax.inject.Inject;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author apprentice
 */
public class AddressSQLTester {

    private AddressBookDao dao;

    public AddressSQLTester() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-persistence.xml");

        dao = ctx.getBean("dao", AddressBookDao.class);
    }
    Address addressTest = new Address();

    @Before
    public void setUp() {
        addressTest.setFirstName("James");
        addressTest.setLastName("Bennett");
        addressTest.setStreetNumber("2821");
        addressTest.setStreetName("Lee rd");
        addressTest.setCity("Silver Lake");
        addressTest.setState("Ohio");
        addressTest.setZip("44224");
        dao.create(addressTest);
    }

    @After
    public void tearDown() {
        dao.delete(addressTest);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void tester() {

        Address testGet = dao.get(addressTest.getId());

        boolean exists = true;
        if (testGet == null) {
            exists = false;
        }
        Assert.assertTrue(exists);

        Address testUpdate = dao.get(testGet.getId());
        testUpdate.setFirstName("Bill");
        Assert.assertTrue(testUpdate.getFirstName().equals("Bill"));

        List<Address> lastNames = dao.searchByLastName("Bennett");
        if (lastNames == null) {
            exists = false;
        }
        Assert.assertTrue(exists);
        
        List<Address> cities = dao.searchByCity("Silver Lake");
        if (cities == null) {
            exists = false;
        }
        Assert.assertTrue(exists);
        
        List<Address> states = dao.searchByState("Ohio");
        if (states == null) {
            exists = false;
        }
        Assert.assertTrue(exists);
        
        List<Address> zipCodes = dao.searchByZip("44224");
        if (zipCodes == null) {
            exists = false;
        }
        Assert.assertTrue(exists);

    }

}
