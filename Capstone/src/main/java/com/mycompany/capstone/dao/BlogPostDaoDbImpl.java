/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.capstone.dao;

import com.mycompany.capstone.dto.AdminPage;
import com.mycompany.capstone.dto.BlogPost;
import com.mycompany.capstone.dto.Category;
import com.mycompany.capstone.dto.Hashtag;
import com.mycompany.capstone.dto.Image;
import com.mycompany.capstone.dto.User;
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
public class BlogPostDaoDbImpl implements BlogPostDao {

    private static final String SQL_CREATE_POST = "INSERT INTO posts "
            + "(title, body, category_id, status_id, start_date, expiration_date, author_id, creation_date) "
            + "VALUES(?,?, (SELECT id FROM categories WHERE category = ?), ?, ?, ?, ?, NOW())";

    private static final String SQL_CREATE_POST_HASHTAGS = "INSERT INTO posthashtags "
            + "(post_id, hashtag_id) "
            + "VALUES(?, ?)";

    private static final String SQL_UPDATE_POST = "UPDATE posts SET title = ?,body = ?,category_id = ?,status_id = ?, start_date = ?,"
            + "expiration_date = ?,author_id = ?,last_modified_by = ?,last_modified_date = ? WHERE id = ? ";

    private static final String SQL_UPDATE_PUBLISHED = "UPDATE posts "
            + "SET status_id = (SELECT id FROM statuscodes s WHERE s.status = ?) WHERE id = ?";
    private static final String SQL_UPDATE_ARCHIVED = "UPDATE posts "
            + "SET status_id = (SELECT id FROM statuscodes s WHERE s.status = ?) WHERE id = ?";

    private static final String SQL_DELETE_POST = "DELETE FROM posts WHERE id=? ";

    private static final String SQL_GET_POST_BY_ID = "SELECT A.*,CONCAT(B.first_name,' ',B.last_name) as author_name FROM posts A JOIN users B ON ( A.author_id=B.id) WHERE A.id=?";
    private static final String SQL_GET_ACTIVE_POST_BY_ID = "SELECT A.*,CONCAT(B.first_name,' ',B.last_name) as author_name FROM posts A JOIN users B ON ( A.author_id=B.id) WHERE A.id=? AND status_id=1";

    private static final String SQL_GET_PAGINATION_WITH_LIMIT = "SELECT A.*,CONCAT(B.first_name,' ',B.last_name) as author_name FROM posts A JOIN users B ON ( A.author_id=B.id)\n"
            + "WHERE status_id=1 LIMIT ?,3";

    private static final String SQL_ACTIVE_POST_COUNT = "SELECT COUNT(id) From posts WHERE status_id=1";

    private static final String SQL_GET_POST_BY_URL_SLUG = "SELECT A.*,CONCAT(B.first_name,' ',B.last_name) as author_name FROM posts A JOIN users B ON ( A.author_id=B.id) WHERE A.url_slug=? AND status_id=1";

    private static final String SQL_GET_POST_ID_BY_URL_SLUG = "SELECT * FROM posts WHERE url_slug=? AND status_id=1";
    private static final String SQL_GET_LIST_OF_POSTS = "SELECT A.*,CONCAT(B.first_name,' ',B.last_name) as author_name FROM posts A JOIN users B ON ( A.author_id=B.id) ORDER BY A.creation_date DESC";

    private static final String SQL_GET_ACTIVE_POSTS = "SELECT A.*,CONCAT(B.first_name,' ',B.last_name) as author_name FROM posts A JOIN users B ON ( A.author_id=B.id) WHERE A.status_id = 1 ORDER BY A.creation_date DESC";

    private final JdbcTemplate jdbcTemplate;
    private CategoryDao categoryDao;

