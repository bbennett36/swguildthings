/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.dto.Audit;
import com.mycompany.dto.Order;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 *
 * @author apprentice
 */
public class createAudit {

    AuditDaoInterface adao;

    public createAudit(AuditDaoInterface adao) {
        this.adao = adao;
    }

    public Object createLog(ProceedingJoinPoint pjp) throws Throwable {

        Order output = (Order) pjp.proceed();

        int orderId = output.getId();
        String product = output.getProduct();
        double total = output.getTotal();
        String name = output.getName();

        Audit audit = new Audit();
        audit.setOrderId(orderId);
        audit.setProductType(product);
        audit.setTotal(total);
        audit.setType("Created");
        audit.setName(name);

        adao.createNew(audit);

        return output;
    }

    public Object updateLog(ProceedingJoinPoint pjp) throws Throwable {

        Order output = (Order) pjp.proceed();

        int orderId = output.getId();
        String product = output.getProduct();
        double total = output.getTotal();
        String name = output.getName();

        Audit audit = new Audit();
        audit.setOrderId(orderId);
        audit.setProductType(product);
        audit.setTotal(total);
        audit.setType("Updated");
        audit.setName(name);

        adao.createNew(audit);

        return output;
    }

    public Object deleteLog(ProceedingJoinPoint pjp) throws Throwable {

        Order output = (Order) pjp.proceed();

        int orderId = output.getId();
        String product = output.getProduct();
        double total = output.getTotal();
        String name = output.getName();

        Audit audit = new Audit();
        audit.setOrderId(orderId);
        audit.setProductType(product);
        audit.setTotal(total);
        audit.setType("Deleted");
        audit.setName(name);

        adao.createNew(audit);

        return output;
    }

}
