/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lesson7projects;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class RunProjectsApp {

    public static void main(String[] args) {

        ConsoleIO ci = new ConsoleIO();

        RunProjects ad = new AddressController();
        RunProjects dvd = new DVDController();
        RunProjects vend = new VendingController();


        List<RunProjects> rp = new ArrayList();

        rp.add(ad);
        rp.add(dvd);
        rp.add(vend);

        boolean stillPlaying = true;

        while (stillPlaying) {

            for (RunProjects myProject : rp) {
                ci.displayString("Project name: " + myProject.getName());
            }

            String input = ci.getWord("Please enter the project name to run. Or type exit to exit");

            for (RunProjects myProject : rp) {
                if (input.equals(myProject.getName())) {
                    myProject.run();
                }
            }

            if ("exit".equals(input)) {
                stillPlaying = false;

            }

        }
    }
}
