/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.capstone.dao;

import com.mycompany.capstone.dto.Role;
import com.mycompany.capstone.dto.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author apprentice
 */
public class UserDaoDbImpl implements UserDao {
    
    private static final String SQL_CREATE_USER = "INSERT INTO users "
            + "(first_name, last_name, email, password, username, enabled) "
            + "VALUES (?, ?, ?, ?, ?, ?)";
    private static final String SQL_CREATE_USERROLE = "INSERT INTO userroles "
            + "(user_id, role_id)"
            + "VALUES (?, ?)";
    
    private static final String SQL_GET_USERROLE_COUNT = "SELECT COUNT(*) FROM userroles WHERE user_id = ? AND role_id = ?";
    
    private static final String SQL_GET_USER_BY_ID = "SELECT * FROM users WHERE id = ?";
    private static final String SQL_GET_USER_BY_NAME = "SELECT * FROM users WHERE username = ?";
    private static final String SQL_GET_ROLES_FOR_USER = "SELECT * FROM users u"
            + "INNER JOIN userroles ur ON ur.user_id = u.ud "
            + "INNER JOIN roles r ON r.id = ur.role_id WHERE u.id = ?";
    
    private static final String SQL_GET_LIST_OF_USERS = "SELECT * FROM users";
    
    private static final String SQL_UPDATE_USER = "UPDATE users "
            + "SET first_name = ?, last_name = ?, email = ?, username = ? "
            + "WHERE id = ?";

    private final JdbcTemplate jdbcTemplate;

    public UserDaoDbImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public User create(User user) {
        
        jdbcTemplate.update(SQL_CREATE_USER,
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPassword(),
                user.getUsername(),
                user.getEnabled()
        );
        
        Integer userId = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        user.setId(userId);
        
        List<Role> userRoles = user.getUserRoles();
        
        for (Role role : userRoles) {
            if (jdbcTemplate.queryForObject(SQL_GET_USERROLE_COUNT, Integer.class, user.getId(), role.getId()) == 0) {
                jdbcTemplate.update(SQL_CREATE_USERROLE, user.getId(), role.getId());
            }
        }
        
        return user;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public User get(int id) {
        
        return jdbcTemplate.queryForObject(SQL_GET_USER_BY_ID, new UserMapper(), id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public User getByName(String username) {
        
        return jdbcTemplate.queryForObject(SQL_GET_USER_BY_NAME, new UserMapper(), username);
    }
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void update(User user) {
        jdbcTemplate.update(SQL_UPDATE_USER,
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getUsername(),
                user.getId()
        );
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<User> listUsers() {
        return jdbcTemplate.query(SQL_GET_LIST_OF_USERS, new UserMapper());
    }
    
    private static final class UserMapper implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet rs, int i) throws SQLException {

            User user = new User();
            user.setId(rs.getInt("id"));    
            user.setUsername(rs.getString("username"));
            user.setFirstName(rs.getString("first_name"));
            user.setLastName(rs.getString("last_name"));
            user.setEmail(rs.getString("email"));
            List<Role> userRoles = new ArrayList();
            Role role1 = new Role();
            role1.setId(2);
            role1.setRole("ROLE_ADMIN");
            userRoles.add(role1);
            user.setUserRoles(userRoles);

            return user;
        }
    }
}
