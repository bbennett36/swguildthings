/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.capstone.dao;

import com.mycompany.capstone.dto.StatusValue;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface StatusValueDao {
    
    public StatusValue create(StatusValue statusValue);
    public StatusValue get(int id);
    public void update(StatusValue statusValue);
    public void delete(StatusValue statusValue);
    public List<StatusValue> listStatusValues();
    
}
