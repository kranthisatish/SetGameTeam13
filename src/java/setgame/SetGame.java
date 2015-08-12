/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package setgame;

import java.io.RandomAccessFile;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import setgame.mobile.data.GameData;

/**
 *
 * @author jyothsna
 */
public class SetGame {
    
    private static SetGame setGame = null;
    private final ArrayList<Game> games = new ArrayList<>();
    private final HashMap<String, Game> gamesMap = new HashMap<>();
    private final HashMap<String, Card> deckMap = new HashMap<>();
    private final HashMap<String, Player> playerMap = new HashMap<>();
    private static final int[] NUMBERS = {1, 2, 3}; 
    private static final String[] SHAPES = { "squiggle", "diamond", "oval"};
    private static final String[] COLORS = {"red", "purple", "green"};
    private static final String[] SHADES = {"solid", "stripe", "blank"};
    
    private SetGame() {
        //singleton - Prevent any new instances to be created
    }
    
    public static SetGame getInstance() {
        if (setGame == null) {
            setGame = new SetGame();
            setGame.createDeck();
        }
        
        return setGame;
    }
    
    public void createGame(String gameId, String gameDesc, int maxPlayers, 
            int maxTime) {
        ArrayList<Card> deck = new ArrayList<>(deckMap.values());
        Game g = new Game(gameId, gameDesc, maxPlayers, maxTime, deck);
        g.generateFaceCards();
        
        gamesMap.put(gameId, g);
    }
    
    private void createDeck() {
        deckMap.clear();
        int imageNum = 0;
        for (String shade : SHADES)
            for (String shape : SHAPES)
                for (String color : COLORS)
                    for (int number : NUMBERS) {
                        imageNum++;
                        String identifier = new DecimalFormat("00").format(imageNum);
                        Card c = new Card(identifier, number, shape, color, shade);
                        deckMap.put(identifier, c);
                    }
    }
    
    public GameImageData getGameImageData(String gameid) {
        Game g = getGameById(gameid);
        ArrayList<Card> faceCards = g.getFaceCards();
        ArrayList<byte[]> imageData = new ArrayList<>();
        System.out.println("In Get Game Data");
        for (Card faceCard : faceCards) {
            String imgPath = "/Users/jyothsna/NetBeansProjects/SetGameService/src/java/setgame/images/" + 
                    faceCard.getIdentifier() + ".gif";
            try {
                RandomAccessFile f = new RandomAccessFile(imgPath, "r");
                byte[] bytes = new byte[(int) f.length()];
                imageData.add(bytes);
                f.read(bytes);
                f.close();
                System.out.println("File found: " + imgPath);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        
        GameImageData giData = new GameImageData();
        giData.gameid = gameid;
        giData.faceImages = imageData;
        
        return giData;
    }
    
    public ArrayList<GamePlayerData> getGamePlayerData(String gameid) {
        /*
        GamePlayerData gpData = new GamePlayerData();
        gpData.playerId = "kranthi123";
        gpData.gameId = "cxxxxx";
        gpData.no_of_sets = 4;
        
        GamePlayerData gpData2 = new GamePlayerData();
        gpData2.playerId = "5jyothsna";
        gpData2.gameId = "cxxxxx";
        gpData2.no_of_sets = 2;
        */
        Game g = gamesMap.get(gameid);
        ArrayList<Player> players = g.getPlayers();
        
        ArrayList<GamePlayerData> gpDataList = new ArrayList<>();
        for (Player player : players) {
            GamePlayerData gpData = new GamePlayerData();
            gpData.playerId = player.getId();
            gpData.no_of_sets = player.getNoOfSets();
            gpDataList.add(gpData);
        }
        
        return gpDataList;
    }
    
    public void createPlayer(String playerId) {
        if (!playerMap.containsKey(playerId)) {
            Player p = new Player(playerId);
            //Player p = new Player("kranthi");
            playerMap.put(playerId, p);            
        }
    }
    
    public void joinGame(String playerId, String gameId) {
        createPlayer(playerId);
        System.out.println("Set Game: Join Game: pid: " + playerId + " gid: " + gameId);
        if (!playerMap.containsKey(playerId)) {
            Player p = new Player(playerId);
            playerMap.put(playerId, p);
        }
        Player p = playerMap.get(playerId);
        Game g = gamesMap.get(gameId);
        p.joinGame(g);
    }
    
    public void leaveGame(String playerId) {
        Player p = playerMap.get(playerId);
        if ( p != null) {
            p.leaveGame();
        }
    }
    
    public boolean isSet(String pid, String c1, String c2, String c3) {
        Player p = playerMap.get(pid);
        Game g = p.getGame();
        System.out.println("Set Game: is Set: " + deckMap.get(c1) +
                " " + deckMap.get(c2) + " " + deckMap.get(c3));
        boolean result = g.isSet(deckMap.get(c1), deckMap.get(c2), deckMap.get(c3));
        
        if (result) {
            p.updateSets();
        }
        
        return result;
    }
    
    public Game getGameById(String gameId) {
        return gamesMap.get(gameId);
    }
    
    public ArrayList<Game> getGameList() {
        return new ArrayList<>(gamesMap.values());
    }

    public ArrayList<GameData> getMobileGameData() {
        ArrayList<GameData> gameDataList = new ArrayList<>();
        for (Game g : gamesMap.values()) {
            GameData gd = new GameData(g.getGameId(), g.getGameDesc(),
                            g.getGameMaxPlayers(), g.getGameMaxTime());
            gameDataList.add(gd);
        }
        
        return gameDataList;
    }
    
    
    public ArrayList<Card> getCards(String playerId, String gameId, int no) {
        System.out.println("Set Game: Get Cards: pid: " + playerId + " gid: " + gameId);
        Player p = playerMap.get(playerId);
        //Game g = gamesMap.get(gameId);

        return p.getCards(no);
    }
    
}
