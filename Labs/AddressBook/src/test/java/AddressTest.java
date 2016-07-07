/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import address.controller.ConsoleIO;
import address.dao.AddressDaoImpl;
import com.thesoftwareguild.interfaces.dao.AddressDaoLamdaImpl;
import address.dto.Address2;
import com.thesoftwareguild.interfaces.dao.AddressBookDaoInterface;
import com.thesoftwareguild.interfaces.dto.Address;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author apprentice
 */
public class AddressTest {
    
    AddressBookDaoInterface addressDao;
    
    String firstName = "Bruce";
    String lastName = "Wayne";
    String streetNum = "12321";
    String streetName = "Testing Street";
    String city = "Gotham";
    String state = "New York";
    String zip = "32123";
    
    public AddressTest() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        addressDao = ctx.getBean("addressDao", AddressBookDaoInterface.class);
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    
    @Test
    public void crudAddressOrignalTest() {
        
        //Create a new Address using the original implementation
        Address newAddress = new Address();
        newAddress.setFirstName(firstName);
        newAddress.setLastName(lastName);
        newAddress.setStreetNumber(streetNum);
        newAddress.setStreetName(streetName);
        newAddress.setCity(city);
        newAddress.setState(state);
        newAddress.setZip(zip);
        
        Address originalAddress = addressDao.create(newAddress);
        Assert.assertNotNull(originalAddress);
        
    //****************************************************
    
    //Check to make sure all Properties were correctly set        
        Assert.assertEquals(originalAddress.getId(), newAddress.getId());
        Assert.assertEquals(firstName, originalAddress.getFirstName());
        Assert.assertEquals(lastName, originalAddress.getLastName());
        Assert.assertEquals(streetNum, originalAddress.getStreetNumber());
        Assert.assertEquals(streetName, originalAddress.getStreetName());
        Assert.assertEquals(city, originalAddress.getCity());
        Assert.assertEquals(state, originalAddress.getState());
        Assert.assertEquals(zip, originalAddress.getZip());
        
    //****************************************************
        
        //Was it successfully added to the AddressList        
        List<Address> originalList = addressDao.list();
        int countBeforeAdd = originalList.size();
        int expectedCount = countBeforeAdd + 1;
        originalList.add(originalAddress);
        
        Assert.assertEquals(expectedCount, originalList.size());
        
    //****************************************************
    
        //retrieve the AddressList by last name        
        List<Address> addressListByName = addressDao.searchByLastName(lastName);        
        int nameListSize = addressListByName.size();
        
        Assert.assertNotEquals(0, nameListSize);
        
    //*****************************************************
    
        //retrieve the AddressList by city        
        List<Address> addressListByCity = addressDao.searchByCity(city);        
        int cityListSize = addressListByCity.size();
        
        Assert.assertNotEquals(0, cityListSize);
        
    //*****************************************************
    
        //retrieve the AddressList by zip        
        List<Address> addressListZip = addressDao.searchByZip(zip);        
        int zipListSize = addressListZip.size();
        
        Assert.assertNotEquals(0, zipListSize);
        
    //*****************************************************
    
        //retrieve the Address Map by state
        List<Address> addressListState = addressDao.searchByState(state);        
        int stateListSize = addressListState.size();
        
        Assert.assertNotEquals(0, zipListSize);
    //*****************************************************
    
    }
}

