/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdmvc.dao;

import com.mycompany.dvdmvc.dto.DVD;
import com.mycompany.dvdmvc.dto.Note;
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
public class NotesDaoDbImpl implements NotesDao {

    private static final String SQL_INSERT_NOTE = "insert into note (MovieId, Notes) values (?,?)";
    private static final String SQL_GET_NOTE = "select * from note where id = ?";
    private static final String SQL_DELETE_NOTE = "delete from note where id= ?";
    private static final String SQL_GET_ALL_NOTES = "select * from note";
    private static final String SQL_UPDATE_NOTE = "UPDATE note SET MovieId = ?, Notes = ? WHERE id = ?";

    private JdbcTemplate jdbcTemplate;

    public NotesDaoDbImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Note create(Note note) {
        jdbcTemplate.update(SQL_INSERT_NOTE,
                note.getMovieId(),
                note.getNote());

        Integer id = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);

        note.setId(id);

        return note;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Note get(Integer id) {
        return jdbcTemplate.queryForObject(SQL_GET_NOTE, new NoteMapper(), id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void update(Note note) {
        
        jdbcTemplate.update(SQL_UPDATE_NOTE,
                note.getMovieId(),
                note.getNote(),
                note.getId());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(Note note) {
        jdbcTemplate.update(SQL_DELETE_NOTE, note.getId());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Note> list() {
        return jdbcTemplate.query(SQL_GET_ALL_NOTES, new NoteMapper());
    }

    private static final class NoteMapper implements RowMapper<Note> {

        @Override
        public Note mapRow(ResultSet rs, int i) throws SQLException {

            Note note = new Note();

            note.setId(rs.getInt("id"));
            note.setMovieId(rs.getInt("MovieId"));
            note.setNote(rs.getString("Notes"));

            return note;

        }

    }
}
