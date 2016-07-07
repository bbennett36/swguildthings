/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmvc.controllers;

import com.mycompany.flooringmvc.dao.AuditDaoInterface;
import com.mycompany.flooringmvc.dao.OrderDaoInterface;
import com.mycompany.flooringmvc.dao.ProductDaoInterface;
import com.mycompany.flooringmvc.dao.TaxesInterface;
import com.mycompany.flooringmvc.dto.Audit;
import com.mycompany.flooringmvc.dto.Order;
import com.mycompany.flooringmvc.dto.Product;
import com.mycompany.flooringmvc.dto.Tax;
import java.text.DecimalFormat;
import java.util.ArrayList;
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

    private OrderDaoInterface dao;
    private ProductDaoInterface pdao;
    private TaxesInterface tdao;
    private AuditDaoInterface adao;

    @Inject
    public HomeController(OrderDaoInterface dao, ProductDaoInterface pdao, TaxesInterface tdao, AuditDaoInterface adao) {
        this.dao = dao;
        this.pdao = pdao;
        this.tdao = tdao;
        this.adao = adao;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Map model) {
        List<Order> orders = dao.getOrders();
        List<Product> products = pdao.getProducts();
        List<Tax> taxes = tdao.getTaxes();
        List<Audit> audits = adao.getAudits();
        model.put("orders", orders);
        model.put("products", products);
        model.put("taxes", taxes);
        model.put("tax", new Tax());
        model.put("product", new Product());

        model.put("audits", audits);

        return "home";
    }

}
