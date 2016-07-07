/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.dto.Checking;
import com.mycompany.dto.Savings;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class CheckingDao {
    
    List<Checking> cAccounts = new ArrayList();
    
    public Checking create(Checking checking)    {
        
        cAccounts.add(checking);
        
        return checking;
        
    }
    
    public Checking get(Integer pin) {
        
        for(Checking c : cAccounts)   {
            if(c.getPin() == pin)   {
                return c;
            }
        }
        return null;
    }
    
    public void update(Checking checking)  {
        
        Checking found = null;
        
        for(Checking c : cAccounts)    {
            if(c.getPin() == checking.getPin())   {
                found = c;
            }
        }
        
        cAccounts.remove(found);
        cAccounts.add(found);
        
    }
    
    public void delete(Checking checking)    {
        
        for(Checking c : cAccounts)  {
            if(c.getPin() == checking.getPin())   {
                cAccounts.remove(c);
            }
        }
        
    }
    
}
