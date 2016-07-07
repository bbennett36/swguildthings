/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdmvc.dao;

import com.mycompany.dvdmvc.dto.DVD;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author apprentice
 */
public class DVDLibraryImpl implements DVDDao {

    List<DVD> dvds = new ArrayList<>();

    private int nextId = 1;

    public DVDLibraryImpl() {
        dvds = decode();
    }

    @Override
    public DVD create(DVD dvd) {
        dvd.setId(nextId);
        nextId++;
        dvds.add(dvd);

        encode();
        return dvd;
    }

    @Override
    public DVD get(Integer id) {

        return dvds.stream()
                .filter(d -> d.getId() == id)
                .findFirst()
                .orElse(null);

    }

    @Override
    public void update(DVD dvd) {
        dvds.removeIf(a -> a.getId() == dvd.getId());

        dvds.add(dvd);

        encode();
    }

    @Override
    public void delete(DVD dvd) {
        dvds.removeIf(a -> a.getId() == dvd.getId());
        
        encode();
    }

    @Override
    public List<DVD> getMPAA(String rating) {

        return dvds.stream()
                .filter(a -> a.getmPAA().equals(rating))
                .collect(Collectors.toList());

    }

    @Override
    public List<DVD> getStudio(String studio) {

        return dvds.stream()
                .filter(a -> a.getStudio().equals(studio))
                .collect(Collectors.toList());
    }

    @Override
    public List<DVD> findDvdsInXYears(int x) {

        List<DVD> getList = new ArrayList();

        Date todayIs = new Date();
        for (DVD d : dvds) {

            Calendar cal = Calendar.getInstance();
            cal.setTime(d.getReleaseDate());

            Calendar today = Calendar.getInstance();
            today.setTime(todayIs);

            int curYear = today.get(Calendar.YEAR);
            int year = cal.get(Calendar.YEAR);

            if (curYear - year <= x) {
                getList.add(d);

            }

        }
        return getList;
    }

    @Override
    public double findAvgAge() {
        Date todayIs = new Date();
        int age = 0;
        int thisAge = 0;
        for (DVD d : dvds) {

            Calendar cal = Calendar.getInstance();
            cal.setTime(d.getReleaseDate());

            Calendar today = Calendar.getInstance();
            today.setTime(todayIs);
            int curYear = today.get(Calendar.YEAR);
            int curMonth = today.get(Calendar.MONTH);
            int curDay = today.get(Calendar.DAY_OF_MONTH);

            int year = cal.get(Calendar.YEAR);
            int month = cal.get(Calendar.MONTH);
            int day = cal.get(Calendar.DAY_OF_MONTH);

            thisAge = curYear - year;
            if (curMonth < month || (month == curMonth && curDay < day)) {
                age--;
            }
            age += thisAge;
        }
        double size = dvds.size();
        double avg = age / size;
        return avg;
    }

    @Override
    public DVD findOldest() {

        return dvds.stream()
                .min(Comparator.comparing(a -> a.getReleaseDate()))
                .get();

    }

    @Override
    public Map<String, List<DVD>> getDirector(String director) {
        Map<String, List<DVD>> collect = dvds.stream()
                .filter(a -> a.getDirectorsName().equals(director))
                .collect(Collectors.groupingBy(DVD::getmPAA));
        return collect;

    }

    @Override
    public DVD findNewest() {

        return dvds.stream()
                .max(Comparator.comparing(a -> a.getReleaseDate()))
                .get();
    }

    private void encode() {

        final String TOKEN = "::";

        try {
            PrintWriter out = new PrintWriter(new FileWriter("dvds.txt"));

            for (DVD myDvd : dvds) {
                out.print(myDvd.getId());
                out.print(TOKEN);

                out.print(myDvd.getTitle());
                out.print(TOKEN);
//
                DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                Date date = myDvd.getReleaseDate();
                String reportDate = df.format(date);
                
                out.print(reportDate);
                out.print(TOKEN);

                out.print(myDvd.getmPAA());
                out.print(TOKEN);

                out.print(myDvd.getDirectorsName());
                out.print(TOKEN);

                out.print(myDvd.getStudio());
//                out.print(TOKEN);

//                out.print(myDvd.getNote());
                out.println();
                
                            out.flush();


            }

            out.close();

        } catch (IOException ex) {
//            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private List<DVD> decode() {

        List<DVD> dvds = new ArrayList<>();

        try {
            Scanner read = new Scanner(new BufferedReader(new FileReader("dvds.txt")));

            while (read.hasNextLine()) {
                String currentLine = read.nextLine();

                String[] stringParts = currentLine.split("::");

                DVD myDvd = new DVD();

                int id = Integer.parseInt(stringParts[0]);
                myDvd.setId(id);
                if (!dvds.isEmpty()) {
                    int testid = myDvd.getId();
                    nextId = testid + 1;
                }
                myDvd.setTitle(stringParts[1]);

                SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                Date date = null;
                String rd = stringParts[2];
//                myDvd.setReleaseDate(stringParts[2]);
                try {
                    date = df.parse(rd);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                myDvd.setReleaseDate(date);

                myDvd.setmPAA(stringParts[3]);
                myDvd.setDirectorsName(stringParts[4]);
                myDvd.setStudio(stringParts[5]);
//                myDvd.setNote(stringParts[6]);

                dvds.add(myDvd);

            }

        } catch (FileNotFoundException ex) {
//            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

        return dvds;

    }

    @Override
    public List<DVD> getDvds() {
        return dvds;
    }


}
