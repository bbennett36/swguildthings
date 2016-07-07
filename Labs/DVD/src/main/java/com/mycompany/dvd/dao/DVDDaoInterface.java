/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvd.dao;

import com.mycompany.dvd.dto.DVD;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author apprentice
 */
public interface DVDDaoInterface {
    
     public DVD create(DVD dvd);

    public DVD get(Integer id);

    public void update(DVD dvd);

    public void delete(DVD dvd);

    public DVD getMPAA(String rating);

    public DVD getStudio(String studio);

    public List<DVD> findDvdsInXYears(int x);

    public double findAvgAge();

    public DVD findOldest();

    public Map<String, List<DVD>> getDirector(String director);

    public DVD findNewest();
    
}
