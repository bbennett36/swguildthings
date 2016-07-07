/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.capstone.dao;

import com.mycompany.capstone.dto.AdminPage;
import com.mycompany.capstone.dto.StatusValue;
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
public class StatusValueDaoDbImpl implements StatusValueDao {
    
    

    private JdbcTemplate jdbcTemplate;
    private static final String SQL_GET_STATUS = "select * from statuscodes where id = ?";
    private static final String SQL_GET_LIST_OF_STATUS = "select * from statuscodes";

    public StatusValueDaoDbImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public StatusValue create(StatusValue statusValue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public StatusValue get(int id) {
        return jdbcTemplate.queryForObject(SQL_GET_STATUS, new StatusValueMapper(), id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void update(StatusValue statusValue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(StatusValue statusValue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<StatusValue> listStatusValues() {
       return jdbcTemplate.query(SQL_GET_LIST_OF_STATUS, new StatusValueMapper());
    }
    
    private  final class StatusValueMapper implements RowMapper<StatusValue> {
        @Override
        public StatusValue mapRow(ResultSet rs, int i) throws SQLException {

            StatusValue sv = new StatusValue();
            sv.setId(rs.getInt("id"));
            sv.setBlogStatus(rs.getString("status"));
            return sv;
        }
    }

}
