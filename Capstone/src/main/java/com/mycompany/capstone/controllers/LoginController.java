/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.capstone.controllers;

import com.mycompany.capstone.commandobject.UserCommand;
import com.mycompany.capstone.dao.RoleDao;
import com.mycompany.capstone.dao.UserDao;
import com.mycompany.capstone.dto.Role;
import com.mycompany.capstone.dto.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author apprentice
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {

    private UserDao userDao;
    private RoleDao roleDao;

    @Inject
    public LoginController(UserDao userDao, RoleDao roleDao) {
        this.userDao = userDao;
        this.roleDao = roleDao;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@RequestParam(name = "login_error", required = false) Integer loginError, Map model) {

        model.put("loginError", loginError);

        return "login";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signUp(@RequestParam(name = "login_error", required = false) Integer loginError, Map model) {

        model.put("loginError", loginError);

        boolean signUp = true;
        model.put("signUp", signUp);

        return "login";
    }

    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
    public String createUser(@ModelAttribute UserCommand userCommandObj, Map model) {

        String userExists = "This username is already in use";

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
            model.put("userExists", userExists);
            boolean signUp = true;
            model.put("signUp", signUp);
            return "login";
        } else {
            List<Role> userRoles = new ArrayList();
            userRoles.add(roleDao.getRoleByRoleName("ROLE_USER"));
            user.setUserRoles(userRoles);
            user.setEnabled(1);
            userDao.create(user);
            return "login";
        }

    }

}
