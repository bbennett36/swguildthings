/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvd.controller;

import com.mycompany.consoleio.ConsoleIO;
import com.mycompany.dvd.dao.DVDDao;
import com.mycompany.dvd.dao.DVDLibraryImpl;
import com.mycompany.dvd.dto.DVD;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class DVDController {

    ConsoleIO ci = new ConsoleIO();
    Scanner read = new Scanner(System.in);
//    DVDDao dao = new DVDDao();
    DVDLibraryImpl ldao = new DVDLibraryImpl();
    
    public DVDController( DVDLibraryImpl ldao) {
        this.ldao = ldao;
    }

    public void run() {

        boolean runAgain = true;
        while (runAgain) {

            ci.displayString("Please choose an option below: ");
            ci.displayString("1. Add DVD to collection");
            ci.displayString("2. Remove DVD from collection");
            ci.displayString("3. List all DVDs in the collection");
            ci.displayString("4. Display info for a certain DVD");
            ci.displayString("5. Search collection by title");
            ci.displayString("6. Edit an address");
            ci.displayString("7. Exit");
            int selection = read.nextInt();

            switch (selection) {
                case 1:
                    addDvd();
                    break;
                case 2:
                    deleteDvd();
                    break;
                case 3:
                    listDvds();
                    break;
                case 4:
                    displayInfo();
                    break;
                case 5:
                    searchByTitle();
                    break;
                case 6:
                    editDvd();
                    break;
                case 7:
                    runAgain = false;
                    break;
                case 8:
                    testDate();
                    break;
            }

        }
    }

    public void addDvd() {

        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;
        String title = ci.getWord("Enter title: ");
        String rd = ci.getWord("Enter Release Date: ");
        try {
            date = df.parse(rd);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String mpaa = ci.getWord("Enter MPAA rating: ");
        String dname = ci.getWord("Enter Director name: ");
        String studio = ci.getWord("Enter Studio ");
        String note = ci.getWord("Enter notes about the movie: ");

        DVD myDvd = new DVD();
        myDvd.setTitle(title);
        myDvd.setReleaseDate(date);
        myDvd.setmPAA(mpaa);
        myDvd.setDirectorsName(dname);
        myDvd.setStudio(studio);
        myDvd.setNote(note);

        ldao.create(myDvd);

    }

    public void deleteDvd() {

        listDvds();
        int id = ci.enterInt("Please enter address ID to delete: ");

        DVD myDvd = new DVD();
        myDvd.setId(id);

        ldao.delete(myDvd);

    }

    public void listDvds() {

        List<DVD> dvds = ldao.getDvds();

        for (DVD myDvd : dvds) {
            ci.displayString("|Id:" + myDvd.getId() + "|Title:" + myDvd.getTitle() + "|ReleaseDate:"
                    + myDvd.getReleaseDate() + "|MPAA:" + myDvd.getmPAA() + "|DirectorsName:"
                    + myDvd.getDirectorsName() + "|Studio" + myDvd.getStudio() + "|Notes:" + myDvd.getNote());
        }

    }

    public void displayInfo() {

        List<DVD> dvds = ldao.getDvds();

        ci.displayString("List of DVDs IDs: ");
        for (DVD myDvd : dvds) {
            ci.displayString("|Id:" + myDvd.getId() + "|");
        }

        int search = ci.enterInt("Enter the ID for the DVD that you want to display info for: ");

        for (DVD myDvd : dvds) {
            if (search == myDvd.getId()) {
                ci.displayString("|Id:" + myDvd.getId() + "|Title:" + myDvd.getTitle() + "|ReleaseDate:"
                        + myDvd.getReleaseDate() + "|MPAA:" + myDvd.getmPAA() + "|DirectorsName:"
                        + myDvd.getDirectorsName() + "|Studio" + myDvd.getStudio() + "|Notes:" + myDvd.getNote());
            }

        }

    }

    public void searchByTitle() {

        List<DVD> dvds = ldao.getDvds();

        ci.displayString("List of Titles in collection: ");
        for (DVD myDvd : dvds) {
            ci.displayString(myDvd.getTitle());
        }

        String search = ci.getWord("Enter the title that you want the info for: ");

        for (DVD myDvd : dvds) {
            if (search.equals(myDvd.getTitle())) {
                ci.displayString("|Id:" + myDvd.getId() + "|Title:" + myDvd.getTitle() + "|ReleaseDate:"
                        + myDvd.getReleaseDate() + "|MPAA:" + myDvd.getmPAA() + "|DirectorsName:"
                        + myDvd.getDirectorsName() + "|Studio" + myDvd.getStudio() + "|Notes:" + myDvd.getNote());
            }

        }
    }

    public void editDvd() {

        List<DVD> dvds = ldao.getDvds();

        listDvds();

        int search = ci.enterInt("Enter the ID for the DVD that you want to edit: ");

        DVD myDvd = ldao.get(search);

        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;
        String title = ci.getWord("Enter title: ");
        String rd = ci.getWord("Enter Release Date: ");
        try {
            date = df.parse(rd);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String mpaa = ci.getWord("Enter MPAA rating: ");
        String dname = ci.getWord("Enter Director name: ");
        String studio = ci.getWord("Enter Studio: ");
        String note = ci.getWord("Enter notes about the movie: ");

        myDvd.setTitle(title);
        myDvd.setReleaseDate(date);
        myDvd.setmPAA(mpaa);
        myDvd.setDirectorsName(dname);
        myDvd.setStudio(studio);
        myDvd.setNote(note);

        ldao.update(myDvd);

    }

    public void testDate() {
        DVDLibraryImpl im = new DVDLibraryImpl();
//       Map<String, List<DVD>> test = dao.getDirector("Billy");
        DVD get = im.get(1);
        String movie = get.getTitle();
        System.out.println(movie);
    }

}
