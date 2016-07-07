/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import address.dao.AddressDao;
import address.dao.AddressDaoImpl;
import address.dao.AddressDaoLamdaImpl;
import address.dto.Address;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class AddressTest {

    public AddressTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }
//
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @Test
    public void tester() {
        AddressDaoImpl dao = new AddressDaoImpl();

        //test search by city
        Address city = dao.getCity("Akron");
        boolean exists = true;
        if (!city.getCity().equals("Akron")) {
            exists = false;
        }
        Assert.assertEquals(true, exists);

        //search by zipcode
        Address zip = dao.getZip("44224");
        if (!zip.getZipCode().equals("44224")) {
            exists = false;
        }
        Assert.assertEquals(true, exists);

        //return array of last names
        List<Address> lastNames = dao.getLastName("Bennett");
        int size = lastNames.size();
        boolean arrayTest = true;
        if (size != 2) {
            arrayTest = false;
        }
        Assert.assertEquals(true, arrayTest);

    }

    @Test
    public void lamtest() {
        AddressDaoLamdaImpl im = new AddressDaoLamdaImpl();

        //test get lnames
        List<Address> lastNames = im.getLastName("Bennett");
        int size = lastNames.size();
        boolean arrayTest = true;
        if (size != 2) {
            arrayTest = false;
        }
        Assert.assertEquals(true, arrayTest);

        //test get
        Address test = im.get(1);
        boolean exists = true;
        if (test == null) {
            exists = false;
        }
        Assert.assertEquals(true, exists);
        
        

        Address city = im.getCity("Cleveland");
        if (city == null) {
            exists = false;
        }
        Assert.assertEquals(true, exists);
        
        //Test Address
        Address testUpdate = im.get(3);
        testUpdate.setCity("Miami");
        im.update(testUpdate);
        boolean update = true;
        if(!testUpdate.getCity().equals("Miami"))     {
            update = false;
        }
        Assert.assertEquals(true, update);

        
    }
}
