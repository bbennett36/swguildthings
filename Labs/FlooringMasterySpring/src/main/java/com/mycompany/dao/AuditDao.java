/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.dto.Audit;
import com.mycompany.dto.Order;
import com.mycompany.dto.Product;
import com.mycompany.flooring.OrderApp;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author apprentice
 */
public class AuditDao {

    List<Audit> audits = new ArrayList<>();
    Date time = new Date();
    private int nextId = 1;

//    public AuditDao() {
//        audits = decode();
//    }
    public int getNextId() {
        int result = 0;
        for (Audit myAudit : audits) {
            if (myAudit.getId() > result) {
                result = myAudit.getId();
            }
        }
        result++;
        return result;

    }

    public Audit createNew(Audit audit) {

        audit.setId(nextId);
//        nextId++;
//        Date time = new Date();
//        Audit audit = (Audit) order;
        audits.add(audit);

        encode();

        return audit;

    }

//   public Product get(String type) {
//
//        for (Product myProduct : audits) {
//            if (myProduct.getProductType().equals(type)) {
//                return myProduct;
//            }
//        }
//        return null;
//    }
//    public void update(Product product) {
//
//        Product found = null;
//
//        for (Product myProduct : audits) {
//            if (myProduct.getProductType().equals(product.getProductType())) {
//                found = myProduct;
//            }
//        }
//
//        audits.remove(found);
//        audits.add(found);
//
//        encode();
////    }
//
//    public void delete(Product product) {
//
//        Product found = null;
//
//        for (Product myProduct : audits) {
//            if (myProduct.getProductType().equals(product.getProductType())) {
//                found = myProduct;
//                break;
//            }
//        }
//
//        audits.remove(found);
//
//        encode();
//    }
    private void encode() {

        final String TOKEN = ",";

        try {
            PrintWriter out = new PrintWriter(new FileWriter("Audit.txt"));

            out.println("ID,Product,Total, Date Created");

            for (Audit o : audits) {

                out.print(o.getId());
                out.print(TOKEN);

                out.print(o.getOrderId());
                out.print(TOKEN);

                out.print(o.getProductType());
                out.print(TOKEN);

                out.print(o.getTotal());
                out.print(TOKEN);

                out.print(time);
                out.println();

                out.flush();

            }

            out.close();

        } catch (IOException ex) {
            Logger.getLogger(OrderApp.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private List<Audit> decode() {

        List<Product> products = new ArrayList();

        try {
            Scanner read = new Scanner(new BufferedReader(new FileReader("Audit.txt")));

            int line = 0;

            while (read.hasNextLine()) {
                String currentLine = read.nextLine();

                String[] stringParts = currentLine.split(",");

                line++;
                if (line == 1) {
                    continue;
                }

                Audit myAudit = new Audit();

                int id = Integer.parseInt(stringParts[0]);
                myAudit.setId(id);
                int orderId = Integer.parseInt(stringParts[1]);
                myAudit.setOrderId(orderId);
                myAudit.setProductType(stringParts[2]);
                double total = Double.parseDouble(stringParts[3]);
                myAudit.setTotal(total);

                SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                Date date = null;
                String rd = stringParts[4];
//                myDvd.setReleaseDate(stringParts[2]);
                try {
                    date = df.parse(rd);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                myAudit.setDate(date);

                audits.add(myAudit);

            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(OrderApp.class.getName()).log(Level.SEVERE, null, ex);
        }

        return audits;

    }

//    public List<Product> getProducts() {
//        return audits;
//    }
}