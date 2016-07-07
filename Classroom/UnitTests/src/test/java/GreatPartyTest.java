/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class GreatPartyTest {
    
    public GreatPartyTest() {
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
    public void testGreatParty()    {
        
        GreatParty gp = new GreatParty();
        
        
        //if 30 cigars and its not the weeknnd, bad party.
        boolean result = gp.greatParty(30, false);
        
        Assert.assertEquals(false, result);
   
    }
    @Test
    public void testGreatParty2()    {
        GreatParty gp = new GreatParty();
        //if 50 cigars and its not the weeknnd, good party.
        boolean result = gp.greatParty(50, false);
        
        Assert.assertEquals(true, result);
        
   
    }
    @Test
    public void testGreatParty3()    {
        GreatParty gp = new GreatParty();
        //if 70 cigars and it is the weeknnd, good party.
        boolean result = gp.greatParty(70, true);
        
        Assert.assertEquals(true, result);
   
    }
}
