/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.application.Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import lk.ijse.application.DB.DBconnection;


public class HireController {

    public ArrayList<String> getAllHire() throws ClassNotFoundException, SQLException {
         ResultSet set = DBconnection.getInstance().getConnection().prepareStatement("SELECT Hire from Hire_type").executeQuery();
         ArrayList<String> list= new ArrayList<>();
        while(set.next()){
            list.add(set.getString(1));
     
        }
        return list;
    }
    
}
