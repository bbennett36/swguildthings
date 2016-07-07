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
public class Quiz {
    
    
    
    public int quiz1;
    public int quiz2;
    public int quiz3;
    
//    public Quiz(Quiz quiz1, int quiz2, int quiz3)    {
//        this.quiz1 = quiz1;
//        this.quiz2 = quiz2;
//        this.quiz3 = quiz3;
//    }
    

    public void setQuiz3(int quiz3) {
        this.quiz3 = quiz3;
    }

        public void setQuiz2(int quiz2) {
            this.quiz2 = quiz2;
        }

    public void setQuiz1(int quiz1) {
        this.quiz1 = quiz1;
    }

    public int getQuiz3() {
        return quiz3;
    }

    public int getQuiz2() {
        return quiz2;
    }

    public int getQuiz1() {
        return quiz1;
    }
            
}
