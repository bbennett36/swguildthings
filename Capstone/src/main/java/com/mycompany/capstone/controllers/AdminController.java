/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.capstone.controllers;

import com.mycompany.capstone.dao.AdminPageDao;
import com.mycompany.capstone.dao.BlogPostDao;
import com.mycompany.capstone.dao.CategoryDao;
import com.mycompany.capstone.dto.AdminPage;
import com.mycompany.capstone.dto.BlogPost;
import com.mycompany.capstone.dto.Category;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.HttpClientErrorException;

/**
 *
 * @author apprentice
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    private AdminPageDao adminPageDao;
    private BlogPostDao blogPostDao;
    private CategoryDao categoryDao;

    @Inject
    public AdminController(AdminPageDao adminPageDao, BlogPostDao blogPostDao, CategoryDao categoryDao) {
        this.adminPageDao = adminPageDao;
        this.blogPostDao = blogPostDao;
        this.categoryDao = categoryDao;

    }

//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//    public String showStaticPages(@PathVariable("id") Integer adminPageId, Map model) {
    @RequestMapping(value = "/{urlSlug}", method = RequestMethod.GET)
    public String showStaticPages(@PathVariable("urlSlug") String urlSlug, Map model) {
        List<AdminPage> adminPage = adminPageDao.listAdminPages();
        model.put("adminPage", adminPage);

        AdminPage staticPages = adminPageDao.getByUrlSlug(urlSlug);
        if(staticPages!=null){
        model.put("staticPages", staticPages);
        return "show_static_page";
        }
        else
        {
            return "redirect:/error";
        }

    }

    @RequestMapping(value = "/blogpost", method = RequestMethod.GET)
    public String showBlogposts(Map model) {
        List<AdminPage> adminPage = adminPageDao.listAdminPages();
        List<BlogPost> blogpostList = blogPostDao.listPosts();
        List<BlogPost> activePostList = new ArrayList();
        List<BlogPost> draftPostList = new ArrayList();
        List<BlogPost> archivedPostList = new ArrayList();

        for (BlogPost blogpost : blogpostList) {
            switch (blogpost.getStatusId()) {
                case 0:
                    archivedPostList.add(blogpost);
                    break;
                case 1:
                    activePostList.add(blogpost);
                    break;
                case 2:
                    draftPostList.add(blogpost);
                    break;
                default:
                    break;
            }
        }
        model.put("adminPage", adminPage);
        model.put("activeBlogposts", activePostList);
        model.put("draftBlogposts", draftPostList);
        model.put("archivedBlogposts", archivedPostList);

        List<Category> categoryList = categoryDao.listCategories();
        model.put("categoryList", categoryList);

        return "blogpost";
    }

}
