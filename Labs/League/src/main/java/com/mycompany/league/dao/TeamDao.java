/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.league.dao;

import com.mycompany.league.app.App;
import com.mycompany.league.dto.Player;
import com.mycompany.league.dto.Team;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author apprentice
 */
public class TeamDao {

    private int nextId = 1;

    List<Team> teams = new ArrayList<>();

    private PlayerDao playerdao;

//    public TeamDao(PlayerDao playerdao) {
//        teams = decode();
//        this.playerdao = playerdao;
//    }
    public TeamDao() {
        teams = decode();
    }

    public Team create(Team team) {

        team.setId(nextId);
        nextId++;
        teams.add(team);

        encode();

        return team;

    }

    public Team get(Integer id) {

        for (Team myTeam : teams) {
            if (myTeam.getId() == id) {
                return myTeam;
            }
        }
        return null;

    }

    public void update(Team team) {

        Team found = null;

        for (Team myTeam : teams) {
            if (myTeam.getId() == team.getId()) {
                found = myTeam;
            }
        }

        teams.remove(found);
        teams.add(team);

        encode();
    }
    
    public void updateTeam(Team team)   {
        
        Team found = null;
        
        for (Team myTeam : teams) {
            if (myTeam.getId() == team.getId()) {
                found = myTeam;
            }
        }

        teams.add(found);

        encode();
    }

    public void delete(Team team) {

        Team found = null;

        for (Team myTeam : teams) {
            if (myTeam.getId() == team.getId()) {
                found = myTeam;
                break;
            }
        }

        teams.remove(found);

        encode();
    }

    private void encode() {

        final String TOKEN = "::";

        try {
            PrintWriter out = new PrintWriter(new FileWriter("teams.txt"));

            for (Team myTeam : teams) {
                out.print(myTeam.getId());
                out.print(TOKEN);

                out.print(myTeam.getTeamName());
                out.print("");
                
//                PrintWriter outplayers = new PrintWriter(new FileWriter(myTeam.getTeamName() + ".txt"));

//                PrintWriter outplayers = new PrintWriter(new FileWriter(myTeam.getTeamName() + ".txt"));
                for (Player myPlayer : myTeam.getPlayers()) {
                    out.print(TOKEN);

                    

//                    outplayers.print(myPlayer.getfName());
//                    outplayers.print(TOKEN);
//
//                    outplayers.print(myPlayer.getlName());
//                    outplayers.print(TOKEN);
//
//                    outplayers.print(myPlayer.getbAvg());
//                    outplayers.println();

//                    outplayers.flush();

//                    outplayers.print(myPlayer.getfName());
//                    outplayers.print(TOKEN);
//
//                    outplayers.print(myPlayer.getlName());
//                    outplayers.print(TOKEN);
//
//                    outplayers.print(myPlayer.getbAvg());
//                    outplayers.println();
//                    outplayers.flush();
                }
                out.println();
//                outplayers.close();
                out.flush();
            }
            out.close();

        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private List<Team> decode() {

        List<Team> teams = new ArrayList();
        List<Player> players = new ArrayList();

        try {
            Scanner read = new Scanner(new BufferedReader(new FileReader("teams.txt")));

            while (read.hasNextLine()) {
                String currentLine = read.nextLine();

                String[] stringParts = currentLine.split("::");

                Team myTeam = new Team();

                int id = Integer.parseInt(stringParts[0]);
                myTeam.setId(id);
                if (!teams.isEmpty()) {
                    int testid = myTeam.getId();
                    nextId = testid + 1;
                }
                myTeam.setTeamName(stringParts[1]);
                
                for (Player myPlayer : myTeam.getPlayers()) {
//                    out.print(myPlayer.getId());
                    int pid = Integer.parseInt(stringParts[2]);
                    myPlayer.setId(pid);
                    players.add(myPlayer);
                }

<<<<<<< HEAD
//                for (Player myPlayer : myTeam.getPlayers()) {
//                    out.print(myPlayer.getId());
                Player myPlayer = new Player();
                int pid = Integer.parseInt(stringParts[2]);
                myPlayer.setId(pid);
                players.add(myPlayer);
=======
>>>>>>> 1de3e487335d8dc5e0adb8ef74653546ddb9e149

                teams.add(myTeam);

            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

        return teams;

    }

    public List<Team> getTeams() {
        return teams;
    }

}
