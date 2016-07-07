/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.dto.Savings;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class SavingDao {
    
    List<Savings> sAccounts = new ArrayList();
    
    public Savings create(Savings saving)    {
        
        sAccounts.add(saving);
        
        return saving;
        
    }
    
    public Savings get(Integer pin) {
        
        for(Savings s : sAccounts)   {
            if(s.getPin() == pin)   {
                return s;
            }
        }
        return null;
    }
    
    public void update(Savings saving)  {
        
        Savings found = null;
        
        for(Savings s : sAccounts)    {
            if(s.getPin() == saving.getPin())   {
                found = s;
            }
        }
        
        sAccounts.remove(found);
        sAccounts.add(found);
        
    }
    
    public void delete(Savings saving)    {
        
        for(Savings s : sAccounts)  {
            if(s.getPin() == saving.getPin())   {
                sAccounts.remove(s);
            }
        }
        
    }
    
    
    
}
