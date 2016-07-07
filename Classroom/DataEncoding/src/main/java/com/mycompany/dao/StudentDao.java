/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.dataencoding.App;
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

public class StudentDao {

    private List<Student> students = new ArrayList();
    private int nextId = 1;

    public StudentDao() {
        students = decode();
    }

    public Student create(Student student) {

        student.setId(nextId);
        nextId++;
        students.add(student);

        encode();

        return student;

    }

    public Student get(Integer id) {

        for (Student myStudent : students) {
            if (myStudent.getId() == id) {
                return myStudent;
            }
        }
        return null;

    }

    public void update(Student student) {

        for (Student myStudent : students) {
            if (myStudent.getId() == student.getId()) {
                students.remove(myStudent);
                students.add(student);
            }
        }

        encode();
    }

    public void delete(Student student) {

        for (Student myStudent : students) {
            if (myStudent.getId() == student.getId()) {
                students.remove(myStudent);
            }
        }

        encode();

    }
    
    public Student print(Student student)  {
        for (Student myStudent : students)  {
            return myStudent;
        }
    }

    private void encode() {

        final String TOKEN = "::";

        try {
            PrintWriter out = new PrintWriter(new FileWriter("students.txt"));

            for (Student myStudent : students) {
                out.print(myStudent.getId());
                out.print(TOKEN);

                out.print(myStudent.getName());
                out.print(TOKEN);

                out.print(myStudent.getQuiz1());
                out.print(TOKEN);
                
                 out.print(myStudent.getQuiz2());
                out.print(TOKEN);

                out.print(myStudent.getQuiz3());
                out.println();
            }

            out.flush();
            out.close();

        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private List<Student> decode() {

        List<Student> studentList = new ArrayList();

        try {
            Scanner read = new Scanner(new BufferedReader(new FileReader("students.txt")));

            while (read.hasNextLine()) {
                String currentLine = read.nextLine();

                String[] stringParts = currentLine.split("::");

                Student myStudent = new Student();

                int id = Integer.parseInt(stringParts[0]);
                myStudent.setId(id);
                
                myStudent.setName(stringParts[1]);
                
                int quiz1 = Integer.parseInt(stringParts[2]);
                myStudent.setQuiz1(quiz1);
                
                int quiz2 = Integer.parseInt(stringParts[3]);
                myStudent.setQuiz2(quiz2);
                
                int quiz3 = Integer.parseInt(stringParts[4]);
                myStudent.setQuiz3(quiz3);
                

                studentList.add(myStudent);

            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

        return studentList;

    }

}
