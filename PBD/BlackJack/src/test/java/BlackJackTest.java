/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.blackjack.BlackJack;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class BlackJackTest {
    
    public BlackJackTest() {
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
    // public void hello() {}m20463471
    
    @Test  
    public void tester()    {
        BlackJack bj = new BlackJack();
        
        int result = bj.dealerHit(16);
        
        Assert.assertEquals(16, result);
    }
}
