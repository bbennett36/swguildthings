/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.capstone.dao;

import com.mycompany.capstone.dto.Category;
import com.mycompany.capstone.dto.Comment;
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
public class CommentDaoDbImpl implements CommentDao {
    
    private static final String SQL_INSERT_COMMENT = "insert into comments (comment, comment_date, user_name, post_id) values (?,?,?,?)";
    private static final String SQL_LIST_COMMENTS = "select * from comments";

    private final JdbcTemplate jdbcTemplate;

    public CommentDaoDbImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Comment create(Comment comment) {
        
        jdbcTemplate.update(SQL_INSERT_COMMENT,
                comment.getComment(),
                comment.getCommentDate(),
                //comment.getUserId(),
                comment.getUserName(),
                comment.getBlogPostId());

        Integer id = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);

        comment.setId(id);

        return comment;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Comment get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void update(Comment comment) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(Comment comment) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Comment> listComments() {
        return jdbcTemplate.query(SQL_LIST_COMMENTS, new CommentMapper());
    }
    
     private static final class CommentMapper implements RowMapper<Comment> {

        @Override
        public Comment mapRow(ResultSet rs, int i) throws SQLException {

            Comment comment = new Comment();

            comment.setId(rs.getInt("id"));
            comment.setComment(rs.getString("comment"));
            comment.setCommentDate(rs.getDate("comment_date"));
            //comment.setUserId(rs.getInt("user_id"));
            comment.setUserName(rs.getString("user_name"));
            comment.setBlogPostId(rs.getInt("post_id"));

            return comment;

        }

    }

}
