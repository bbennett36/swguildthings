/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.capstone.controllers;

import com.mycompany.capstone.dao.AdminPageDao;

import com.mycompany.capstone.commandobject.BlogPostCommand;
import com.mycompany.capstone.dao.BlogPostDao;
import com.mycompany.capstone.dao.CategoryDao;
import com.mycompany.capstone.dao.CommentDao;
import com.mycompany.capstone.dao.HashtagDao;
import com.mycompany.capstone.dao.ImageDao;
import com.mycompany.capstone.dao.StatusValueDao;
import com.mycompany.capstone.dao.UserDao;
import com.mycompany.capstone.dto.AdminPage;
import com.mycompany.capstone.dto.BlogPost;
import com.mycompany.capstone.dto.Category;
import com.mycompany.capstone.dto.Comment;
import com.mycompany.capstone.dto.Hashtag;
import com.mycompany.capstone.dto.StatusValue;
import com.mycompany.capstone.dto.User;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
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
@RequestMapping(value = "/blogpost")
public class BlogPostController {

    private BlogPostDao blogPostDao;
    private UserDao userDao;
    private CategoryDao categoryDao;
    private ImageDao imageDao;
    private CommentDao commentDao;
    private HashtagDao hashtagDao;
    private AdminPageDao adminPageDao;
    private StatusValueDao statusValueDao;

