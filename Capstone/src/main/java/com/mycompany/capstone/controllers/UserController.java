/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.capstone.controllers;

import com.mycompany.capstone.commandobject.UserCommand;
import com.mycompany.capstone.dao.AdminPageDao;
import com.mycompany.capstone.dao.RoleDao;
import com.mycompany.capstone.dao.UserDao;
import com.mycompany.capstone.dto.AdminPage;
import com.mycompany.capstone.dto.Role;
import com.mycompany.capstone.dto.User;
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
@RequestMapping(value = "/userroles")
public class UserController {

    private AdminPageDao adminPageDao;
    private UserDao userDao;
    private RoleDao roleDao;

    @Inject
    public UserController(UserDao userDao, AdminPageDao adminPageDao, RoleDao roleDao) {
        this.userDao = userDao;
        this.adminPageDao = adminPageDao;
        this.roleDao = roleDao;
    }

    @RequestMapping(value = "/useradmin", method = RequestMethod.GET)
    private String loadUserrolePage(Map model) {

        List<AdminPage> adminpageList = adminPageDao.listAdminPages();
        List<User> userList = userDao.listUsers();
        List<Role> roleList = roleDao.listRoles();

        model.put("adminPage", adminpageList);
        model.put("userList", userList);
        model.put("roleList", roleList);

        return "adminusers";
    }

    @RequestMapping(value = "/createuser", method = RequestMethod.GET)
    private String loadNewUserForm(Map model) {
        List<AdminPage> adminpageList = adminPageDao.listAdminPages();
        model.put("adminPage", adminpageList);

        List<Role> roleList = roleDao.listRoles();
        model.put("roleList", roleList);

        return "user_create";
    }
    
    @RequestMapping(value = "/edituser/{id}", method = RequestMethod.GET)
    private String displayEditUserForm(@PathVariable("id") Integer userId, Map model) {
        
        User user = userDao.get(userId);
        List<Role> roleList = roleDao.listRoles();
        
        model.put("user", user);
        model.put("roleList", roleList);
        
        return "user_edit";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public User createUser(@Valid @RequestBody UserCommand userCommandObj) {

        User user = new User();
        user.setId(userCommandObj.getId());
        user.setFirstName(userCommandObj.getFirstName());
        user.setLastName(userCommandObj.getLastName());
        user.setEmail(userCommandObj.getEmail());
        user.setPassword(userCommandObj.getPassword());
        user.setUsername(userCommandObj.getUsername());

        List<User> allUsers = userDao.listUsers();
        List<String> usernames = new ArrayList();

        for (User u : allUsers) {
            usernames.add(u.getUsername());
        }

        if (usernames.contains(user.getUsername())) {
//            model.put("userExists", userExists);
//            boolean signUp = true;
//            model.put("signUp", signUp);
            return null;
        } else {
            List<Role> userRoles = new ArrayList();
            for (Integer roleId : userCommandObj.getRoleIdList()) {
                userRoles.add(roleDao.get(roleId));
            }
            user.setUserRoles(userRoles);
            user.setEnabled(1);
            userDao.create(user);
            return user;
        }

//        userDao.create(user);
//        return user;
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    @ResponseBody
    public User updateUser(@RequestBody UserCommand userCommandObj) {
        
        User user = new User();
        user.setId(userCommandObj.getId());
        user.setFirstName(userCommandObj.getFirstName());
        user.setLastName(userCommandObj.getLastName());
        user.setEmail(userCommandObj.getEmail());
        user.setUsername(userCommandObj.getUsername());
        
        userDao.update(user);
        return user;
    }
    
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    @ResponseBody
    public User showUserInfo(@PathVariable("id") Integer userId) {

        User user = userDao.get(userId);
        return user;
    }
}
