/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.league.dto;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class Team {
    
    private int id;
    private String teamName;
    private List<Player> players;
    private Player player;

    public Team() {
        this.players = new ArrayList();
    }
    

    public int getId() {
        return id;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
    
   public void addPlayerObject(Player player)  {
       players.add(player);
    }

    public Player getPlayerObj() {
        return player;
    }


   
   
}
