/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.dao.OrderDao;
import com.mycompany.dao.ProductDao;
import com.mycompany.dto.Product;
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
public class ProductTest {

    public ProductTest() {
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
//    public void productTest() {
//
////        ProductDao pdao = new ProductDao();
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//        ProductDao pdao = ctx.getBean("pdao", ProductDao.class);
//
//        //test create
//        Product product = new Product();
//        product.setProductType("Steel");
//        product.setLaborCostSqf(5.0);
//        product.setMatCostSqf(6.0);
//        pdao.create(product);
//
//        //make sure its created
//        Product exists = pdao.get("Steel");
//        boolean created = true;
//        if (exists == null) {
//            created = false;
//        }
//
//        Assert.assertEquals(true, created);
//
//        //test update
//        exists.setProductType("Carbon");
//        pdao.update(exists);
//        boolean updated = false;
//        if (exists.getProductType().equals("Carbon")) {
//            updated = true;
//        }
//
//        Assert.assertEquals(true, updated);
//
//        //test delete
//        Product delete = pdao.get("Carbon");
//        pdao.delete(delete);
//        boolean deleted = true;
//        if (delete == null) {
//            deleted = false;
//        }
//
//        Assert.assertEquals(true, deleted);
//
//    }
}
