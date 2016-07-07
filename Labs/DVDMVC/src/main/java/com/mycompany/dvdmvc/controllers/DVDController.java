/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdmvc.controllers;

import com.mycompany.dvdmvc.dao.DVDDao;
import com.mycompany.dvdmvc.dto.DVD;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
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

/**
 *
 * @author apprentice
 */
@Controller
@RequestMapping(value = "/dvd")
public class DVDController {

    private DVDDao dao;

    @Inject
    public DVDController(DVDDao dao) {
        this.dao = dao;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public DVD create(@Valid @RequestBody DVD dvd) {

       
        return dao.create(dvd);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@Valid @PathVariable("id") Integer dvdId) {
        DVD dvd = dao.get(dvdId);
        dao.delete(dvd);

    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String edit(@PathVariable("id") int id) {

        DVD dvd = dao.get(id);

//        model.put("dvd", dvd);

        return "redirect:/";
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    @ResponseBody
    public DVD edit(@Valid @RequestBody DVD dvd) {

        dao.update(dvd);
        
        return dvd;

//        return "redirect:/";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public DVD show(@PathVariable("id") Integer dvdId) {

        DVD dvd = dao.get(dvdId);

//        Date date = dvd.getReleaseDate();
//        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
//        String reportDate = df.format(date);
//        model.put("reportDate", reportDate);
//
//        model.put("dvd", dvd);
//
//        boolean showTable = true;
//        model.put("showTable", showTable);
//        boolean showSearch = true;
//        model.put("showSearch", showSearch);

        return dvd;

    }

    @RequestMapping("/searchMPAA")
    public String byLastName(@RequestParam("searchMPAA") String search, Map model) {

        List<DVD> found = dao.getMPAA(search);

        boolean showTable = true;
        model.put("showTable", showTable);
        model.put("found", found);

        return "show";

    }

    @RequestMapping("/searchStudio")
    public String byCity(@RequestParam("searchStudio") String search, Map model) {

        List<DVD> found = dao.getStudio(search);

        boolean showTable = true;
        model.put("showTable", showTable);
        model.put("found", found);

        return "show";

    }

    @RequestMapping("/searchYears")
    public String findDvdsInYears(@RequestParam("searchYears") String years, Map model) {

        int search = Integer.parseInt(years);
        List<DVD> found = dao.findDvdsInXYears(search);

        boolean showTable = true;
        model.put("showTable", showTable);
        model.put("found", found);

        return "show";
    }

    @RequestMapping("/searchAvg")
    public String findAvgAge(Map model) {

        double getAge = dao.findAvgAge();

        DecimalFormat df = new DecimalFormat("");
        String age = (df.format(getAge) + " years");
        boolean avg = true;
        model.put("age", age);
        model.put("avg", avg);

        return "show";

    }

    @RequestMapping("/searchNew")
    public String newest(Map model) {

        DVD dvd = dao.findNewest();

        Date date = dvd.getReleaseDate();
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        String reportDate = df.format(date);
        model.put("reportDate", reportDate);

        boolean showTable = true;
        model.put("showTable", showTable);
        model.put("dvd", dvd);
        boolean showSearch = true;
        model.put("showSearch", showSearch);

        return "show";

    }

    @RequestMapping("/searchOld")
    public String oldest(Map model) {

        DVD dvd = dao.findOldest();

        Date date = dvd.getReleaseDate();
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        String reportDate = df.format(date);
        model.put("reportDate", reportDate);

        boolean showTable = true;
        model.put("showTable", showTable);
        model.put("dvd", dvd);
        boolean showSearch = true;
        model.put("showSearch", showSearch);

        return "show";

    }
}
