/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.capstone.controllers;

import com.mycompany.capstone.dao.AdminPageDao;
import com.mycompany.capstone.dao.BlogPostDao;
import com.mycompany.capstone.dao.CategoryDao;
import com.mycompany.capstone.dao.CommentDao;
import com.mycompany.capstone.dao.HashtagDao;
import com.mycompany.capstone.dao.ImageDao;
import com.mycompany.capstone.dao.QuoteDao;
import com.mycompany.capstone.dao.RoleDao;
import com.mycompany.capstone.dao.StatusValueDao;
import com.mycompany.capstone.dao.UserDao;
import com.mycompany.capstone.dto.AdminPage;
import com.mycompany.capstone.dto.BlogPost;
import com.mycompany.capstone.dto.Quote;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import static java.util.Collections.reverseOrder;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.json.simple.JSONArray;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author apprentice
 */
@Controller
public class HomeController {

    private AdminPageDao adminPageDao;
    private BlogPostDao blogPostDao;
    private CategoryDao categoryDao;
    private CommentDao commentDao;
    private HashtagDao hashtagDao;
    private ImageDao imageDao;
    private RoleDao roleDao;
    private StatusValueDao statusValueDao;
    private UserDao userDao;
    private QuoteDao quoteDao;

    @Inject
    public HomeController(AdminPageDao adminPageDao, BlogPostDao blogPostDao, CategoryDao categoryDao,
            CommentDao commentDao, HashtagDao hashtagDao, ImageDao imageDao, RoleDao roleDao, StatusValueDao statusValueDao, UserDao userDao, QuoteDao quoteDao) {
        this.adminPageDao = adminPageDao;
        this.blogPostDao = blogPostDao;
        this.categoryDao = categoryDao;
        this.commentDao = commentDao;
        this.hashtagDao = hashtagDao;
        this.imageDao = imageDao;
        this.roleDao = roleDao;
        this.statusValueDao = statusValueDao;
        this.userDao = userDao;
        this.quoteDao = quoteDao;
    }


    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String home(Map model, @RequestParam(value = "page", required = false) Integer pageNumber) {

        List<Integer> pages = getPages(3);// set limit of post per page
        model.put("pages", pages);

        Integer offset;
        if (pageNumber == null) {
            offset = 0;
        } else {
            offset = getOffset(pageNumber);
        }

        List<BlogPost> posts = blogPostDao.listBlogWithLimit(offset);
        model.put("posts", posts);

        //model.put("activePosts", activePosts);
        List<AdminPage> adminPage = adminPageDao.listAdminPages();
        model.put("adminPage", adminPage);

        return "home";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
    }

    public Integer getOffset(Integer pageNumber) {
        Integer numberOfPosts = 3;
        Integer offset = (pageNumber * numberOfPosts) - numberOfPosts;
        return offset;
    }

    public List<Integer> getPages(Integer number) {

        Integer count = blogPostDao.getNumOfPosts();
        Integer numberOfPages = (count / number);
        Integer reminder=(count%number);
        numberOfPages+=reminder;
        List<Integer> pages = new ArrayList();
        for (int i = 1; i <= numberOfPages; i++) {
            pages.add(i);
        }
        return pages;
    }

}
