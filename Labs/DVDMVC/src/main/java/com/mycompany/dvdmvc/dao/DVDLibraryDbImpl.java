/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdmvc.dao;

import com.mycompany.dvdmvc.dto.DVD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
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
public class DVDLibraryDbImpl implements DVDDao {

    private static final String SQL_INSERT_DVD = "insert into dvd (Title, MPAARating, Studio, DirectorsName, ReleaseDate) values (?,?,?,?,?)";
    private static final String SQL_UPDATE_DVD = "UPDATE dvd SET Title = ?, MPAARating = ?, Studio = ?, DirectorsName=?, ReleaseDate=? WHERE id = ?";
    private static final String SQL_GET_DVD = "Select * from dvd where id = ?";
    private static final String SQL_DELETE_DVD = "delete from dvd where id = ?";
    private static final String SQL_SEARCH_MPAA = "select * from dvd where MPAARating = ?";
    private static final String SQL_SEARCH_STUDIO = "select * from dvd where Studio = ?";
    private static final String SQL_FIND_DVDS_IN_X_YEARS = "select * from dvd where ReleaseDate >= DATE_SUB(NOW(),INTERVAL ? YEAR)";
    private static final String SQL_FIND_OLDEST = "SELECT * FROM dvd ORDER BY ReleaseDate ASC LIMIT 1";
    private static final String SQL_FIND_NEWEST = "SELECT * FROM dvd ORDER BY ReleaseDate DESC LIMIT 1";
    private static final String SQL_GET_DVDS = "select * from dvd";
    private static final String SQL_GET_AVG = "SELECT FROM_UNIXTIME(AVG(UNIX_TIMESTAMP(ReleaseDate))) FROM dvd";

    private JdbcTemplate jdbcTemplate;

    public DVDLibraryDbImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public DVD create(DVD dvd) {

        jdbcTemplate.update(SQL_INSERT_DVD,
                dvd.getTitle(),
                dvd.getmPAA(),
                dvd.getStudio(),
                dvd.getDirectorsName(),
                dvd.getReleaseDate());

        Integer id = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);

        dvd.setId(id);

        return dvd;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public DVD get(Integer id) {
        return jdbcTemplate.queryForObject(SQL_GET_DVD, new DVDMapper(), id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void update(DVD dvd) {

        jdbcTemplate.update(SQL_UPDATE_DVD,
                dvd.getTitle(),
                dvd.getmPAA(),
                dvd.getStudio(),
                dvd.getDirectorsName(),
                dvd.getReleaseDate(),
                dvd.getId());

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(DVD dvd) {
        jdbcTemplate.update(SQL_DELETE_DVD, dvd.getId());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<DVD> getMPAA(String rating) {
        return jdbcTemplate.query(SQL_SEARCH_MPAA, new DVDMapper(), rating);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<DVD> getStudio(String studio) {
        return jdbcTemplate.query(SQL_SEARCH_STUDIO, new DVDMapper(), studio);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<DVD> findDvdsInXYears(int x) {
        return jdbcTemplate.query(SQL_FIND_DVDS_IN_X_YEARS, new DVDMapper(), x);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public double findAvgAge() {
//        Date date = jdbcTemplate.queryForObject(SQL_GET_AVG, new DVDMapper());
        Timestamp avgDate = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Timestamp.class);

        Date todayIs = new Date();
        
        double days = 2.2;
        return days;

//        Calendar cal = Calendar.getInstance();
//        cal.setTime(avgDate);
//
//        Calendar today = Calendar.getInstance();
//        today.setTime(todayIs);
//        int curYear = today.get(Calendar.YEAR);
//        int curMonth = today.get(Calendar.MONTH);
//        int curDay = today.get(Calendar.DAY_OF_MONTH);
//
//        int year = cal.get(Calendar.YEAR);
//        int month = cal.get(Calendar.MONTH);
//        int day = cal.get(Calendar.DAY_OF_MONTH);

    }
    

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public DVD findOldest() {
        return jdbcTemplate.queryForObject(SQL_FIND_OLDEST, new DVDMapper());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Map<String, List<DVD>> getDirector(String director) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public DVD findNewest() {
        return jdbcTemplate.queryForObject(SQL_FIND_NEWEST, new DVDMapper());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<DVD> getDvds() {
        return jdbcTemplate.query(SQL_GET_DVDS, new DVDMapper());
    }

    private static final class DVDMapper implements RowMapper<DVD> {

        @Override
        public DVD mapRow(ResultSet rs, int i) throws SQLException {

            DVD dvd = new DVD();

            dvd.setId(rs.getInt("id"));
            dvd.setTitle(rs.getString("Title"));
            dvd.setmPAA(rs.getString("MPAARating"));
            dvd.setStudio(rs.getString("Studio"));
            dvd.setTitle(rs.getString("Title"));
            dvd.setReleaseDate(rs.getDate("ReleaseDate"));

            return dvd;

        }

    }

}
