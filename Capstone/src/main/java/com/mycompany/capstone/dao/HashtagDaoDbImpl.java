/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.capstone.dao;

import com.mycompany.capstone.dto.AdminPage;
import com.mycompany.capstone.dto.Hashtag;
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
public class HashtagDaoDbImpl implements HashtagDao {
    
    private static final String SQL_INSERT_HASHTAG = "insert into hashtags (hashtag) values(?)";    
    private static final String SQL_DELETE_HASHTAG = "delete from hashtags where id = ?";
    private static final String SQL_ALL_HASHTAGS = "select * from hashtags";
    private static final String SQL_GET_HASHTAG_BY_ID = "select * from hashtags where id = ?";
    private static final String SQL_GET_HASHTAG_BY_NAME = "select * from hashtags where hashtag = ?";
    private static final String SQL_GET_HASHTAG_COUNT = "SELECT COUNT(*) FROM hashtags WHERE hashtag = ?";
    

    private final JdbcTemplate jdbcTemplate;

    public HashtagDaoDbImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Hashtag create(Hashtag hashtag) {
        
        jdbcTemplate.update(SQL_INSERT_HASHTAG,
                hashtag.getHashtag());
        
        
        Integer id = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);

        hashtag.setId(id);

        return hashtag;
        
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Hashtag getById(int id) {
        return jdbcTemplate.queryForObject(SQL_GET_HASHTAG_BY_ID, new HashtagMapper(), id);
    }
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Hashtag getByTag(String tag) {
        return jdbcTemplate.queryForObject(SQL_GET_HASHTAG_BY_NAME, new HashtagMapper(), tag);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void update(Hashtag hashtag) {
         jdbcTemplate.update(SQL_INSERT_HASHTAG,
                hashtag.getHashtag(),
                hashtag.getId());
        
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(Hashtag hashtag) {
        
        jdbcTemplate.update(SQL_DELETE_HASHTAG, hashtag.getId());
        
    }
    
    @Override
    public int getCount(String tag) {
        return jdbcTemplate.queryForObject(SQL_GET_HASHTAG_COUNT, Integer.class, tag);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Hashtag> listHashtags() {
        return jdbcTemplate.query(SQL_ALL_HASHTAGS, new HashtagMapper());
    }
    
     private static final class HashtagMapper implements RowMapper<Hashtag> {

        @Override
        public Hashtag mapRow(ResultSet rs, int i) throws SQLException {

            Hashtag hashtag = new Hashtag();

            hashtag.setId(rs.getInt("id"));
            hashtag.setHashtag(rs.getString("hashtag"));
           

            return hashtag;

        }

    }

}
