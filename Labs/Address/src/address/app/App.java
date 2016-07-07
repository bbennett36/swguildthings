/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package address.app;

import address.controller.AddressController;
import address.dao.AddressDaoLamdaImpl;

/**
 *
 * @author Brennan
 */
public class App {
    public static void main(String[] args) {
        
//        AddressController ac = new AddressController();

          AddressDaoLamdaImpl ldao = new AddressDaoLamdaImpl();
        AddressController ac = new AddressController(ldao);
        
        ac.run();
        
    }
}
