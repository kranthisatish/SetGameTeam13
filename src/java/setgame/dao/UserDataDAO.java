/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package setgame.dao;

/**
 *
 * @author jyothsna
 */
public interface UserDataDAO {
    public abstract boolean insertUserData(String userid, String passwd);
    public abstract boolean verifyUserData(String userid, String passwd);
}