    public BlogPostDaoDbImpl(JdbcTemplate jdbcTemplate, CategoryDao categoryDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.categoryDao = categoryDao;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public BlogPost create(BlogPost blogPost) {

        String category = blogPost.getCategory().getCategory();

        Integer authorId = null;
        if (blogPost.getAuthor().getId() != 0) {
            authorId = blogPost.getAuthor().getId();
        }

        jdbcTemplate.update(SQL_CREATE_POST,
                blogPost.getTitle(),
                //blogPost.getUrlSlug(),
                blogPost.getBody(),
                category,
                blogPost.getStatusId(),
                blogPost.getStartDate(),
                blogPost.getExpirationDate(),
                authorId                
        );

        Integer id = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);

        blogPost.setId(id);

        for (Hashtag hashtag : blogPost.getHashtagList()) {
            jdbcTemplate.update(SQL_CREATE_POST_HASHTAGS, id, hashtag.getId());
        }

        return blogPost;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public BlogPost get(int id) {
        return jdbcTemplate.queryForObject(SQL_GET_POST_BY_ID, new BlogPostMapper(), id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public BlogPost getByUrlSlug(String urlSlug) {
        return jdbcTemplate.queryForObject(SQL_GET_POST_BY_URL_SLUG, new BlogPostMapper(), urlSlug);
    }

    @Override
    public BlogPost getPostIdByUrlSlug(String urlSlug) {
        return jdbcTemplate.queryForObject(SQL_GET_POST_ID_BY_URL_SLUG, new BlogPostMapper(), urlSlug);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public BlogPost getActivePostById(int id) {
        return jdbcTemplate.queryForObject(SQL_GET_ACTIVE_POST_BY_ID, new BlogPostMapper(), id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void update(BlogPost blogPost) {

        Integer imageId = null;

        jdbcTemplate.update(SQL_UPDATE_POST,
                blogPost.getTitle(),
                //blogPost.getUrlSlug(),
                blogPost.getBody(),
                blogPost.getCategory().getId(),
                blogPost.getStatusId(),
                blogPost.getStartDate(),
                blogPost.getExpirationDate(),
                blogPost.getAuthor().getId(),
                blogPost.getLastModifiedBy(),
                blogPost.getLastModifiedDate(),
                blogPost.getId()
        );
    }

    @Override
    public void publish(BlogPost blogPost, String statusValue) {
        jdbcTemplate.update(SQL_UPDATE_PUBLISHED, statusValue, blogPost.getId());
    }

    @Override
    public void archive(BlogPost blogPost, String statusValue) {
        String test = statusValue;
        jdbcTemplate.update(SQL_UPDATE_ARCHIVED, statusValue, blogPost.getId());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(BlogPost blogPost) {
        jdbcTemplate.update(SQL_DELETE_POST, blogPost.getId());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<BlogPost> listPosts() {
        return jdbcTemplate.query(SQL_GET_LIST_OF_POSTS, new BlogPostMapper());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<BlogPost> listActivePosts() {
        return jdbcTemplate.query(SQL_GET_ACTIVE_POSTS, new BlogPostMapper());
    }

    @Override
    public Integer getNumOfPosts() {
        List<Integer> count = jdbcTemplate.query(SQL_ACTIVE_POST_COUNT, new CountMapper());
        int numOfPosts = count.get(0);
        return numOfPosts;
    }

    @Override
    public List<BlogPost> listBlogWithLimit(int offset) {
        return jdbcTemplate.query(SQL_GET_PAGINATION_WITH_LIMIT, new BlogPostMapper(), offset);
    }

    private final class BlogPostMapper implements RowMapper<BlogPost> {

        @Override
        public BlogPost mapRow(ResultSet rs, int i) throws SQLException {

            BlogPost bp = new BlogPost();
            bp.setId(rs.getInt("id"));
            bp.setTitle(rs.getString("title"));
            //bp.setUrlSlug(rs.getString("url_slug"));
            bp.setBody(rs.getString("body"));
            bp.setStartDate(rs.getDate("start_date"));
            bp.setExpirationDate(rs.getDate("expiration_date"));
            bp.setStatusId(rs.getInt("status_id"));
            bp.setCreationDate(rs.getDate("creation_date"));
            bp.setLastModifiedBy(rs.getInt("last_modified_by"));
            bp.setLastModifiedDate(rs.getDate("last_modified_date"));

            Category category = categoryDao.get(rs.getInt("category_id"));
            bp.setCategory(category);

            User user = new User();
            user.setId(rs.getInt("author_id"));
            user.setUsername(rs.getString("author_name"));
            bp.setAuthor(user);

            return bp;
        }

    }

    private static final class CountMapper implements RowMapper<Integer> {

        @Override
        public Integer mapRow(ResultSet rs, int i) throws SQLException {
            Integer count = rs.getInt(1);
            return count;
        }
    }

}
