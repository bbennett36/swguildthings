/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmvc;

import com.mycompany.flooringmvc.dao.TaxesInterface;
import com.mycompany.flooringmvc.dto.Tax;
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
public class TaxesSQLTest {

    private TaxesInterface tdao;

    public TaxesSQLTest() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-persistence.xml");

        tdao = ctx.getBean("tdao", TaxesInterface.class);
    }

    Tax tax = new Tax();

    @Before
    public void setUp() {
        tax.setState("NY");
        tax.setTaxRate(9.50);
        tdao.create(tax);
    }

    @After
    public void tearDown() {
        tdao.delete(tax);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void tester() {
        boolean exists = true;
        if (tax == null) {
            exists = false;
        }
        Assert.assertTrue(exists);

        Tax testGet = tdao.get(3);
        if (testGet == null) {
            exists = false;
        }
        Assert.assertTrue(exists);
        
        String newState = "FL";
        tax.setState(newState);
        tdao.update(tax);
        Assert.assertTrue(tax.getState().equals(newState));

        List<Tax> taxes = tdao.getTaxes();
        if(taxes == null)   {
            exists = false;
        }
        Assert.assertTrue(exists);
        
        double rate = tdao.getTax("OH");
        Assert.assertTrue(rate == 6.75);
        
    }
}
