/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.league.controller;

import com.mycompany.league.dao.PlayerDao;
import com.mycompany.league.dao.TeamDao;
import com.mycompany.league.dto.Player;
import com.mycompany.league.dto.Team;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class LeagueController {

    TeamDao tdao = new TeamDao();
    PlayerDao pdao = new PlayerDao();
//    TeamDao tdao = new TeamDao(pdao);
    ConsoleIO ci = new ConsoleIO();
    Team t = new Team();
    Scanner read = new Scanner(System.in);

    public void run() {
        boolean runAgain = true;
        while (runAgain) {

            ci.displayString("Please choose an option below: ");
            ci.displayString("1. Add Team");
            ci.displayString("2. Add Player");
            ci.displayString("3. List Teams");
            ci.displayString("4. List Players on a Team");
            ci.displayString("5. Trade a player");
            ci.displayString("6. Delete a player");
            ci.displayString("7. Exit");
            int selection = read.nextInt();

            switch (selection) {
                case 1:
                    addTeam();
                    break;
                case 2:
                    addPlayer();
                    break;
                case 3:
                    listTeams();
                    break;
                case 4:
                    listPlayersOnTeam();
                    break;
                case 5:
                    tradePlayers();
                    break;
                case 6:
                    deletePlayer();
                    break;
                case 7:
                    runAgain = false;
                    break;
            }

        }
    }

    public void addTeam() {

        String tname = ci.getWord("Enter Team Name ");

        Team myTeam = new Team();
        myTeam.setTeamName(tname);

        tdao.create(myTeam);

    }

    public void addPlayer() {

        List<Team> teams = tdao.getTeams();

        for (Team myTeam : teams) {
            ci.displayString("|ID: " + myTeam.getId() + "|Team:" + myTeam.getTeamName());
        }

        int id = ci.enterInt("Enter the ID for the team that you would like to add a player too: ");

        for (Team myTeam : teams) {
            if (id == myTeam.getId()) {
                String fname = ci.getWord("Enter First Name of player");
                String lname = ci.getWord("Enter Last Name of player");
                double avg = ci.getDouble("Enter Batting Average");

                Player myPlayer = new Player();
                myPlayer.setId(1);
                myPlayer.setfName(fname);
                myPlayer.setlName(lname);
                myPlayer.setbAvg(avg);
                pdao.create(myPlayer);
                myTeam.getPlayers().add(myPlayer);
                tdao.update(myTeam);
            }

        }

    }

    public void listTeams() {

        List<Team> teams = tdao.getTeams();

        for (Team myTeam : teams) {
            ci.displayString("|Id:" + myTeam.getId() + "|TeamName:" + myTeam.getTeamName());
        }

    }

    public void listPlayersOnTeam() {

        List<Team> teams = tdao.getTeams();
        List<Player> players = pdao.getPlayers();

        listTeams();
        String search = ci.getWord("Enter the team that you want a list of playeres for: ");
        for (Team myTeam : teams) {
            if (search.equals(myTeam.getTeamName())) {
                for (Player myPlayer : myTeam.getPlayers()) {
                    System.out.println("FirstName:" + myPlayer.getfName() + " LastName:" + myPlayer.getlName());
                }
            }
        }

    }

    public void tradePlayers() {

    }

    public void deletePlayer() {

        List<Player> players = pdao.getPlayers();

        for (Player myPlayer : players) {
            ci.displayString("ID:" + myPlayer.getId() + "FirstName" + myPlayer.getfName() + "LastName" + myPlayer.getlName());
        }

        int id = ci.enterInt("Please enter player ID to delete: ");

        Player myPlayer = new Player();
        myPlayer.setId(id);

        pdao.delete(myPlayer);

    }

}
