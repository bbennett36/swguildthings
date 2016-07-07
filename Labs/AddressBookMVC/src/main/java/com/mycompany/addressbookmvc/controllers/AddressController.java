/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.addressbookmvc.controllers;

import com.mycompany.addressbookmvc.dao.AddressBookDao;
import com.mycompany.addressbookmvc.dto.Address;
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
@RequestMapping(value = "/address")
public class AddressController {

    private AddressBookDao dao;

    @Inject
    public AddressController(AddressBookDao dao) {
        this.dao = dao;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public Address create(@Valid @RequestBody Address address) {

        return dao.create(address);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@Valid @PathVariable("id") Integer addressId) {
        Address address = dao.get(addressId);
        dao.delete(address);

//        return "redirect:/";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable("id") int id) {

        Address address = dao.get(id);


        return "redirect:/";
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    @ResponseBody
    public Address editAddress(@Valid @RequestBody Address address) {

        dao.update(address);

        return address;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Address show(@PathVariable("id") Integer addressId) {

        Address address = dao.get(addressId);


//        boolean showSearch = true;
//        model.put("showSearch", showSearch);

        return address;

    }

    @RequestMapping("/search")
    public String byLastName(@RequestParam("searchName") String search, Map model) {

        List<Address> found = dao.searchByLastName(search);

        model.put("found", found);

        return "show";

    }

    @RequestMapping("/searchCity")
    public String byCity(@RequestParam("searchCity") String search, Map model) {

        List<Address> found = dao.searchByCity(search);

        model.put("found", found);

        return "show";

    }

    @RequestMapping("/searchZip")
    public String byZip(@RequestParam("searchZip") String search, Map model) {

        List<Address> found = dao.searchByZip(search);

        model.put("found", found);

        return "show";

    }

    @RequestMapping("/searchState")
    public String byState(@RequestParam("searchState") String search, Map model) {

        List<Address> found = dao.searchByState(search);

        model.put("found", found);

        return "show";

    }
}
