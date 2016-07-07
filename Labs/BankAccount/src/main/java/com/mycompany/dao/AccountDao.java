/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.dto.Account;
import com.mycompany.dto.Checking;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class AccountDao {
    
    
     List<Account> accounts = new ArrayList();
    
    public Account create(Account account)    {
        
        accounts.add(account);
        
        return account;
        
    }
    
    public Account get(Integer pin) {
        
        for(Account a : accounts)   {
            if(a.getPin() == pin)   {
                return a;
            }
        }
        return null;
    }
    
    public void update(Account account)  {
        
        Account found = null;
        
        for(Account a : accounts)    {
            if(a.getPin() == account.getPin())   {
                found = a;
            }
        }
        
        accounts.remove(found);
        accounts.add(found);
        
    }
    
    public void delete(Account account)    {
        
        for(Account a : accounts)  {
            if(a.getPin() == account.getPin())   {
                accounts.remove(a);
            }
        }
        
    }

    public List<Account> getAccounts() {
        return accounts;
    }
    
}
