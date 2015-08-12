/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package setgame.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author jyothsna
 */
public class UserDataDAOImpl implements UserDataDAO {
    private static Connection connection;
    private static Statement statement;
    private static ResultSet rs;
	
    public static void openConnection()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/setgame", "root", "");
            statement = connection.createStatement();
            System.out.println("Database connected");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }
	
    public static void closeConnection()
    {
        try {
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public boolean insertUserData(String userid, String passwd) {
        boolean result = false;
        System.out.println("Insert User Data Called");
        openConnection();
        String query = "INSERT INTO userdata values (\'" + userid + "','" +
                passwd + "')";
        System.out.println("query: " + query);
        try {
            statement.executeUpdate(query);
            String query2 = "SELECT * from userdata";
            rs = statement.executeQuery(query2);
            while(rs.next()) {
                System.out.println("Contents: " + rs.getString("userid") + " " +
                        rs.getString("passwd"));
            }
            result = true;
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        
        return result;
    }
    
    public boolean verifyUserData(String userid, String passwd) {
        boolean result = false;
        System.out.println("Verify User Data Called");
        openConnection();
        String query = "SELECT * from userdata WHERE " + 
                            "userid LIKE \'" + userid + "\' AND " + 
                            "passwd LIKE \'" + passwd + "\'";
        System.out.println("Query: " + query);
        try {
            rs = statement.executeQuery(query);
            if (rs.next()) {
                result = true;
            } else {
                result = false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        
        return result;        
    }
    
}
