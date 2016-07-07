/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package address.app;

import address.controller.AddressController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Brennan
 */
public class App {
    public static void main(String[] args) {
        
//        AddressController ac = new AddressController();

//          AddressDaoLamdaImpl ldao = new AddressDaoLamdaImpl();
//        AddressController ac = new AddressController(ldao);
//        
//        ac.run();

  ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    
    AddressController controller = ctx.getBean("controller", AddressController.class);
    controller.run();
        
    }
}
