/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmvc.dao;


import com.mycompany.flooringmvc.dto.Audit;
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
public class AuditDaoImpl implements AuditDaoInterface {

    List<Audit> audits = new ArrayList<>();
    

    private int nextId = 1;

    public AuditDaoImpl() {
        audits = decode();
    }

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

    @Override
    public Audit createNew(Audit audit) {

        audit.setId(getNextId());
        Date time = new Date();
        audit.setDate(time);
        audits.add(audit);

        encode();
        return audit;

    }
    
    @Override
    public List<Audit> getAudits()  {
        return audits;
    }

    private void encode() {

        final String TOKEN = "-";

        try {
            PrintWriter out = new PrintWriter(new FileWriter("Audit.txt"));

            out.println("LogID - OrderId - Name - Product - Total - LogTime - LogReason");

            for (Audit o : audits) {

                out.print(o.getId());
                out.print(TOKEN);

                out.print(o.getOrderId());
                out.print(TOKEN);
                
                out.print(o.getName());
                out.print(TOKEN);

                out.print(o.getProductType());
                out.print(TOKEN);

                out.print(o.getTotal());
                out.print(TOKEN);

                out.print(o.getDate());
                out.print(TOKEN);
                
                out.print(o.getType());
                out.println();

                out.flush();

            }

            out.close();

        } catch (IOException ex) {
//            Logger.getLogger(OrderApp.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private List<Audit> decode() {

        List<Audit> audit = new ArrayList();

        try {
            Scanner read = new Scanner(new BufferedReader(new FileReader("Audit.txt")));

            int line = 0;

            while (read.hasNextLine()) {
                String currentLine = read.nextLine();

                String[] stringParts = currentLine.split("-");

                line++;
                if (line == 1) {
                    continue;
                }

                Audit myAudit = new Audit();

                int id = Integer.parseInt(stringParts[0]);
                myAudit.setId(id);
                int orderId = Integer.parseInt(stringParts[1]);
                myAudit.setOrderId(orderId);
                myAudit.setName(stringParts[2]);
                myAudit.setProductType(stringParts[3]);
                double total = Double.parseDouble(stringParts[4]);
                myAudit.setTotal(total);

                SimpleDateFormat df = new SimpleDateFormat("EEE MMM dd hh:mm:ss ZZZ yyyy");
                Date date = null;
                String rd = stringParts[5];
                try {
                    date = df.parse(rd);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                myAudit.setDate(date);
                myAudit.setType(stringParts[6]);

                audits.add(myAudit);

            }

        } catch (FileNotFoundException ex) {
//            Logger.getLogger(OrderApp.class.getName()).log(Level.SEVERE, null, ex);
        }

        return audits;

    }

}