//    public AddressTest() {
//    }
//
//    @Before
//    public void setUp() {
//    }
//
//    @After
//    public void tearDown() {
//    }
//
//    // TODO add test methods here.
//    // The methods must be annotated with annotation @Test. For example:
//    //
//    // @Test
//    // public void hello() {}
//    @Test
//    public void lamtest() {
////        AddressDaoLamdaImpl im = new AddressDaoLamdaImpl();
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//        AddressBookDaoInterface im = ctx.getBean("addressDao", AddressBookDaoInterface.class);
//
//        //test get lnames
//        List<Address> lastNames = im.searchByLastName("bennett");
//        int size = lastNames.size();
//        boolean arrayTest = true;
//        if (size != 1) {
//            arrayTest = false;
//        }
//        Assert.assertEquals(true, arrayTest);
//
//        //test get
//        Address test = im.get(1);
//        boolean exists = true;
//        if (test == null) {
//            exists = false;
//        }
//        Assert.assertEquals(true, exists);
//
//        List<Address> city = im.searchByCity("Tallmadge");
//        if (city == null) {
//            exists = false;
//        }
//        Assert.assertEquals(true, exists);
//
//        //Test Address
//        Address testUpdate = im.get(2);
//        testUpdate.setCity("Miami");
//        im.update(testUpdate);
//        boolean update = true;
//        if (!testUpdate.getCity().equals("Miami")) {
//            update = false;
//        }
//        Assert.assertEquals(true, update);
//
//    }
//
//    @Test
//    public void test2() {
//
//        Address newAddress = new Address();
//        AddressDaoLamdaImpl lambdaDao = new AddressDaoLamdaImpl();
//
//        ConsoleIO ci = new ConsoleIO();
//        
//        newAddress.setFirstName("TEST");
//        newAddress.setLastName("SNACKS");
//        newAddress.setStreetNumber("1337 TEST STREET");
//        newAddress.setCity("TESTVILLE");
//        newAddress.setState("TEST VIRGINIA");
////        newAddress.setCountry("TEST BERLIN");
//        newAddress.setZip("29183");
////        newAddress.setSecAdd("Apt. 78A");
//
//        lambdaDao.create(newAddress);
//        newAddress = lambdaDao.get(newAddress.getId());
////        ci.getWord(newAddress.getStreetNumber());
//        lambdaDao.delete(newAddress.getId());
//
//    }
//
//    @Test
//    public void test3() {
//
//        Address newAddress = new Address();
//        AddressDaoLamdaImpl lambdaDao = new AddressDaoLamdaImpl();
//        
//        newAddress.setFirstName("TEST");
//        newAddress.setLastName("SNACKS");
//        newAddress.setStreetNumber("1337 TEST STREET");
//        newAddress.setCity("TESTVILLE");
//        newAddress.setState("TEST VIRGINIA");
////        newAddress.setCountry("TEST BERLIN");
//        newAddress.setZip("29183");
////        newAddress.setSecAdd("Apt. 78A");
//        lambdaDao.create(newAddress);
//
//        Assert.assertEquals("1337 TEST STREET", newAddress.getStreetNumber());
//        lambdaDao.delete(newAddress.getId());
//
//    }
//    
//    @Test
//    public void testCreate() {
//
//        Address newAddress = new Address();
//        AddressDaoLamdaImpl addDao = new AddressDaoLamdaImpl();
//        //declare a new address
////        Address newAddress = new Address();
//        List<Address> addressList = new ArrayList();
//        //set test properties
//        newAddress.setFirstName("TEST");
//        newAddress.setLastName("McTESTER");
//        newAddress.setStreetNumber("1337 TEST STREET");
//        newAddress.setCity("TESTVILLE");
//        newAddress.setState("TEST VIRGINIA");
//        //newAddress.setCountry("TEST BERLIN");
//        newAddress.setZip("29183");
//        //newAddress.setSecAdd("Apt. 78A");
//
//        //create Address with above properties
//        addDao.create(newAddress);
//
//        //add the address to a list
//        addressList.add(newAddress);
//        boolean empty = addressList.isEmpty();
//
//        //test to see if address made it to list
//        Assert.assertEquals(false, empty);
//
//        //pull address from list
//        Address getAddress = addDao.get(newAddress.getId());
//
//        //pulled address should have these matching properties
//        Assert.assertEquals("TEST", getAddress.getFirstName());
//        Assert.assertEquals("McTESTER", getAddress.getLastName());
//        Assert.assertEquals("1337 TEST STREET", getAddress.getStreetNumber());
//        Assert.assertEquals("TESTVILLE", getAddress.getCity());
//        Assert.assertEquals("TEST VIRGINIA", getAddress.getState());
////        Assert.assertEquals("TEST BERLIN", getAddress.getCountry());
//        Assert.assertEquals("29183", getAddress.getZip());
////        Assert.assertEquals("Apt. 78A", getAddress.getSecAdd());
//
//        //update address
//        getAddress.setFirstName("CHAMP");
//        addDao.update(getAddress);
//        //address first name should now be "CHAMP"
//        Assert.assertEquals("CHAMP", getAddress.getFirstName());
//
//        //delete address
//        addDao.delete(getAddress.getId());
////        Address delAddress = new Address();
////        try {
////            delAddress = addDao.get("McTESTER");
////        } catch (Exception ex){
////            console.readString("EMPTY");
////        } 
////        //address should no longer be found
////        Assert.assertEquals(null, delAddress);
//    }

