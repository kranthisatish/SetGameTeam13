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
public class DAOFactory {
    public static UserDataDAO getUserDataDAO()
    {
	UserDataDAO userDataDAO = new UserDataDAOImpl();
	return userDataDAO;
    }
}
