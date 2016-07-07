/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.dto.Item;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class VendTest {
    
    Item it = new Item();
    
    public VendTest() {
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
    public void testCreate(Item item)    {
        
        it.setId(1);
        
        it.setItemName("twix");
        
        it.setItemCost(2.5);
        
        it.setQuanity(4);
        
        Assert.assertEquals(item, item);
        
    }
}
