/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.capstone.controllers;

import com.mycompany.capstone.commandobject.AdminPagesCommand;
import com.mycompany.capstone.dao.AdminPageDao;
import com.mycompany.capstone.dao.CategoryDao;
import com.mycompany.capstone.dao.ImageDao;
import com.mycompany.capstone.dao.StatusValueDao;
import com.mycompany.capstone.dao.UserDao;
import com.mycompany.capstone.dto.AdminPage;
import com.mycompany.capstone.dto.StatusValue;
import com.mycompany.capstone.dto.User;
import java.security.Principal;
import java.util.ArrayList;
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
@RequestMapping(value = "/adminpages")
public class AdminPageController {

    private UserDao userDao;
    private CategoryDao categoryDao;
    private ImageDao imageDao;
    private AdminPageDao adminPageDao;
    private StatusValueDao statusValueDao;

    @Inject
    public AdminPageController(UserDao userDao, CategoryDao categoryDao, ImageDao imageDao, AdminPageDao adminPageDao, StatusValueDao statusValueDao) {
        this.userDao = userDao;
        this.categoryDao = categoryDao;
        this.imageDao = imageDao;
        this.adminPageDao = adminPageDao;
        this.statusValueDao = statusValueDao;
    }

    @RequestMapping(value = "/pages", method = RequestMethod.GET)
    public String adminPages(Map model) {
        List<AdminPage> adminPage = adminPageDao.listAdminPages();
        List<AdminPage> allAdminPage = adminPageDao.listAllAdminPages();
        List<AdminPage> activePageList = new ArrayList();
        List<AdminPage> draftPageList = new ArrayList();
        List<AdminPage> archivedPageList = new ArrayList();

        List<User> users = userDao.listUsers();
        List<StatusValue> statusValue = statusValueDao.listStatusValues();

        for (AdminPage adminPages : allAdminPage) {

            switch (adminPages.getStatus().getId()) {
                case 0:
                    archivedPageList.add(adminPages);
                    break;
                case 1:
                    activePageList.add(adminPages);
                    break;
                case 2:
                    draftPageList.add(adminPages);
                    break;
                default:
                    break;
            }

        }

        model.put("adminPage", adminPage);
        model.put("activePageList", activePageList);
        model.put("draftPageList", draftPageList);
        model.put("archivedPageList", archivedPageList);

        model.put("users", users);
        model.put("statusValue", statusValue);
        return "adminpages";
    }

    @RequestMapping(value = "/createnewstaticpage", method = RequestMethod.GET)
    public String inputForCreateStaticPage(Map model) {

        List<AdminPage> adminPage = adminPageDao.listAdminPages();
        model.put("adminPage", adminPage);

        //List<User> users=userDao.listUsers();
        //model.put("users",users);
//        User user = userDao.getByName(principal.getName());
//        model.put("authenticatedUserId",user.getId());
        List<StatusValue> pageStatus = statusValueDao.listStatusValues();
        model.put("pageStatus", pageStatus);

        return "create_adminpage";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public AdminPage create(@Valid @RequestBody AdminPagesCommand command, Map model, Principal principal) {

        AdminPage adminPageCreate = new AdminPage();

        adminPageCreate.setPageName(command.getPageName());        
        adminPageCreate.setPageBody(command.getPageBody());
//        adminPageCreate.setAuthor(userDao.get(command.getAuthorId()));
        //added code for url slug------begin
        String temp=adminPageCreate.getPageName();
        String urlSlug=temp.replaceAll("[^a-zA-Z0-9]","+");
        urlSlug=urlSlug.toLowerCase();
        adminPageCreate.setUrlSlug(urlSlug);
        //added code for url slug------end

        int sequence = setPageSequence(command.getStatusId());
        adminPageCreate.setSequence(sequence);
        
        User user = userDao.getByName(principal.getName());
        adminPageCreate.setAuthor(userDao.get(user.getId()));
        adminPageCreate.setStatus(statusValueDao.get(command.getStatusId()));
        adminPageDao.create(adminPageCreate);

        List<AdminPage> adminPage = adminPageDao.listAdminPages();
        model.put("adminPage", adminPage);

        return adminPageCreate;

    }
    
    @RequestMapping(value="/retrieve/{id}", method = RequestMethod.GET)
    @ResponseBody
    public AdminPage retrieveById(@PathVariable("id") Integer adminpageId) {
        
        AdminPage adminPage = adminPageDao.get(adminpageId);
        return adminPage;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable("id") Integer pageId, Map model) {
        AdminPage adminPageById = adminPageDao.get(pageId);     //.get(addressId);
        model.put("adminPageById", adminPageById);

        List<AdminPage> adminPage = adminPageDao.listAdminPages();
        model.put("adminPage", adminPage);

        List<User> users = userDao.listUsers();
        model.put("users", users);

        List<StatusValue> pageStatus = statusValueDao.listStatusValues();
        model.put("pageStatus", pageStatus);

        return "adminpages_edit";
    }

//    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
//    @ResponseBody
//
//    public AdminPage edit(@PathVariable("id") Integer pageId, Map model) {
//        List<AdminPage> adminPage = adminPageDao.listAdminPages();
//        model.put("adminPage", adminPage);
//
//        List<StatusValue> pageStatus = statusValueDao.listStatusValues();
//        AdminPage adminPageById = adminPageDao.get(pageId);
//
//        return adminPageById;
//    }
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    @ResponseBody
    public AdminPage editStateSubmit(@Valid @RequestBody AdminPagesCommand command) {

//    @RequestMapping(value = "/adminpages/pages", method = RequestMethod.POST)    
//    public String editStateSubmit(@ModelAttribute AdminPagesCommand command) {    
        AdminPage adminPage = new AdminPage();
        adminPage.setId(command.getId());
        adminPage.setPageName(command.getPageName());
        adminPage.setPageBody(command.getPageBody());        
        adminPage.setAuthor(userDao.get(command.getAuthorId()));
        adminPage.setStatus(statusValueDao.get(command.getStatusId()));
//        adminPage.setLastModifiedBy(command.getAuthorId());

        int sequence = setPageSequence(command.getStatusId());
        adminPage.setSequence(sequence);

//added code for url slug------begin
        String temp=adminPage.getPageName();
        String urlSlug=temp.replaceAll("[^a-zA-Z0-9]","+");
        adminPage.setUrlSlug(urlSlug);
        //added code for url slug------end
        adminPageDao.update(adminPage);

//        return "adminpages";
        return adminPage;
    }

    @RequestMapping(value = "/orderpages", method = RequestMethod.PUT)
    @ResponseBody
    public String reorderAdminPages(@RequestBody AdminPagesCommand command) {

        AdminPage adminPage = new AdminPage();
        adminPage.setId(command.getId());
        adminPage.setSequence(command.getSequence());

        adminPageDao.updateSequence(adminPage);
        return "pages";
    }
    
    public int setPageSequence(int pageStatusId) {
        
        int sequence = 0;       
        
        if (pageStatusId == 1) {
            sequence = adminPageDao.getNextPageSequence();
        }
        
        return sequence;
    }

}
