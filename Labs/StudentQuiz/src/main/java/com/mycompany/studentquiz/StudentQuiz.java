/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.studentquiz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author apprentice
 */
public class StudentQuiz {

//    Scanner read = new Scanner(System.in);
//    HashMap<String, Object> studentDirect = new HashMap();
//    
////    public String name;
////    public int quiz1;
////    public int quiz2;
//    
//    
//
////    private String studentName;
////    private int quiz1;
////    private int quiz2;
////    private int quiz3;
////    private int avg;
//
//    public void run() {
//        createStudentList();
//        boolean playAgain = true;
//        while (playAgain) {
//            System.out.println("Enter the number for choice");
//            System.out.println("1.List of students 2.Add a student 3.Remove a student 4.View list of scores for students 5.View average scores for a student 6.Exit Program");
//            String schoice = read.nextLine();
//            int choice = Integer.parseInt(schoice);
//            switch (choice) {
//                case 1:
//                    listStudents();
//                    break;
//                case 2:
////                    addStudent("Enter a new student name: ");
////                    break;
//                case 3:
////                    removeStudent("Enter the name of the student you want to remove: ");
////                    break;
//                case 4:
////                    listScores();
////                    break;
//                case 5:
////                    viewAvgs();
////                    break;
//                case 6:
//                    playAgain = false;
//                    break;
//                case 7:
//                    System.out.println("Invalid choice!");
//                    break;
//            }
//        }
//        System.out.println("See you later!");
//        //list of students()
//        //add a student()
//        //remove a student()
//        //view list of test scores for a given student
//        //view the average score for a given student
//    }
//
//    public void createStudentList() {
//        
//       StudentQuiz sq = new StudentQuiz();
//       sq.name = "Brennan";
//       sq.quiz1 = 40;
//       sq.quiz2 = 30;
//       studentDirect.put(sq.name, sq);
//       
//        Set<String> stateSet = studentDirect.keySet();
//
//        for (String state : stateSet) {
//            StudentQuiz objCapital = (StudentQuiz) studentDirect.get(state);
//
//            System.out.println(objCapital.name + ":" + objCapital.quiz1 + "  " + objCapital.quiz2 );
//        }
//       
//      
//       
//        
//       List<Integer> scores = new ArrayList();
//       scores.add(2);
//       scores.add(3);
//       scores.add(4);
//         
//       
//        
//
//        ArrayList<Integer> john = new ArrayList<>();
//
//        john.add(75);
//        john.add(82);
//        john.add(80);
//
//        ArrayList<Integer> bob = new ArrayList<>();
//
//        bob.add(99);
//        bob.add(96);
//        bob.add(92);
//
//        
////        studentDirect.put("John", john);
////        studentDirect.put("Bob", bob);
//    }
//
//    public void listStudents() {
//
////          for (String s : studentDirect.keySet())   {
////              System.out.println(s);
////          }
////          
////          System.out.println(brennan);
////          
//    }
//
////    public void addStudent(String prompt) {
////        System.out.println(prompt);
////        studentName = read.nextLine();
////        //assign this to key
////        
////        System.out.println("Enter quiz score 1:");
////        String squiz = read.nextLine();
////        quiz1 = Integer.parseInt(squiz);
////        //assign to list value
////        
////        System.out.println("Enter quiz score 2:");
////        squiz = read.nextLine();
////        quiz2 = Integer.parseInt(squiz);
////        //assign to list value
////        
////        System.out.println("Enter quiz score 3:");
////        squiz = read.nextLine();
////        quiz3 = Integer.parseInt(squiz);
////        
////        ArrayList<Integer> newArray = new ArrayList<>();
////        newArray.add(quiz1);
////        newArray.add(quiz2);
////        newArray.add(quiz3);
////        studentDirect.put(studentName, newArray);
////        //assign to list value
////        
////    }
////
////    public void removeStudent(String prompt) {
////    listStudents();
////        System.out.println(prompt);
////        String rStudent = read.nextLine();
////        if (studentDirect.containsKey(rStudent)) studentDirect.remove(rStudent);
////        
////    }
////
////    public void listScores() {
////
////         for (Map.Entry<String, ArrayList<Integer>> entry : studentDirect.entrySet()) {
////            String key = entry.getKey();
////            ArrayList<Integer> values = entry.getValue();
////            System.out.println(key + " - " + values);
////        }
////} 
////    public void viewAvgs() {
////    
////        
////    }
//

}
