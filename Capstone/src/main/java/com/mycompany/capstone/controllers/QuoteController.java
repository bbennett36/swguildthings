/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.capstone.controllers;

import com.mycompany.capstone.dao.QuoteDao;
import com.mycompany.capstone.dto.Quote;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author apprentice
 */
@Controller
@RequestMapping(value = "/quote")
public class QuoteController {

    private QuoteDao quoteDao;

    @Inject
    public QuoteController(QuoteDao quoteDao)   {
        this.quoteDao = quoteDao;
    }
    
    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public Quote createQuote(@RequestBody Quote quote) {
        return quoteDao.create(quote);
    }

}
