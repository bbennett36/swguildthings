package com.mycompany.addressbookmvc.controllers;

import com.mycompany.addressbookmvc.dao.AddressBookDao;
import com.mycompany.addressbookmvc.dto.Address;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
    
    private AddressBookDao dao;
        
    @Inject
    public HomeController(AddressBookDao dao) {
        this.dao = dao;
    }
    
    @RequestMapping(value="/", method=RequestMethod.GET)
    public String sayHi(Map<String, Object> model) {
        List<Address> addresses = dao.list();
        model.put("addresses", addresses);
        model.put("address", new Address());
        
        return "home";
    }
}
