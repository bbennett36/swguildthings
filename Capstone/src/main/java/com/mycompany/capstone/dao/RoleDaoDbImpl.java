/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.capstone.dao;

import com.mycompany.capstone.dto.Role;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author apprentice
 */
public class RoleDaoDbImpl implements RoleDao {

    private final JdbcTemplate jdbcTemplate;
    
    private final static String SQL_CREATE_ROLE = "INSERT INTO roles "
            + "(role) VALUES (?)";
    
    private final static String SQL_GET_ROLE_BY_ID = "SELECT * FROM roles WHERE id = ?";
    private final static String SQL_GET_ROLE_BY_ROLE_NAME = "SELECT * FROM roles WHERE role=?";
    
    private final static String SQL_GET_ROLE_LIST = "SELECT * FROM roles";

    public RoleDaoDbImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Role create(Role role) {
        
        jdbcTemplate.update(SQL_CREATE_ROLE, role.getRole());
        
        Integer roleId = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        role.setId(roleId);
        
        return role;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Role get(int id) {
        return jdbcTemplate.queryForObject(SQL_GET_ROLE_BY_ID, new RoleMapper(), id);
    }
     @Override
     @Transactional(propagation = Propagation.REQUIRED)
    public Role getRoleByRoleName(String role) {
        return jdbcTemplate.queryForObject(SQL_GET_ROLE_BY_ROLE_NAME, new RoleMapper(), role);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void update(Role role) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(Role role) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Role> listRoles() {
        return jdbcTemplate.query(SQL_GET_ROLE_LIST, new RoleMapper());
    }

   

    
    
    private static final class RoleMapper implements RowMapper<Role> {

        @Override
        public Role mapRow(ResultSet rs, int i) throws SQLException {
            
            Role newRole = new Role();
            newRole.setId(rs.getInt("id"));
            newRole.setRole(rs.getString("role"));
            return newRole;
        }
        
    }
}
