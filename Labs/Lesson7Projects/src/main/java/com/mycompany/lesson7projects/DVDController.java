/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lesson7projects;

//import com.mycompany.dvd.dao.DVDDao;
//import com.mycompany.dvd.dto.DVD;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class DVDController implements RunProjects {

    ConsoleIO ci = new ConsoleIO();
    Scanner read = new Scanner(System.in);
    DVDDao dao = new DVDDao();

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
            }

        }
    }

    public void addDvd() {

        String title = ci.getWord("Enter title: ");
        String rd = ci.getWord("Enter Release Date: ");
        String mpaa = ci.getWord("Enter MPAA rating: ");
        String dname = ci.getWord("Enter Director name: ");
        String studio = ci.getWord("Enter Studio ");
        String note = ci.getWord("Enter notes about the movie: ");

        DVD myDvd = new DVD();
        myDvd.setTitle(title);
        myDvd.setReleaseDate(rd);
        myDvd.setmPAA(mpaa);
        myDvd.setDirectorsName(dname);
        myDvd.setStudio(studio);
        myDvd.setNote(note);

        dao.create(myDvd);

    }

    public void deleteDvd() {

        int id = ci.enterInt("Please enter address ID to delete: ");

        DVD myDvd = new DVD();
        myDvd.setId(id);

        dao.delete(myDvd);

    }

    public void listDvds() {

        List<DVD> dvds = dao.getDvds();

        for (DVD myDvd : dvds) {
            ci.displayString("|Id:" + myDvd.getId() + "|Title:" + myDvd.getTitle() + "|ReleaseDate:"
                    + myDvd.getReleaseDate() + "|MPAA:" + myDvd.getmPAA() + "|DirectorsName:"
                    + myDvd.getDirectorsName() + "|Studio" + myDvd.getStudio() + "|Notes:" + myDvd.getNote());
        }

    }

    public void displayInfo() {

        List<DVD> dvds = dao.getDvds();

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

        List<DVD> dvds = dao.getDvds();

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

        List<DVD> dvds = dao.getDvds();

        listDvds();

        int search = ci.enterInt("Enter the ID for the DVD that you want to edit: ");

        DVD myDvd = dao.get(search);

        String title = ci.getWord("Enter title: ");
        String rd = ci.getWord("Enter Release Date: ");
        String mpaa = ci.getWord("Enter MPAA rating: ");
        String dname = ci.getWord("Enter Director name: ");
        String studio = ci.getWord("Enter Studio: ");
        String note = ci.getWord("Enter notes about the movie: ");

        myDvd.setTitle(title);
        myDvd.setReleaseDate(rd);
        myDvd.setmPAA(mpaa);
        myDvd.setDirectorsName(dname);
        myDvd.setStudio(studio);
        myDvd.setNote(note);

        dao.update(myDvd);

    }

    @Override
    public String getName() {
        return "DVD";
    }
}
