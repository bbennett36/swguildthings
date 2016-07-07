/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmvc.dao;

import com.mycompany.flooringmvc.dto.Tax;
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
public class TaxesDaoDbImpl implements TaxesInterface {
    
    private static final String SQL_INSERT_TAX = "insert into Taxes (StateName, TaxRate) values (?,?)";
    private static final String SQL_GET_TAX = "select * from Taxes where id = ?";
    private static final String SQL_DELETE_TAX = "delete from Taxes where id = ?";
    private static final String SQL_UPDATE_TAX = "UPDATE Taxes SET StateName = ?, TaxRate = ? WHERE id = ?";
    private static final String SQL_GET_TAX_RATES = "select * from Taxes";
    private static final String SQL_GET_TAX_STATE = "select * from Taxes where StateName = ?";

    
    private JdbcTemplate jdbcTemplate;

    public TaxesDaoDbImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Tax create(Tax tax) {
        
        jdbcTemplate.update(SQL_INSERT_TAX,
                tax.getState(),
                tax.getTaxRate());

        Integer id = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);

        tax.setId(id);

        return tax;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Tax get(int id) {
        return jdbcTemplate.queryForObject(SQL_GET_TAX, new TaxMapper(), id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public double getTax(String state) {
        Tax tax = jdbcTemplate.queryForObject(SQL_GET_TAX_STATE, new TaxMapper(), state);
        double rate = tax.getTaxRate();
        return rate;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void update(Tax tax) {
        jdbcTemplate.update(SQL_UPDATE_TAX,
                tax.getState(),
                tax.getTaxRate(),
                tax.getId());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(Tax tax) {
        jdbcTemplate.update(SQL_DELETE_TAX, tax.getId());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Tax> getTaxes() {
        return jdbcTemplate.query(SQL_GET_TAX_RATES, new TaxMapper());
    }
    
    private static final class TaxMapper implements RowMapper<Tax> {

        @Override
        public Tax mapRow(ResultSet rs, int i) throws SQLException {

            Tax tax = new Tax();

            tax.setId(rs.getInt("id"));
            tax.setState(rs.getString("StateName"));
            tax.setTaxRate(rs.getDouble("TaxRate"));

            return tax;

        }

    }

}
