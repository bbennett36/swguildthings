/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmvc.dao;

import com.mycompany.flooringmvc.dto.Order;
import com.mycompany.flooringmvc.dto.Product;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author apprentice
 */
public class OrderDaoDbImpl implements OrderDaoInterface {

    private static final String SQL_INSERT_ORDER = "insert into orders (Name, Date, Area, product_id, state_id, Total) values (?,?,?,?,?,?)";
    private static final String SQL_DELETE_ORDER = "delete from orders where id = ?";
    private static final String SQL_GET_ORDER = "select * from orders where id = ?";
    private static final String SQL_GET_LIST = "select * from orders";
    private static final String SQL_UPDATE_ORDER = "UPDATE orders SET Name = ?, Date = ?, Area = ?, product_id = ?, state_id = ?, Total = ? WHERE id = ?";

    private JdbcTemplate jdbc;

    public OrderDaoDbImpl(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Order create(Order order) {

        jdbc.update(SQL_INSERT_ORDER,
                order.getName(),
                order.getDate(),
                order.getArea(),
                order.getProductId(),
                order.getStateId(),
                order.getTotal());

        Integer id = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);

        order.setId(id);

        return order;

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Order get(Integer id) {
        return jdbc.queryForObject(SQL_GET_ORDER, new OrderMapper(), id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Order getDate(String date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void update(Order order) {
        jdbc.update(SQL_UPDATE_ORDER,
                order.getName(),
                order.getDate(),
                order.getArea(),
                order.getProductId(),
                order.getStateId(),
                order.getTotal(),
                order.getId());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(Order order) {
        jdbc.update(SQL_DELETE_ORDER, order.getId());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Order> getOrders() {
        return jdbc.query(SQL_GET_LIST, new OrderMapper());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Map<String, List<Order>> getGroupOrders() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static final class OrderMapper implements RowMapper<Order> {

        @Override
        public Order mapRow(ResultSet rs, int i) throws SQLException {

            Order order = new Order();

            order.setId(rs.getInt("id"));
            order.setName(rs.getString("Name"));
            order.setDate(rs.getDate("Date"));
            order.setArea(rs.getDouble("Area"));
            order.setProductId(rs.getInt("product_id"));
            order.setStateId(rs.getInt("state_id"));
            order.setTotal(rs.getDouble("Total"));

            return order;

        }

    }

}
