/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.week1projects;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class GameBotApp {

    public static void main(String[] args) {

        ConsoleIO ci = new ConsoleIO();

        Game f = new FactorizerObjects();
        Game ic = new Console();
        Game ls = new LuckySevensApp();
        Game rps = new RPS();
        Game bj = new BlackJack();

        List<Game> games = new ArrayList();

        games.add(f);
        games.add(ic);
        games.add(ls);
        games.add(rps);
        games.add(bj);

        boolean stillPlaying = true;

        while (stillPlaying) {

            for (Game myGame : games) {
                ci.displayString("Game name: " + myGame.getName());
            }

            String input = ci.getWord("Please enter a game name to play. Or type exit to exit");
            
            for(Game myGame : games)   {
                if(input.equals(myGame.getName()))    {
                   myGame.run();
                }
            }
            
            if("exit".equals(input)) {
                stillPlaying=false;
                       
            }

        }

    }
}
