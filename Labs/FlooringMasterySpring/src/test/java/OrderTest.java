/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.dao.OrderDao;
import com.mycompany.dto.Order;
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
public class OrderTest {
    
//    OrderDao dao = new OrderDao();
    
    
    
    public OrderTest() {
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
    // @Test
    // public void hello() {}
    
//    @Test
//    public void tester()    {
//        
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//        OrderDao dao= ctx.getBean("dao", OrderDao.class);
//        
//        
//        //test create
//        Order order = new Order();
//        
//        List<Order> orderSize = dao.getOrders();
//        int id = orderSize.size() + 1;
//        
//        order.setId(id);
//        order.setName("Brennan");
//        order.setArea(100);
//        order.setLaborCost(475.0);
//        order.setLaborCostSqf(4.75);
//        order.setMatCostSqf(5.15);
//        order.setMaterialCost(515.0);
//        order.setProduct("Wood");
//        order.setState("OH");
//        order.setTax(6.75);
//        order.setTaxTotal(61.875);
//        order.setTotal(1051.875);
//        order.setDate("12122012");
//       
//        dao.create(order);
//
//        //make sure order exists
//        boolean orderExists = true;
//        if (order == null) {
//            orderExists = false;
//        }
//        
//        Assert.assertEquals(true, orderExists);
//        
//        
//        
//        //get order
//        id = order.getId();
//        Order myOrder = dao.get(id);
//        orderExists = true;
//        if (myOrder == null) {
//            orderExists = false;
//        }
//        Assert.assertEquals(true, orderExists);
//        
//        
//        //test update
//        myOrder.setName("Bennett");
//        dao.update(myOrder);
//        boolean update = true;
//        if(!myOrder.getName().equals("Bennett"))     {
//            update = false;
//        }
//        
//        Assert.assertEquals(true, update);
//
//        //delete test
//        id = order.getId();
//        Order delete = dao.get(id);
//        dao.delete(delete);
//        boolean deleted = true;
//        if(delete == null)   {
//            deleted = false;
//        }
//        
//        Assert.assertEquals(true, deleted);
//        
//    }
}
