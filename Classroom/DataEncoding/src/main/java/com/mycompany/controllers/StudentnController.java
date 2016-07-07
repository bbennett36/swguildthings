/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controllers;

import com.mycompany.dao.StudentDao;
import com.mycompany.dto.Student;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */

public class StudentnController {

    private StudentDao dao = new StudentDao();
    private Scanner read = new Scanner(System.in);

    public void run() {

        boolean runAgain = true;
        while (runAgain) {

            System.out.println("Please choose an option below: ");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");

            int selection = read.nextInt();

            switch (selection) {
                case 1:
                    //add student
                    addStudent();
                    break;
                case 2:
                    //remove student
                    removeStudent();
                    break;
            }

        }

    }

    public void addStudent() {

        System.out.print("Please enter new students name: ");
        String name = read.next();
        
        System.out.println("Enter Quiz score 1: ");
        int quiz1 = read.nextInt();
        
        System.out.println("Enter Quiz score 2: ");
        int quiz2 = read.nextInt();
        
        System.out.println("Enter Quiz score 3: ");
        int quiz3 = read.nextInt();

        Student myStudent = new Student();
        myStudent.setName(name);
        myStudent.setQuiz1(quiz1);
        myStudent.setQuiz2(quiz2);
        myStudent.setQuiz3(quiz3);
        
        dao.create(myStudent);

    }

    public void removeStudent() {

        System.out.println("What student do you want to delete?");
        int d = read.nextInt();
        
        Student student = dao.get(1);
        
        if(student.id == d)  {
            dao.delete(student);
        }
        
       
        
    }
}
