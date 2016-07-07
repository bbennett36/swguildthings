/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.capstone.dao;

import com.mycompany.capstone.dto.Role;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface RoleDao {
    
    public Role create(Role role);
    public Role get(int id);
    public Role getRoleByRoleName(String role);
    public void update(Role role);
    public void delete(Role role);
    public List<Role> listRoles();
    
}
