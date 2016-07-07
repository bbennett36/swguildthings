/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.capstone.dao;

import com.mycompany.capstone.dto.AdminPage;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface AdminPageDao {
    
    public AdminPage create(AdminPage adminPage);
    public AdminPage get(int id);
    public void update(AdminPage adminPage);
    public void delete(AdminPage adminPage);
    public List<AdminPage> listAdminPages();
    
}
