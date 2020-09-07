/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.application.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBconnection{
    private static DBconnection dBConnection;
    private Connection connection;
    
    private DBconnection() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/carrent54","root","ijse");   
    }
    
    public static DBconnection getInstance() throws ClassNotFoundException, SQLException{
        return (null==dBConnection)?(dBConnection= new DBconnection()):(dBConnection);
    }
    
    public Connection getConnection(){return connection;}
    
    
}
