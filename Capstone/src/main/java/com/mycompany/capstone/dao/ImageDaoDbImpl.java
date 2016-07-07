/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.capstone.dao;

import com.mycompany.capstone.dto.AdminPage;
import com.mycompany.capstone.dto.Image;
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
public class ImageDaoDbImpl implements ImageDao {


    private JdbcTemplate jdbcTemplate;
    private static final String SQL_INSERT_IMAGE_IN_STATIC_PAGE ="INSERT INTO images(image_data, path) values(?,?)";
    private static final String SQL_UPDATE_IMAGE_IN_STATIC_PAGE="UPDATE images SET image_data=?, path=? WHERE id=? ";
    private static final String SQL_DELETE_IMAGE_IN_STATIC_PAGE = "DELETE FROM  images where id = ?";
    private static final String SQL_GET_ALL_IMAGES_IN_STATIC_PAGE= "SELECT * FROM images";
    private static final String SQL_GET_IMAGE_IN_STATIC_PAGE_BY_ID ="SELECT * FROM images WHERE id=?";
    
    

    public ImageDaoDbImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Image create(Image adminPageImage) {
        jdbcTemplate.update(SQL_INSERT_IMAGE_IN_STATIC_PAGE,
                
                adminPageImage.getImageData(),
                adminPageImage.getImagePath()
                );

        Integer id = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);

        adminPageImage.setId(id);

        return adminPageImage;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Image get(int id) {
         return jdbcTemplate.queryForObject(SQL_GET_IMAGE_IN_STATIC_PAGE_BY_ID, new AdminPagesImageMapper(), id);
    }

    @Override
    public void update(Image adminPageImage) {
       jdbcTemplate.update(SQL_UPDATE_IMAGE_IN_STATIC_PAGE,
               adminPageImage.getImageData(),
               adminPageImage.getImagePath(),
               adminPageImage.getId());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(Image adminPageImage) {
         jdbcTemplate.update(SQL_DELETE_IMAGE_IN_STATIC_PAGE, adminPageImage.getId());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Image> listImages() {
        return jdbcTemplate.query(SQL_GET_ALL_IMAGES_IN_STATIC_PAGE, new AdminPagesImageMapper());
    }

    private final class AdminPagesImageMapper implements RowMapper<Image> {

        @Override
        @Transactional(propagation = Propagation.REQUIRED)
        public Image mapRow(ResultSet rs, int i) throws SQLException {


            Image adminPageImage = new Image();
            adminPageImage.setId(rs.getInt("id"));
            adminPageImage.setImageData(rs.getBytes("image_data"));
            adminPageImage.setImagePath(rs.getString("path"));
            return adminPageImage;


        }

    }

}
