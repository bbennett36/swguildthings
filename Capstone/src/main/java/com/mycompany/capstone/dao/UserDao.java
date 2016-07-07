/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.capstone.dao;

import com.mycompany.capstone.dto.User;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface UserDao {
    
    public User create(User user);
    public User get(int id);
    public User getByName(String username);
    public void update(User user);
    public void delete(User user);
    public List<User> listUsers();
    
}
