/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.dao.OrderDao;
import com.mycompany.dao.TaxesDao;
import com.mycompany.dto.Tax;
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
public class TaxTest {

    public TaxTest() {
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
    public void testCreate() {
//        TaxesDao tdao = new TaxesDao();
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        TaxesDao tdao = ctx.getBean("tdao", TaxesDao.class);

        //test create in tax dao
        Tax newTax = new Tax();
        newTax.setState("NY");
        newTax.setTaxRate(7.5);
        tdao.create(newTax);

//        make sure it was created & test get
        Tax exist = tdao.get("NY");
        boolean created = true;
        if (exist == null) {
            created = false;
        }
        Assert.assertEquals(true, created);
//
        //test update in tax dao
        Tax update = tdao.get("NY");
        update.setState("MA");
        tdao.update(update);
        boolean updated = true;
        if (!update.getState().equals("MA")) {
            updated = false;
        }
        Assert.assertEquals(true, updated);
        tdao.delete(update);

//        //test delete in dao
//        Tax delete = tdao.get("MA");
//        tdao.delete(delete);
//        boolean deleted = true;
//        if (delete != null) {
//            deleted = false;
//        }
//        Assert.assertEquals(true, deleted);
    }
}
