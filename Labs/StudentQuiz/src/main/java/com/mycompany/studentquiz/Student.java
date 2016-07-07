/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.studentquiz;

import java.util.List;

/**
 *
 * @author apprentice
 */
public class Student {

    private String name;
    private List<Integer> scores;
    private Quiz quiz;

//    public Student(String name) {
//        this.name = name;
//    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public List<Quiz> getList()   {
        return scores;
    }
    
    public void addQuiz(Quiz quiz)   {
        scores.add(quiz);
    }
    
    public Quiz getQuizObj()    {
        return quiz;
    }
            

}
