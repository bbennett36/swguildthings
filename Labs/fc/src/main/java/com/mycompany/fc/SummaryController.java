/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fc;

import com.mycompany.fc.dao.BusDao;
import java.util.Map;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author apprentice
 */
@Controller
@RequestMapping(value = "/summary")
public class SummaryController {

    private BusDao bdao;

    @Inject
    public SummaryController(BusDao bdao) {
        this.bdao = bdao;
    }

    @RequestMapping(value = "/sum", method = RequestMethod.GET)
    public String getOrder() {

        return "ordersummary";

    }
}
