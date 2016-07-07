/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.simpleprogrammer.SimpleCalculator;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class SimpleCalculatorTest {
    
    public SimpleCalculatorTest() {
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
    public void tester()    {
        SimpleCalculator sc = new SimpleCalculator();
        
        int result1 = sc.addition(2, 4);
        Assert.assertEquals(6, result1);
        
        int result2 = sc.subtraction(7, 2);
        Assert.assertEquals(5, result2);
        
        int result3 = sc.subtraction(10, 5);
        Assert.assertEquals(5, result3);
        
        int result4 = sc.subtraction(4, 2);
        Assert.assertEquals(2, result4);
    }
}
