/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.capstone.controllers;

import com.mycompany.capstone.dao.AdminPageDao;
import com.mycompany.capstone.dao.CategoryDao;
import com.mycompany.capstone.dto.AdminPage;
import com.mycompany.capstone.dto.Category;
import com.mycompany.capstone.dto.StatusValue;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author apprentice
 */
@Controller
@RequestMapping(value = "/category")
public class CategoryController {

    private CategoryDao categoryDao;
    private AdminPageDao adminPageDao;

    @Inject

    public CategoryController(CategoryDao categoryDao, AdminPageDao adminPageDao) {
        this.categoryDao = categoryDao;
        this.adminPageDao = adminPageDao;

    }

    @RequestMapping(value = "/categories", method = RequestMethod.GET)

    public String redirect(Map model) {

        List<AdminPage> adminPage = adminPageDao.listAdminPages();
        model.put("adminPage", adminPage);
        List<Category> categories = categoryDao.listCategories();
        model.put("categories", categories);
        return "category";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public Category create(@Valid @RequestBody Category category) {
        category.setCategory(category.getCategory());
        return categoryDao.create(category);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable("id") int categoryId) {
        Category category = categoryDao.get(categoryId);
        categoryDao.delete(category);

    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    @ResponseBody
    public Category editCategory(@Valid @RequestBody Category category) {
        category.setCategory(category.getCategory());
        categoryDao.update(category);
        return category;

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Category show(@PathVariable("id") Integer categoryId) {

        Category category = categoryDao.get(categoryId);

        return category;

    }

}
