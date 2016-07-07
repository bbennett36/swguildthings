/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.contactlist.dao;

import com.mycompany.contactlist.dto.Contact;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class ContactDaoImpl implements ContactDao {
    
    List<Contact> data = new ArrayList();
    
    private int nextId = 1;
    

    @Override
    public Contact add(Contact contact) {
        
        contact.setId(nextId++);
        data.add(contact);
        
        return contact;
    }

    @Override
    public void update(Contact contact) {        
      
        data.removeIf(a -> a.getId() == contact.getId());
        data.add(contact);
        
    }

    @Override
    public void remove(Contact contact) {
        data.removeIf(a -> a.getId() == contact.getId());
    }

    @Override
    public Contact get(Integer id) {
        return data.get(0);
    }

    @Override
    public List<Contact> list() {
        return new ArrayList(data);
    }
    
}
