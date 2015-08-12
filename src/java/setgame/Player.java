/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package setgame;

import java.util.ArrayList;

/**
 *
 * @author jyothsna
 */
public class Player {
    private String id;
    private Game game = null;
    private int noOfSets = 0;
    private int current_index = 0;
    private static final int NO_OF_CARDS = 81;
    
    Player(String id) {
        this.id = id;
    }
    
    public void joinGame(Game game) {
        this.game = game;
        current_index = 0;
        this.game.joinPlayer(this);
    }
    
    public void leaveGame() {
        if (this.game !=null) {
            this.game.leavePlayer(this);
            this.game = null;
        }
        current_index = NO_OF_CARDS;
        noOfSets = 0;

    }
    
    public void updateSets() {
        this.noOfSets++;
    }
    
    public ArrayList<Card> getCards(int num) {
        System.out.println("Player getCards: current index: " + current_index + " num:" + num);
        ArrayList<Card> cards = game.getCards(current_index, num);
        current_index += num;
        return cards;
    }
    
    public Game getGame() {
        return game;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @return the no_of_sets
     */
    public int getNoOfSets() {
        return noOfSets;
    }
    
}
