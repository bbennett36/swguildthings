/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.capstone;

import com.mycompany.capstone.dao.CommentDao;
import com.mycompany.capstone.dao.HashtagDao;
import com.mycompany.capstone.dto.Hashtag;
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
public class HashtagTest {
    
    private HashtagDao hashtagDao;

    public HashtagTest() {
        
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-persistence.xml");

        hashtagDao = ctx.getBean("hashtagDao", HashtagDao.class);
        
    }
    
    Hashtag test = new Hashtag();

    @Before
    public void setUp() {
        test.setHashtag("Cool");
        hashtagDao.create(test);
        
    }

    @After
    public void tearDown() {
        hashtagDao.delete(test);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void tester()    {
        Assert.assertTrue(test != null);
        
        List<Hashtag> hashtags = hashtagDao.listHashtags();
        Assert.assertTrue(hashtags.size() > 0);
        
        Hashtag testGet = hashtagDao.getById(test.getId());
        Assert.assertTrue(testGet != null);
        
    }
}
