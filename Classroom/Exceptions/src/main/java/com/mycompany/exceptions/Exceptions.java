/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author apprentice
 */
public class Exceptions {

    public static void main(String[] args) {

       int input = getUserInput("Please enter an integer");
       
//       String value = null;
//       
//       if(value != null)    {
//           value.concat("asdasda");
//       }
//       
//       value.concat("asda");
        
        

    }

    public static int getUserInput(String prompt) throws Exception {
        Scanner read = new Scanner(System.in);

        boolean isValid = false;
        int input = 0;
        
        while (!isValid) {

            System.out.println(prompt);

            String userInput = read.nextLine();
            
            try {
                 input = Integer.parseInt(userInput);
                 isValid = true;
            } catch(Exception ex)   {
                
            }

           throw new Exception();
            
           

        }
        return input;
    }

    public static void readFile() {

        FileInputStream fi = null;
        try {
            fi = new FileInputStream("/adf");

            int i = 0;
            i++;
            System.out.println(i);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Exceptions.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Exceptions.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                //here wed close the file
                fi.close();
            } catch (IOException ex) {
                Logger.getLogger(Exceptions.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
