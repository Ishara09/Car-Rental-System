/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.application.Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import lk.ijse.application.DB.DBconnection;


public class DriverController {

    public ArrayList<String> getAlldrivers() throws ClassNotFoundException, SQLException{
        ResultSet set = DBconnection.getInstance().getConnection().prepareStatement("SELECT * from Additiona_driver").executeQuery();
         ArrayList<String> list= new ArrayList<>();
        while(set.next()){
            list.add(set.getString(1));
        }
        return list;
    }

    public boolean deleteDriver(String name) throws ClassNotFoundException, SQLException {
        Connection conn = DBconnection.getInstance().getConnection();
        PreparedStatement pre = conn.prepareStatement("DELETE FROM additiona_driver WHERE d_Name = '"+name+"'");
        
        
        return pre.executeUpdate()>0;
    }
    
}
