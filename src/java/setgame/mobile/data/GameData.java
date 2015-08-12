/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package setgame.mobile.data;

import setgame.*;

/**
 *
 * @author jyothsna
 */
public class GameData {
    public String id;
    public String desc;
    public int maxPlayers;
    public int maxTime;
    
    public GameData(String id, String desc, int maxPlayers, int maxTime) {
        this.id = id;
        this.desc = desc;
        this.maxPlayers = maxPlayers;
        this.maxTime = maxTime;
    }
}
