/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fc;

import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mycompany.fc.dao.BusDao;
import com.mycompany.fc.dto.Bus;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author apprentice
 */
@Controller
@RequestMapping(value = "/trip")
public class BusController {
    
    private BusDao bdao;
    
    @Inject
    public BusController(BusDao bdao) {
        this.bdao = bdao;
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@ModelAttribute Bus bus, Map model) {
       
        bdao.create(bus);
        
//        boolean showSummary = true;
//        model.put("showSummary", showSummary);
//        model.put("bus", bus);
        
        return "redirect:/trip/ordersummary";

    }
    
      @RequestMapping(value = "/ordersummary", method = RequestMethod.GET)
    public String getOrder() {

        return "ordersummary";

    }
    
    
    
}
