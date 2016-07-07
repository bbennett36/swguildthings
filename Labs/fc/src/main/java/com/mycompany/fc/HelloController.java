package com.mycompany.fc;

import com.mycompany.fc.dto.Trip;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.mycompany.fc.dao.BusDao;
import com.mycompany.fc.dto.Bus;

@Controller
public class HelloController {
        
    private BusDao bdao;
    
    @Inject
    public HelloController(BusDao bdao) {
        this.bdao = bdao;
    }
    
    @RequestMapping(value="/", method=RequestMethod.GET)
    public String Home(Map model) {
        List<Bus> buses = bdao.list();
        model.put("buses", buses);
        
        
        
        return "bookatrip";
    }
    
    
}
