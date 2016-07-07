/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmvc.dao;

import com.mycompany.flooringmvc.dto.Product;
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
public class ProductDaoDbImpl implements ProductDaoInterface {

    private static final String SQL_INSERT_PRODUCT = "insert into product (Type, MatCostSqF, LaborCostSqF) values (?,?,?)";
    private static final String SQL_DELETE_PRODUCT = "delete from product where id = ?";
    private static final String SQL_GET_PRODUCT = "select * from product where id = ?";
    private static final String SQL_GET_LIST = "select * from product";
    private static final String SQL_UPDATE_PRODUCT = "UPDATE product SET Type = ?, MatCostSqF = ?, LaborCostSqF = ?  WHERE id = ?";

    private JdbcTemplate jdbcTemplate;

    public ProductDaoDbImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Product create(Product product) {
        jdbcTemplate.update(SQL_INSERT_PRODUCT,
                product.getProductType(),
                product.getMatCostSqf(),
                product.getLaborCostSqf());

        Integer id = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);

        product.setId(id);

        return product;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Product get(int id) {
        return jdbcTemplate.queryForObject(SQL_GET_PRODUCT, new ProductMapper(), id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void update(Product product) {

        jdbcTemplate.update(SQL_UPDATE_PRODUCT,
                product.getProductType(),
                product.getMatCostSqf(),
                product.getLaborCostSqf(),
                product.getId());

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(Product product) {
        jdbcTemplate.update(SQL_DELETE_PRODUCT, product.getId());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Product> getProducts() {
        return jdbcTemplate.query(SQL_GET_LIST, new ProductMapper());
    }

    private static final class ProductMapper implements RowMapper<Product> {

        @Override
        public Product mapRow(ResultSet rs, int i) throws SQLException {

            Product product = new Product();

            product.setId(rs.getInt("id"));
            product.setProductType(rs.getString("Type"));
            product.setMatCostSqf(rs.getDouble("MatCostSqF"));
            product.setLaborCostSqf(rs.getDouble("LaborCostSqF"));

            return product;

        }

    }

}
