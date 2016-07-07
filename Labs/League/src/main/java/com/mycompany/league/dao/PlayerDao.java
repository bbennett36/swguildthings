/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.league.dao;

import com.mycompany.league.app.App;
import com.mycompany.league.dto.Player;
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
public class PlayerDao {
    
    private int nextId = 1;
    
    List<Player> players = new ArrayList<>();
    
     public PlayerDao() {
        players = decode();
    }

    public Player create(Player player) {

        player.setId(nextId);
        nextId++;
        players.add(player);

        encode();

        return player;

    }

    public Player get(Integer id) {

        for (Player myPlayer : players) {
            if (myPlayer.getId() == id) {
                return myPlayer;
            }
        }
        return null;

    }

    public void update(Player player) {

        Player found = null;

        for (Player myPlayer : players) {
            if (myPlayer.getId() == player.getId()) {
                found = myPlayer;
            }
        }

        players.remove(found);
        players.add(found);

        encode();
    }

    public void delete(Player player) {

        Player found = null;

        for (Player myPlayer : players) {
            if (myPlayer.getId() == player.getId()) {
                found = myPlayer;
                break;
            }
        }

        players.remove(found);

        encode();
    }

    private void encode() {

        final String TOKEN = "::";

        try {
            PrintWriter out = new PrintWriter(new FileWriter("players.txt"));

            for (Player myPlayer : players) {
                out.print(myPlayer.getId());
                out.print(TOKEN);
                
                out.print(myPlayer.getfName());
                out.print(TOKEN);

                out.print(myPlayer.getlName());
                out.print(TOKEN);

                out.print(myPlayer.getbAvg());
                out.println();

            }

            out.flush();
            out.close();

        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private List<Player> decode() {

        List<Player> players = new ArrayList<>();
        
        try {
            Scanner read = new Scanner(new BufferedReader(new FileReader("players.txt")));

            while (read.hasNextLine()) {
                String currentLine = read.nextLine();

                String[] stringParts = currentLine.split("::");

                Player myPlayer = new Player();

                int id = Integer.parseInt(stringParts[0]);
                myPlayer.setId(id);
                if(!players.isEmpty()) {
                    int testid = myPlayer.getId();
                    nextId = testid + 1;
                }
                myPlayer.setfName(stringParts[1]);
                myPlayer.setlName(stringParts[2]);
                double avg = Double.parseDouble(stringParts[3]);
                myPlayer.setbAvg(avg);
                
                
                players.add(myPlayer);

            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

        return players;

    }

    public List<Player> getPlayers() {
        return players;
    }
    
    
    
    
    
}
