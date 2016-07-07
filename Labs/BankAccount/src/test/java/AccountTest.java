/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.dao.CheckingDao;
import com.mycompany.dao.SavingDao;
import com.mycompany.dto.Checking;
import com.mycompany.dto.Savings;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class AccountTest {
    
    public AccountTest() {
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
    public void tester()   {
        
        SavingDao sdao = new SavingDao();
        CheckingDao cdao = new CheckingDao();
        
        Savings Brennan = new Savings();
        Brennan.setPin(1234);
        
        sdao.create(Brennan);
        
        Brennan.deposit(500);
        boolean deposited = true;
        if(Brennan.getBalance() != 500)    {
            deposited = false;
        }
        Assert.assertEquals(true, deposited);       
        
        
        Brennan.withdraw(600);
        if(Brennan.getBalance() != 500) {
            deposited = false;
        }
        Assert.assertEquals(true, deposited);
        
        Checking Bennett = new Checking();
        Bennett.setPin(1235);
        
        cdao.create(Bennett);
        
        Bennett.deposit(500);
        if(Bennett.getBalance() != 500)    {
            deposited = false;
        }
        Assert.assertEquals(true, deposited);    
        
        Bennett.withdraw(589);
        if(Bennett.getBalance() != -99) {
            deposited = false;
        }
        Assert.assertEquals(true, deposited);
        
        
        
        
    }
}
