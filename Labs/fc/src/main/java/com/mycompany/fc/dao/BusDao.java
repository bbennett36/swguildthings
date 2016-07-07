/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fc.dao;

import com.mycompany.fc.dto.Bus;
import com.mycompany.fc.dto.Trip;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface BusDao {

    public Bus create(Bus bus);
    
    public Bus update(Bus bus);
    
    public Bus get(int id);
    
    public void delete(Bus bus);
    
    public List<Bus> list();

}
