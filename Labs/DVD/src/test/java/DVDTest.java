/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.dvd.controller.DVDController;
import com.mycompany.dvd.dao.DVDDao;
import com.mycompany.dvd.dao.DVDLibraryImpl;
import com.mycompany.dvd.dto.DVD;
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
public class DVDTest {

    public DVDTest() {
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
//        DVDDao dao2 = new DVDDao();
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        DVDDao dao2 = ctx.getBean("otherDao", DVDDao.class);

        //Test get MPAA
        DVD mpaa = dao2.getMPAA("10");
        boolean exists = true;
        if (!mpaa.getmPAA().equals("10")) {
            exists = false;
        }
        Assert.assertEquals(true, exists);

        //Find movies in a studio
        DVD studio = dao2.getStudio("Lionhead");
        if (!studio.getStudio().equals("Lionhead")) {
            exists = false;
        }
        Assert.assertEquals(true, exists);

        List<DVD> dvds = dao2.findDvdsInXYears(24);
        int size = dvds.size();
        if (size != 3) {
            exists = false;
        }
        Assert.assertEquals(true, exists);
    }

    @Test
    public void lamTest() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        DVDLibraryImpl im = ctx.getBean("dao", DVDLibraryImpl.class);

        //Test Get
        DVD get = im.get(1);
        String movie = get.getTitle();
        Assert.assertEquals("Scarface", movie);

        DVD oldest = im.findOldest();
        boolean works = true;
        if (oldest.getId() != 1) {
            works = false;
        }
        Assert.assertEquals(true, works);

        DVD youngest = im.findNewest();
        Assert.assertEquals(3, youngest.getId());
    }

}
