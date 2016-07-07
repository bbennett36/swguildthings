/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmvc;

import com.mycompany.flooringmvc.dao.OrderDaoInterface;
import com.mycompany.flooringmvc.dao.ProductDaoInterface;
import com.mycompany.flooringmvc.dao.TaxesInterface;
import com.mycompany.flooringmvc.dto.Order;
import com.mycompany.flooringmvc.dto.Product;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class OrderSQLTest {

    private OrderDaoInterface dao;
    private ProductDaoInterface pdao;
    private TaxesInterface tdao;

    public OrderSQLTest() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-persistence.xml");

        dao = ctx.getBean("dao", OrderDaoInterface.class);
        pdao = ctx.getBean("pdao", ProductDaoInterface.class);
        tdao = ctx.getBean("tdao", TaxesInterface.class);
    }

    Order order = new Order();

    @Before
    public void setUp() throws ParseException {
        order.setName("Brennan");
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        Date date = fmt.parse("2013-05-06");
        order.setDate(date);
//        order.setProduct(1);
//        order.setState(3);

//        String state = order.getState();
//        state = state.toUpperCase();
        double tax = tdao.getTax("OH");
        String type = order.getProduct();

        double results[] = getCosts(1);

        double area = 100;
        double mcs = results[0];
        double lcs = results[1];
        double lc = Math.ceil(lcs * area);
        double mc = Math.ceil(mcs * area);
        double pretotal = Math.ceil(lc + mc);
        double ttax = tax / 100;
        double taxtotal = pretotal * ttax;
        double total = pretotal + taxtotal;

        order.setArea(area);
        order.setTotal(total);
        order.setStateId(3);
        order.setProductId(1);

        dao.create(order);
    }

    public double[] getCosts(int id) {
        List<Product> produtcs = pdao.getProducts();

        double mcs = 0;
        double lcs = 0;

        for (Product myProduct : produtcs) {
            if (id == myProduct.getId()) {
                mcs = myProduct.getMatCostSqf();
                lcs = myProduct.getLaborCostSqf();
            }
        }

        return new double[]{mcs, lcs};

    }

    @After
    public void tearDown() {
//        dao.delete(order);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void tester() throws ParseException {
        Assert.assertTrue(order != null);

        Order testGet = dao.get(order.getId());
        Assert.assertTrue(testGet != null);

        List<Order> orders = dao.getOrders();
        Assert.assertTrue(orders != null);

        
        order.setName("Bennett");
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        Date date = fmt.parse("2013-05-06");
        order.setDate(date);
//        order.setProduct(1);
//        order.setState(3);

//        String state = order.getState();
//        state = state.toUpperCase();
        double tax = tdao.getTax("CA");
        String type = order.getProduct();

        double results[] = getCosts(1);

        double area = 100;
        double mcs = results[0];
        double lcs = results[1];
        double lc = Math.ceil(lcs * area);
        double mc = Math.ceil(mcs * area);
        double pretotal = Math.ceil(lc + mc);
        double ttax = tax / 100;
        double taxtotal = pretotal * ttax;
        double total = pretotal + taxtotal;

        order.setArea(area);
        order.setTotal(total);
        order.setStateId(3);
        order.setProductId(1);
        
//        dao.update(order);
        
    }
}
