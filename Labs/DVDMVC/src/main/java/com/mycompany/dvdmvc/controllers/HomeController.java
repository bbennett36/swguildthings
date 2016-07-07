/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdmvc.controllers;

import com.mycompany.dvdmvc.dao.DVDDao;
import com.mycompany.dvdmvc.dto.DVD;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author apprentice
 */
@Controller
public class HomeController {

    private DVDDao dao;

    @Inject
    public HomeController(DVDDao dao) {
        this.dao = dao;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Map model) {
        List<DVD> dvds = dao.getDvds();
        model.put("dvds", dvds);
        model.put("DVD", new DVD());

        return "home";
    }

}
