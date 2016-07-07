/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fc.dao;

import com.mycompany.fc.dto.Bus;
import com.mycompany.fc.dto.Trip;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class BusDaoImpl implements BusDao {

    List<Bus> buses = new ArrayList();

    private int getNextId() {
        int result = 1;
        for (Bus b : buses) {
            if (b.getId() > result) {
                result = b.getId();
            }
        }
        result++;
        return result;
    }

    @Override
    public Bus create(Bus bus) {

        bus.setId(getNextId());
        buses.add(bus);
//        adao.createNew(order);

        return bus;

    }

    @Override
    public Bus update(Bus bus) {

        buses.removeIf(a -> a.getId() == bus.getId());
        buses.add(bus);

        return bus;

    }

    @Override
    public Bus get(int id) {

        return buses.stream()
                .filter(a -> a.getId() == id)
                .findFirst()
                .orElse(null);

    }

    @Override
    public void delete(Bus bus) {

        buses.removeIf(a -> a.getId() == bus.getId());

    }
    
    @Override
    public List<Bus> list()   {
        return buses;
    }

}
