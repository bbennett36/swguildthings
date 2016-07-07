/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.capstone.dao;

import com.mycompany.capstone.dto.AdminPage;
import com.mycompany.capstone.dto.Category;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author apprentice
 */
public class AdminPageDaoDbImpl implements AdminPageDao {
    
    private StatusValueDao statusValueDao;
    private UserDao userDao;

    private static final String SQL_INSERT_ADMIN_PAGE = "insert into adminpages (page_name,url_slug, page_body, sequence, status_id, author_id, creation_date) values (?,?,?,?,?,?,NOW())";
    private static final String SQL_DELETE_ADMIN_PAGE = "delete from adminpages where id = ?";
    private static final String SQL_GET_ADMIN_PAGES = "select * from adminpages WHERE status_id=1 ORDER BY sequence ASC";
    private static final String SQL_GET_ALL_ADMIN_PAGES = "select * from adminpages ORDER BY sequence ASC";
    private static final String SQL_GET_PAGE = "select * from adminpages where id = ?";
    private static final String SQL_GET_PAGE_BY_URL_SLUG = "select * from adminpages where url_slug=? AND status_id=1";
    private static final String SQL_GET_NEXT_SEQUENCE = "SELECT MAX(sequence) FROM adminpages WHERE status_id = 1";
    private static final String SQL_UPDATE_ADMIN_PAGE = "UPDATE adminpages SET page_name=?,url_slug=?, page_body=?, sequence=?, status_id=?, author_id=?,last_modified_by=?,"
            + "last_modified_date=NOW() WHERE id=?";
    private static final String SQL_UPDATE_SEQUENCE = "UPDATE adminpages SET sequence = ? WHERE id = ?";
    
    private final JdbcTemplate jdbcTemplate;
    
    public AdminPageDaoDbImpl(StatusValueDao statusValueDao,UserDao userDao,JdbcTemplate jdbcTemplate) {
        this.statusValueDao=statusValueDao;
        this.userDao=userDao;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public AdminPage create(AdminPage adminPage) {

        jdbcTemplate.update(SQL_INSERT_ADMIN_PAGE,
                adminPage.getPageName(),
                adminPage.getUrlSlug(),
                adminPage.getPageBody(),
                adminPage.getSequence(),
                adminPage.getStatus().getId(),
                adminPage.getAuthor().getId()
                );

        Integer id = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);

        adminPage.setId(id);

        return adminPage;

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public AdminPage get(int id) {
        return jdbcTemplate.queryForObject(SQL_GET_PAGE, new AdminPagesMapper(), id);
    }
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public AdminPage getByUrlSlug(String urlSlug) {
        try{
       return jdbcTemplate.queryForObject(SQL_GET_PAGE_BY_URL_SLUG, new AdminPagesMapper(), urlSlug);
        }catch(EmptyResultDataAccessException e){
            return null;
    
        }
    }

        
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void update(AdminPage adminPage) {
        jdbcTemplate.update(SQL_UPDATE_ADMIN_PAGE,
                adminPage.getPageName(),
                adminPage.getUrlSlug(),
                adminPage.getPageBody(),
                adminPage.getSequence(),
                adminPage.getStatus().getId(),
                adminPage.getAuthor().getId(),
                adminPage.getAuthor().getId(),
                adminPage.getId());
    }
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateSequence(AdminPage adminPage) {
        jdbcTemplate.update(SQL_UPDATE_SEQUENCE, adminPage.getSequence(), adminPage.getId());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(AdminPage adminPage) {

        jdbcTemplate.update(SQL_DELETE_ADMIN_PAGE, adminPage.getId());

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<AdminPage> listAdminPages() {
        return jdbcTemplate.query(SQL_GET_ADMIN_PAGES, new AdminPagesMapper());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<AdminPage> listAllAdminPages() {
       return jdbcTemplate.query(SQL_GET_ALL_ADMIN_PAGES, new AdminPagesMapper());
    }

    @Override
    public Integer getNextPageSequence() {
        int nextSequence = 0;
        nextSequence = jdbcTemplate.queryForObject(SQL_GET_NEXT_SEQUENCE, Integer.class) + 1;
        return nextSequence;
    }

    private  final class AdminPagesMapper implements RowMapper<AdminPage> {

        @Override
        public AdminPage mapRow(ResultSet rs, int i) throws SQLException {

            AdminPage ap = new AdminPage();

            ap.setId(rs.getInt("id"));
            ap.setPageName(rs.getString("page_name"));
            ap.setPageBody(rs.getString("page_body"));
            ap.setSequence(rs.getInt("sequence"));
            ap.setStatus(statusValueDao.get(rs.getInt("status_id")));
            ap.setAuthor(userDao.get(rs.getInt("author_id")));
            ap.setCreationDate(rs.getDate("creation_date"));
            ap.setLastModifiedBy(rs.getInt("last_modified_by"));
            ap.setLastModifiedDate(rs.getDate("last_modified_date"));
            ap.setUrlSlug(rs.getString("url_slug"));

            return ap;

        }

    }

}
