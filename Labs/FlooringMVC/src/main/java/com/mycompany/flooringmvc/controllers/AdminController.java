/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmvc.controllers;

import com.mycompany.flooringmvc.dao.ProductDaoInterface;
import com.mycompany.flooringmvc.dao.TaxesInterface;
import com.mycompany.flooringmvc.dto.Order;
import com.mycompany.flooringmvc.dto.Product;
import com.mycompany.flooringmvc.dto.Tax;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
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
@RequestMapping(value = "/adminC")
public class AdminController {

    private ProductDaoInterface pdao;
    private TaxesInterface tdao;

    @Inject
    public AdminController(ProductDaoInterface pdao, TaxesInterface tdao) {
        this.pdao = pdao;
        this.tdao = tdao;
    }

    @RequestMapping("/admin")
    public String contactinfo() {

        return "admin";
    }

    @RequestMapping(value = "/editHome", method = RequestMethod.GET)
    public String entry(Map model) {

        List<Product> products = pdao.getProducts();
        List<Tax> taxes = tdao.getTaxes();
        model.put("products", products);
        model.put("taxes", taxes);
        return "edit";

    }

    @RequestMapping(value = "/i", method = RequestMethod.GET)
    public String home(Map model) {
        List<Product> products = pdao.getProducts();
        List<Tax> taxes = tdao.getTaxes();
        model.put("products", products);
        model.put("taxes", taxes);
        return "admin";

    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public Product createP(@Valid @RequestBody Product product) {

        pdao.create(product);

        return product;
    }

    @RequestMapping(value = "/t", method = RequestMethod.POST)
    @ResponseBody
    public Tax create(@Valid @RequestBody Tax tax) {

        tdao.create(tax);

        return tax;
    }

    @RequestMapping(value = "/t{id}", method = RequestMethod.GET)
    @ResponseBody
    public Tax show(@PathVariable("id") int id) {

        Tax tax = tdao.get(id);

        return tax;

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Product showP(@PathVariable("id") int id) {

        Product product = pdao.get(id);


        return product;

    }

    @RequestMapping(value = "/t{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable("id") int delete) {
        Tax tax = tdao.get(delete);
        tdao.delete(tax);

//        return "redirect:/";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteP(@PathVariable("id") int type) {
        Product product = pdao.get(type);
        pdao.delete(product);

//        return "redirect:/";
    }


}
