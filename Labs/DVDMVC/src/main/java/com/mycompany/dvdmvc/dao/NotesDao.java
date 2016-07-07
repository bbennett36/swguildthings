/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdmvc.dao;

import com.mycompany.dvdmvc.dto.DVD;
import com.mycompany.dvdmvc.dto.Note;
import java.util.List;
import java.util.Map;

/**
 *
 * @author apprentice
 */
public interface NotesDao {
    
    public Note create(Note note);

    public Note get(Integer id);

    public void update(Note note);

    public void delete(Note note);

    public List<Note> list();

    
}
