/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdmvc.dao;

import com.mycompany.dvdmvc.dto.DVD;
import java.util.List;
import java.util.Map;

/**
 *
 * @author apprentice
 */
public interface DVDDao {

    public DVD create(DVD dvd);

    public DVD get(Integer id);

    public void update(DVD dvd);

    public void delete(DVD dvd);

    public List<DVD> getMPAA(String rating);

    public List<DVD> getStudio(String studio);

    public List<DVD> findDvdsInXYears(int x);

    public double findAvgAge();

    public DVD findOldest();

    public Map<String, List<DVD>> getDirector(String director);

    public DVD findNewest();
    
    public List<DVD> getDvds();

}
