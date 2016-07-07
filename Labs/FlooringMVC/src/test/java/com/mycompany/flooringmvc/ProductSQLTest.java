/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmvc;

import com.mycompany.flooringmvc.dao.ProductDaoInterface;
import com.mycompany.flooringmvc.dto.Product;
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
public class ProductSQLTest {

    private ProductDaoInterface pdao;

    public ProductSQLTest() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-persistence.xml");

        pdao = ctx.getBean("pdao", ProductDaoInterface.class);
    }

    Product product = new Product();

    @Before
    public void setUp() {
        product.setProductType("Tile");
        product.setMatCostSqf(5.00);
        product.setLaborCostSqf(5.00);
        pdao.create(product);
    }

    @After
    public void tearDown() {
        pdao.delete(product);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void tester() {

        Assert.assertTrue(product != null);

        Product testGet = pdao.get(product.getId());
        Assert.assertTrue(testGet != null);

        List<Product> products = pdao.getProducts();
        Assert.assertTrue(products != null);
        
        product.setProductType("Gold");
        pdao.update(product);
        Assert.assertTrue(product.getProductType().equals("Gold"));

    }
}
