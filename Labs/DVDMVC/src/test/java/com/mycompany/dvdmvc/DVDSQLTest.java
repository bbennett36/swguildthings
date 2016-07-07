/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdmvc;

import com.mycompany.dvdmvc.dao.DVDDao;
import com.mycompany.dvdmvc.dto.DVD;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author apprentice
 */
public class DVDSQLTest {

    private DVDDao dao;

    public DVDSQLTest() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-persistence.xml");

        dao = ctx.getBean("dao", DVDDao.class);
    }

    DVD dvd = new DVD();

    @Before
    public void setUp() throws ParseException {
        dvd.setTitle("King Kong");
        dvd.setmPAA("M");
        dvd.setStudio("Universal");
        dvd.setDirectorsName("Brennan Bennett");
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        Date date = fmt.parse("2013-05-06");
        dvd.setReleaseDate(date);
        dao.create(dvd);
    }

    @After
    public void tearDown() {
        dao.delete(dvd);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void tester() {
        DVD testGet = dao.get(dvd.getId());
        boolean exists = true;
        if (testGet == null) {
            exists = false;
        }
        Assert.assertTrue(exists);

        String testUpdate = ("Bill");
        dvd.setDirectorsName(testUpdate);
        dao.update(dvd);
        Assert.assertTrue(dvd.getDirectorsName().equals(testUpdate));
        dao.delete(dvd);

        List<DVD> mpaaRatings = dao.getMPAA("M");
        if (mpaaRatings == null) {
            exists = false;
        }
        Assert.assertTrue(exists);

        List<DVD> studios = dao.getStudio("Universal");
        if (studios == null) {
            exists = false;
        }
        Assert.assertTrue(exists);

        List<DVD> dvdsInXYears = dao.findDvdsInXYears(5);
        if (dvdsInXYears == null) {
            exists = false;
        }
        Assert.assertTrue(exists);

        DVD oldest = dao.findOldest();
        if (oldest == null) {
            exists = false;
        }
        Assert.assertTrue(exists);

        DVD newest = dao.findNewest();
        if (newest == null) {
            exists = false;
        }
        Assert.assertTrue(exists);

        List<DVD> dvds = dao.getDvds();
        if (dvds == null) {
            exists = false;
        }
        Assert.assertTrue(exists);

       
    }
}
