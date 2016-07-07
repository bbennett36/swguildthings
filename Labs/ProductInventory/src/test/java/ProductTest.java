/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.dao.Inventory;
import com.mycompany.dto.Inventory;
import com.mycompany.dto.Product;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

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
    @Test
    public void tester() {
        Inventory dao = new Inventory();

        Product product = new Product();
        product.setId(1);
        product.setName("Game");
        product.setPrice(50);
        product.setQuantity(5);
        product.setWeight(10);
        
        dao.create(product);
        
        Product created = dao.get(1);
        boolean exists = true;
        if(created == null) {
            exists = false;
        }
        Assert.assertEquals(true, exists);
    }
}
