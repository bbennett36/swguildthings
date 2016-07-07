/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdmvc;

import com.mycompany.dvdmvc.dao.NotesDao;
import com.mycompany.dvdmvc.dto.Note;
import java.util.ArrayList;
import java.util.List;
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
public class NoteSQLTest {
    
    private NotesDao ndao;
    
    public NoteSQLTest() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-persistence.xml");

        ndao = ctx.getBean("ndao", NotesDao.class);
    }
    
    Note note = new Note();
    @Before
    public void setUp() {
        note.setMovieId(1);
        note.setNote("Good movie");
        ndao.create(note);
    }
    
    @After
    public void tearDown() {
        ndao.delete(note);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void tester()    {
        
        
        Note testGet = ndao.get(note.getId());
        Assert.assertTrue(testGet != null);
        
        List<Note> notes = ndao.list();
        boolean exists = true;
        if(notes == null)   {
            exists = false;
        }
        Assert.assertTrue(exists);
        
        String test = "1/10 bad movie";
        note.setNote(test);
        ndao.update(note);
        Assert.assertTrue(note.getNote().equals(test));
        
        
        
    }
}
