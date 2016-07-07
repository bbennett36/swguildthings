/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dataencoding;

import com.mycompany.controllers.StudentnController;
import com.mycompany.dto.Student;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author apprentice
 */
public class App {

    public static void main(String[] args) {

        StudentnController controller = new StudentnController();
        
        controller.run();
        
        
//        Student sam = new Student();
//        sam.setId(1);
//        sam.setFirstName("Sam");
//        sam.setLastName("Dallas");
//        sam.setCohort("April 2016");
//
//        Student bill = new Student();
//        bill.setId(2);
//        bill.setFirstName("Bill");
//        bill.setLastName("Jones");
//        bill.setCohort("Jan 2016");
//
//        Student sally = new Student();
//        sally.setId(3);
//        sally.setFirstName("Sam");
//        sally.setLastName("Savage");
//        sally.setCohort("Feb 2016");
//
//        List<Student> students = new ArrayList();
//        students.add(sam);
//        students.add(bill);
//        students.add(sally);
//
//        encode(students);
//        decode();
        
        
    }

    

}
