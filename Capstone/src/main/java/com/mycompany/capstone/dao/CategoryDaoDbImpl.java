/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.capstone.dao;

import com.mycompany.capstone.dto.Category;
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
public class CategoryDaoDbImpl implements CategoryDao {

    private static final String SQL_INSERT_CATEGORY = "insert into categories (category) values (?)";
    private static final String SQL_DELETE_CATEGORY = "delete from categories where id = ?";
    private static final String SQL_GET_CATEGORY = "select * from categories where id = ?";
    private static final String SQL_UPDATE_CATEGORY = "update categories set category = ? where id = ?";
    private static final String SQL_LIST_CATEGORIES = "select * from categories";

    private final JdbcTemplate jdbcTemplate;

    public CategoryDaoDbImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Category create(Category category) {
        jdbcTemplate.update(SQL_INSERT_CATEGORY,
                category.getCategory());

        Integer id = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);

        category.setId(id);

        return category;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Category get(int id) {
        return jdbcTemplate.queryForObject(SQL_GET_CATEGORY, new CategoryMapper(), id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void update(Category category) {
         jdbcTemplate.update(SQL_UPDATE_CATEGORY,
                category.getCategory(),
                category.getId());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(Category category) {
        jdbcTemplate.update(SQL_DELETE_CATEGORY, category.getId());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Category> listCategories() {
        return jdbcTemplate.query(SQL_LIST_CATEGORIES, new CategoryMapper());
    }

    private static final class CategoryMapper implements RowMapper<Category> {

        @Override
        public Category mapRow(ResultSet rs, int i) throws SQLException {

            Category category = new Category();

            category.setId(rs.getInt("id"));
            category.setCategory(rs.getString("category"));

            return category;

        }

    }

}
