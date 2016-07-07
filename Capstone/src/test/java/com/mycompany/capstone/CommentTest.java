/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.capstone;

import com.mycompany.capstone.dao.CommentDao;
import com.mycompany.capstone.dto.Comment;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class CommentTest {
    
    private CommentDao commentDao;

    public CommentTest() {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-persistence.xml");

        commentDao = ctx.getBean("commentDao", CommentDao.class);

    }

    Comment test = new Comment();
    
    @Before
    public void setUp() throws ParseException {
        
        test.setComment("Good post");
        test.setBlogPostId(1);
        test.setUserName("smnoor");
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        Date date = fmt.parse("2013-05-06");
        test.setCommentDate(date);
        commentDao.create(test);

    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