    @Inject
    public BlogPostController(BlogPostDao blogPostDao, UserDao userDao, CategoryDao categoryDao, ImageDao imageDao, AdminPageDao adminPageDao, CommentDao commentDao, HashtagDao hashtagDao, StatusValueDao statusValueDao) {
        this.blogPostDao = blogPostDao;
        this.userDao = userDao;
        this.categoryDao = categoryDao;
        this.imageDao = imageDao;
        this.hashtagDao = hashtagDao;
        this.adminPageDao = adminPageDao;
        this.commentDao = commentDao;
        this.statusValueDao = statusValueDao;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public BlogPost create(@Valid @RequestBody BlogPostCommand commandObj, Principal principal) {

        BlogPost blogPost = new BlogPost();
        blogPost.setTitle(commandObj.getTitle());
        //added code for url slug------begin
//        String temp = blogPost.getTitle();
//        String urlSlug = temp.replaceAll("[^a-zA-Z0-9]", "+");
//        urlSlug = urlSlug.toLowerCase();
//        blogPost.setUrlSlug(urlSlug);
        //added code for url slug------end
        blogPost.setBody(commandObj.getBody());
        blogPost.setStartDate(commandObj.getStartDate());
        blogPost.setExpirationDate(commandObj.getExpirationDate());
        blogPost.setStatusId(commandObj.getStatusId());
        blogPost.setCreationDate(commandObj.getCreationDate());
        
        Category category = categoryDao.get(commandObj.getCategoryId());
        blogPost.setCategory(category);

        User author = userDao.getByName(principal.getName());
        blogPost.setAuthor(userDao.get(author.getId()));

        List<Hashtag> hashtagList = new ArrayList();
        if (commandObj.getHashtagList() != null) {
            hashtagList = SetHashtagsForPost(commandObj.getHashtagList());
        }
        blogPost.setHashtagList(hashtagList);

        blogPost = blogPostDao.create(blogPost);

        return blogPost;
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    @ResponseBody
    public BlogPost editPost(@Valid @RequestBody BlogPostCommand commandObj,Principal principal) {

        BlogPost blogPost = new BlogPost();
        blogPost.setTitle(commandObj.getTitle());
        //added code for url slug------begin
//        String temp = blogPost.getTitle();
//        String urlSlug = temp.replaceAll("[^a-zA-Z0-9]", "+");
//        urlSlug = urlSlug.toLowerCase();
//        blogPost.setUrlSlug(urlSlug);
        //added code for url slug------end
        blogPost.setBody(commandObj.getBody());
        blogPost.setStartDate(commandObj.getStartDate());
        blogPost.setExpirationDate(commandObj.getExpirationDate());

        List<StatusValue> status = statusValueDao.listStatusValues();
        for (StatusValue s : status) {
            if (s.getBlogStatus().equals(commandObj.getStatus())) {
                blogPost.setStatusId(s.getId());
            }
        }
        //blogPost.setCreationDate(commandObj.getCreationDate());

        List<Category> categories = categoryDao.listCategories();
        for (Category c : categories) {
            if (c.getCategory().equals(commandObj.getCategoryName())) {
                blogPost.setCategory(c);
            }
        }

//       User author = userDao.get(1);
//        blogPost.setAuthor(author);
        
        User author = userDao.getByName(principal.getName());
        blogPost.setAuthor(userDao.get(author.getId()));

        List<Hashtag> hashtagList = new ArrayList();
        if (commandObj.getHashtagList() != null) {
            hashtagList = SetHashtagsForPost(commandObj.getHashtagList());
        }
        blogPost.setHashtagList(hashtagList);

        Date date = new Date();
        blogPost.setLastModifiedDate(date);

        blogPost.setLastModifiedBy(1);

        blogPost.setId(commandObj.getId());

//        blogPost.setStatusId(2);
        blogPostDao.update(blogPost);

        return blogPost;
    }

    @RequestMapping(value = "/publish", method = RequestMethod.PUT)
    @ResponseBody
    public BlogPost publishPost(@RequestBody BlogPost blogPost) {

        blogPostDao.publish(blogPost, "PUBLISHED");
        return blogPost;
    }

    @RequestMapping(value = "/archive", method = RequestMethod.PUT)
    @ResponseBody
    public BlogPost archivePost(@RequestBody BlogPost blogPost) {

        blogPostDao.archive(blogPost, "ARCHIVED");
        return blogPost;
    }

    @RequestMapping(value = "/createblogpost", method = RequestMethod.GET)
    public String displayCreateBlogpostForm(Map model) {
        
        List<AdminPage> adminpageList = adminPageDao.listAdminPages();
        model.put("adminPage", adminpageList);

        List<Category> categoryList = categoryDao.listCategories();
        User author = userDao.get(1);

        model.put("categoryList", categoryList);
        model.put("author", author);

        return "blogpost_create";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable("id") int id, Map model) {

        BlogPost bp = blogPostDao.get(id);

        List<Category> categoryList = categoryDao.listCategories();
        User author = userDao.get(1);

        List<StatusValue> status = statusValueDao.listStatusValues();

        model.put("status", status);
        model.put("categoryList", categoryList);
        model.put("author", author);

        model.put("bp", bp);
        
        List<AdminPage> adminPage = adminPageDao.listAdminPages();
        model.put("adminPage", adminPage);

        return "blogpost_edit";
    }

    @RequestMapping(value = "/editblogpost", method = RequestMethod.GET)
    public String displayEditBlogpostForm(Map model) {

        List<Category> categoryList = categoryDao.listCategories();
        User author = userDao.get(1);

        model.put("categoryList", categoryList);
        model.put("author", author);

        return "blogpost_edit";
    }

    @RequestMapping(value = "/retrieve/{id}", method = RequestMethod.GET)
    @ResponseBody
    public BlogPost showPublishBlogPostConfirmation(@PathVariable("id") Integer blogId, Map model) {
        BlogPost blogPost = blogPostDao.get(blogId);
        return blogPost;
    }
    
    
//        @RequestMapping(value = "/{urlSlug}", method = RequestMethod.GET)
//    public String showBlogPost(@PathVariable("urlSlug") String urlSlug,Map model) {
//        BlogPost blogPost = blogPostDao.getByUrlSlug(urlSlug);
    
        @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String showBlogPost(@PathVariable("id") Integer blogId, Map model) {
        BlogPost blogPost = blogPostDao.getActivePostById(blogId);
        model.put("blogPost", blogPost);

        List<AdminPage> adminPage = adminPageDao.listAdminPages();
        List<Comment> comments = new ArrayList();

//        //need blog id from url_slug here
//        BlogPost blogPostByUrlSlug=blogPostDao.getPostIdByUrlSlug(urlSlug);
//        Integer blogId=blogPostByUrlSlug.getId();
        
        List<Comment> commentList = commentDao.listComments();
        for (Comment c : commentList) {
            if (c.getBlogPostId() == blogId) {
                comments.add(c);
            }
        }

        List<BlogPost> blogPosts = blogPostDao.listActivePosts();
        List<User> authors = userDao.listUsers();
        for (BlogPost b : blogPosts) {
            for (User u : authors) {
                if (b.getAuthor().getId() == u.getId()) {
                    b.setAuthorName(u.getFirstName() + " " + u.getLastName());
                }
            }
        }

        model.put("blogPosts", blogPosts);
        model.put("adminPage", adminPage);
        model.put("comments", comments);
        model.put("adminPage", adminPage);
        return "all_blogs";
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String showAllBlogs(Map model) {

        List<AdminPage> adminPage = adminPageDao.listAdminPages();
        List<Comment> comments = new ArrayList();

        List<BlogPost> blogPosts = blogPostDao.listActivePosts();
        List<User> authors = userDao.listUsers();
        for (BlogPost b : blogPosts) {
            for (User u : authors) {
                if (b.getAuthor().getId() == u.getId()) {
                    b.setAuthorName(u.getFirstName() + " " + u.getLastName());
                }
            }
        }

        BlogPost blogPost = blogPosts.stream()
                .max(Comparator.comparing(a -> a.getCreationDate()))
                .get();

        List<Comment> commentList = commentDao.listComments();
        for (Comment c : commentList) {
            if (c.getBlogPostId() == blogPost.getId()) {
                comments.add(c);
            }
        }

        model.put("blogPost", blogPost);
        model.put("blogPosts", blogPosts);
        model.put("adminPage", adminPage);

        model.put("comments", comments);
        model.put("adminPage", adminPage);
        return "all_blogs";
    }

    @RequestMapping(value = "/c", method = RequestMethod.POST)
    @ResponseBody
    public Comment createComment(@RequestBody Comment comment, Principal principal) {

        Date date = new Date();
        comment.setCommentDate(date);
        comment.setUserName(principal.getName());
//        comment.setUserId(1);
//        comment.setBlogPostId(2);
//        model.put("comments", comments);

        return commentDao.create(comment);
    }

    private List<Hashtag> SetHashtagsForPost(List<String> hashtagList) {

        List<Hashtag> returnHashtagList = new ArrayList();

        for (String tag : hashtagList) {
            tag = tag.replace("#", "");
            Hashtag objHashtag = new Hashtag();
            objHashtag.setHashtag(tag);

            objHashtag = returnHashtag(objHashtag.getHashtag());
            returnHashtagList.add(objHashtag);
        }

        return returnHashtagList;
    }

    private Hashtag returnHashtag(String tag) {

        Hashtag hashtag = null;

        if (hashtagDao.getCount(tag) > 0) {
            hashtag = hashtagDao.getByTag(tag);
        } else {
            hashtag = new Hashtag();
            hashtag.setHashtag(tag);
            hashtag = hashtagDao.create(hashtag);
        }

        return hashtag;
    }

}
