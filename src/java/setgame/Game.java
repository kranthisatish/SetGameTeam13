/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package setgame;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author jyothsna
 */
public class Game {
    private String gameId;
    private String gameDesc;
    private int gameMaxPlayers=3;
    private int gameMaxTime=60;
    private int gamePlayers=0;
    private ArrayList<Card> deck;
    private ArrayList<Card> gameDeck = new ArrayList<Card>();
    private ArrayList<Card> face = new ArrayList<>();
    private ArrayList<ArrayList> cardGroups = new ArrayList<>();
    private ArrayList<Player> players = new ArrayList<>();
    private static final int NO_OF_CARDS = 81;
    
    public Game(String gameId, String gameDesc, int gameMaxPlayers, 
            int gameMaxTime, ArrayList<Card> deck) {
        this.gameId = gameId;
        this.gameDesc = gameDesc;
        this.gameMaxPlayers = gameMaxPlayers;
        this.gameMaxTime = gameMaxTime;
        createGameDeck(deck);
    }
    
    public void setDeck(ArrayList<Card> deck) {
        this.deck = deck;
    }
    
    private void createGameDeck(ArrayList<Card> mainDeck) {
        gameDeck.clear();
        for (int idx = 1; idx <= 81; idx++) {
            Random randomGenerator = new Random();
            int randomInt = randomGenerator.nextInt(mainDeck.size());
            Card c = mainDeck.get(randomInt);
            face.add(c);
            mainDeck.remove(c);
            gameDeck.add(c);
        }
        deck = new ArrayList<Card>(gameDeck);
    }
    
    public void generateFaceCards() {
        face.clear();
        System.out.println("Deck Size: " + deck.size());
        for (int idx = 1; idx <= 12; idx++) {
            Random randomGenerator = new Random();
            int randomInt = randomGenerator.nextInt(deck.size());
            Card c = deck.get(randomInt);
            face.add(c);
            deck.remove(c);
        }
    }
    
    public ArrayList<ArrayList> generateCardGroup() {
        return generateCardGroups(1);
    }
    
    public ArrayList<ArrayList> generateCardGroups(int num) {
        ArrayList<Card> cardGroup = new ArrayList<>();
        for (int idx = 1; idx <= num; idx++) {
            for (int i = 1; i <=3 ; i++) {
                Random randomGenerator = new Random();
                int randomInt = randomGenerator.nextInt(deck.size());
                Card c = deck.get(randomInt);
                cardGroup.add(c);
                deck.remove(c);                
            }
            cardGroups.add(cardGroup);
        }
        return cardGroups;
    }
    
    public ArrayList<Card> getFaceCards() {
        return face;
    }

    public ArrayList<Card> getCards(int index, int num) {
        if (index + num - 1 > NO_OF_CARDS) {
            return null;
        }
        return new ArrayList<>(gameDeck.subList(index, index+num));
    }
    
    public void joinPlayer(Player p) {
        if (!players.contains(p)) {
            players.add(p);
        }
    }
    
    public void leavePlayer(Player p) {
        if (players.contains(p)) {
            players.remove(p);
        }
    }
    
    public ArrayList<Player> getPlayers() {
        return players;
    }
    
    /**
     * @return the gameId
     */
    public String getGameId() {
        return gameId;
    }

    /**
     * @return the gameDesc
     */
    public String getGameDesc() {
        return gameDesc;
    }

    /**
     * @return the gameMaxPlayers
     */
    public int getGameMaxPlayers() {
        return gameMaxPlayers;
    }

    /**
     * @return the gameMaxTime
     */
    public int getGameMaxTime() {
        return gameMaxTime;
    }

    /**
     * @return the gamePlayers
     */
    public int getGamePlayers() {
        return gamePlayers;
    }
    
    public boolean isSet(Card c1, Card c2, Card c3) {
        System.out.println("Game isSet: " + c1.getNumber() + " " + c2.getNumber() + " " + c3.getNumber());
        return validateSetFeature(c1.getNumber(), c2.getNumber(), c3.getNumber()) &&
                validateSetFeature(c1.getShape(), c2.getShape(), c3.getShape()) &&
                validateSetFeature(c1.getColor(), c2.getColor(), c3.getColor()) &&
                validateSetFeature(c1.getShade(), c2.getShade(), c3.getShade());
    }
 
    private static boolean validateSetFeature(String s1, String s2, String s3) {
        return (s1.equals(s2) && s2.equals(s3)) ||
                ( !s1.equals(s2) && !s2.equals(s3) && !s3.equals(s1));
    }
    
    private static boolean validateSetFeature(int num1, int num2, int num3) {
        return (num1 == num2) && (num2 == num3) ||
                (num1 != num2) && (num2 != num3) &&
                (num3 != num1);        
    }
    
}
