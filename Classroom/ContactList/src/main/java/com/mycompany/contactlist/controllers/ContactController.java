/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.contactlist.controllers;

import com.mycompany.contactlist.dao.ContactDao;
import com.mycompany.contactlist.dto.Contact;
import java.util.Map;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author apprentice
 */
@Controller
@RequestMapping(value = "/contact")
public class ContactController {

    private ContactDao contactDao;

    @Inject
    public ContactController(ContactDao dao) {
        this.contactDao = dao;
    }
    
   

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public Contact create(@RequestBody Contact contact) {
       
        
        return contactDao.add(contact);

    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String edit(@PathVariable("id") int id) {

        Contact contact = contactDao.get(id);

//        model.put("contact", contact);

        return "redirect:/";
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    @ResponseBody
    public Contact editContact(@Valid @RequestBody Contact contact) {

        contactDao.update(contact);
        
        return contact;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@Valid @PathVariable("id") Integer contactId) {
        Contact contact = contactDao.get(contactId);
        contactDao.remove(contact);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody 
    public Contact show(@PathVariable("id") Integer contactId)    {
        
        Contact contact = contactDao.get(contactId);
        
//        model.put("contact", contact);
        
        return contact;
        
    }


}
