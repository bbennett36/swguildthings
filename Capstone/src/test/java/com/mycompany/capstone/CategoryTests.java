/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.capstone;

import com.mycompany.capstone.dao.CategoryDao;
import com.mycompany.capstone.dto.Category;
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
public class CategoryTests {

    private CategoryDao categoryDao;

    public CategoryTests() {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-persistence.xml");

        categoryDao = ctx.getBean("categoryDao", CategoryDao.class);
    }

    Category category = new Category();

    @Before
    public void setUp() {
        category.setCategory("Finance");
        categoryDao.create(category);
    }

    @After
    public void tearDown() {
        categoryDao.delete(category);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void test1() {

        Assert.assertTrue(category != null);

        Category testGet = categoryDao.get(category.getId());

        Assert.assertTrue(testGet.getCategory().equals("Finance"));
        categoryDao.create(testGet);

        String testUpdate = "Tech";
        testGet.setCategory(testUpdate);
        categoryDao.update(testGet);
        

        Category updated = categoryDao.get(testGet.getId());
        Assert.assertTrue(updated.getCategory().equals(testUpdate));
        categoryDao.delete(testGet);

        List<Category> testList = categoryDao.listCategories();
        Assert.assertTrue(testList != null);

    }
}
