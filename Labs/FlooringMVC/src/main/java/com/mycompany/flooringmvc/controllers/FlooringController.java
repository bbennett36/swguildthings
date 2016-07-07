/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmvc.controllers;

import com.mycompany.flooringmvc.dao.OrderDaoInterface;
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
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author apprentice
 */
@Controller
@RequestMapping(value = "/order")
public class FlooringController {

    private OrderDaoInterface dao;
    private ProductDaoInterface pdao;
    private TaxesInterface tdao;

    @Inject
    public FlooringController(OrderDaoInterface dao, ProductDaoInterface pdao, TaxesInterface tdao) {
        this.dao = dao;
        this.pdao = pdao;
        this.tdao = tdao;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public Order create(@Valid @RequestBody Order order) {
         List<Product> products = pdao.getProducts();
         List<Tax> states = tdao.getTaxes();
        

        String state = order.getState();
        state = state.toUpperCase();

        double tax = tdao.getTax(state);
        String type = order.getProduct();

        double results[] = getCosts(type);

        double area = order.getArea();
        double mcs = results[0];
        double lcs = results[1];
        double lc = Math.ceil(lcs * area);
        double mc = Math.ceil(mcs * area);
        double pretotal = Math.ceil(lc + mc);
        double ttax = tax / 100;
        double taxtotal = pretotal * ttax;
        double total = pretotal + taxtotal;

        order.setLaborCost(lc);
        order.setLaborCostSqf(lcs);
        order.setMatCostSqf(mcs);
        order.setMaterialCost(mc);
        order.setTax(tax);
        order.setTaxTotal(taxtotal);
        order.setTotal(total);
        for(Product p : products)   {
            if(order.getProduct().equals(type))     {
                order.setProductId(p.getId());
            }
        }
        for(Tax t : states) {
            if(order.getState().equals(state))  {
                order.setStateId(t.getId());
            }
        }



        return dao.create(order);

    }

    public double[] getCosts(String type) {
        List<Product> produtcs = pdao.getProducts();

        double mcs = 0;
        double lcs = 0;

        for (Product myProduct : produtcs) {
            if (type.equals(myProduct.getProductType())) {
                mcs = myProduct.getMatCostSqf();
                lcs = myProduct.getLaborCostSqf();
            }
        }

        return new double[]{mcs, lcs};

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@Valid @PathVariable("id") Integer orderId) {
        Order order = dao.get(orderId);
        dao.delete(order);

    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String edit(@PathVariable("id") int id) {

        Order order = dao.get(id);

//        model.put("order", order);
//
//        List<Product> products = pdao.getProducts();
//        List<Tax> taxes = tdao.getTaxes();
//        model.put("products", products);
//        model.put("taxes", taxes);
//        boolean editOrder = true;
//        model.put("editOrder", editOrder);
        return "redirect:/";
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    @ResponseBody
    public Order editContact(@Valid @RequestBody Order order) {

         List<Product> products = pdao.getProducts();
         List<Tax> states = tdao.getTaxes();
        

        String state = order.getState();
        state = state.toUpperCase();

        double tax = tdao.getTax(state);
        String type = order.getProduct();

        double results[] = getCosts(type);

        double area = order.getArea();
        double mcs = results[0];
        double lcs = results[1];
        double lc = Math.ceil(lcs * area);
        double mc = Math.ceil(mcs * area);
        double pretotal = Math.ceil(lc + mc);
        double ttax = tax / 100;
        double taxtotal = pretotal * ttax;
        double total = pretotal + taxtotal;

        order.setLaborCost(lc);
        order.setLaborCostSqf(lcs);
        order.setMatCostSqf(mcs);
        order.setMaterialCost(mc);
        order.setTax(tax);
        order.setTaxTotal(taxtotal);
        order.setTotal(total);
        for(Product p : products)   {
            if(order.getProduct().equals(type))     {
                order.setProductId(p.getId());
            }
        }
        for(Tax t : states) {
            if(order.getState().equals(state))  {
                order.setStateId(t.getId());
            }
        }

        dao.update(order);

        return order;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Order show(@PathVariable("id") Integer orderId) {

        Order order = dao.get(orderId);
         List<Product> products = pdao.getProducts();
         List<Tax> states = tdao.getTaxes();
         for(Product p : products)  {
             if(order.getProductId() == p.getId())   {
                 order.setLaborCost(p.getLaborCostSqf());
                 order.setMaterialCost(p.getMatCostSqf());
                 order.setProduct(p.getProductType());
             }
         }
         for(Tax t : states) {
             if(order.getStateId() == t.getId())    {
                 order.setState(t.getState());
                 order.setTax(t.getTaxRate());
             }
         }
         
        double results[] = getCosts(order.getProduct());

        double mcs = results[0];
        double lcs = results[1];
        double lc = Math.ceil(lcs * order.getArea());
        double mc = Math.ceil(mcs * order.getArea());
        double pretotal = Math.ceil(lc + mc);
        double ttax = order.getTax() / 100;
        double taxtotal = pretotal * ttax;
        double total = pretotal + taxtotal;

        order.setLaborCost(lc);
        order.setLaborCostSqf(lcs);
        order.setMatCostSqf(mcs);
        order.setMaterialCost(mc);
        order.setTaxTotal(taxtotal);
        order.setTotal(total);
        

        return order;

    }

    @RequestMapping(value = "/edit/p{id}", method = RequestMethod.GET)
    @ResponseBody
    public String editSend(@PathVariable("id") int id) {

        Product product = pdao.get(id);

        return "redirect:/";
    }

    @RequestMapping(value = "/p", method = RequestMethod.PUT)
    @ResponseBody
    public Product editP(@Valid @RequestBody Product product) {

        pdao.update(product);

        return product;
    }

    @RequestMapping(value = "/edit/t={id}", method = RequestMethod.GET)
    public String editTax(@PathVariable("id") int id, Map model) {

        Tax tax = tdao.get(id);

        boolean tEdit = true;
        model.put("tEdit", tEdit);
        model.put("tax", tax);

        return "edit";
    }

    @RequestMapping(value = "/t", method = RequestMethod.PUT)
    @ResponseBody
    public Tax editT(@Valid @RequestBody Tax tax) {

        tdao.update(tax);

        return tax;
    }

}
