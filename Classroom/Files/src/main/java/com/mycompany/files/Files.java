/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.files;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author apprentice
 */
public class Files {

    public static void main(String[] args) {

        WriteFile();
        
        
        readFile();

    }

    private static void readFile() {
        try {
            Scanner read = new Scanner(new BufferedReader(new FileReader("myFile.txt")));
            
            while(read.hasNextLine()) {
                String currentLine = read.nextLine();
                System.out.println(currentLine);
            }
            
            read.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Files.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void WriteFile() {
        PrintWriter out = null;
        try {
            out = new PrintWriter(new FileWriter("myFile.txt"));

            out.println("This is a line in my file");
            out.println("This is the second line in my file");
            out.println("a third line");

            out.flush();

        } catch (IOException ex) {
            Logger.getLogger(Files.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            out.close();
        }
    }
}
