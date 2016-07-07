/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.studentquiz;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class App {
    public static void main(String[] args) {
        
//       StudentQuiz sc = new StudentQuiz();
//       
//       sc.run();
        Student brennan = new Student();
        List<Quiz> scores = new ArrayList();        
        
         Quiz qz = new Quiz();
         qz.setQuiz1(50);
         qz.setQuiz2(60);
         qz.setQuiz3(70);
         
//         int q1 = qz.getQuiz1();
//         int q2 = qz.getQuiz2();
//         int q3 = qz.getQuiz3();
//         
////         Object qui1 = (Object) q1;
//         Integer dataCount = new Integer(q1);
//         Object qui2 = (Object) q2;
//         Object qui3 = (Object) q3;
//         
//         Quiz quiz1 = (Quiz) qui1;
//         Quiz quiz2 = (Quiz) qui2;
//         Quiz quiz3 = (Quiz) qui3;
         
         brennan.setName("Brennan");
         brennan.addQuiz(qz.getQuiz1());
         brennan.addQuiz(quiz2);
         brennan.addQuiz(quiz3);
         
         System.out.println(brennan);
         
//         scores.addQuiz(quiz1);
//         scores.add(quiz2);
//         scores.add(quiz3);
//         
//         
//         
//         for(Quiz myScores : scores)    {
//             
//              System.out.println(myScores.getList());
//         
//         }
//         brennan.Quiz a = (Quiz) q1;
         
//        List<Quiz> scores = brennan.getList();

    }
}
