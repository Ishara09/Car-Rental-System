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
import java.util.List;
import lk.ijse.application.DB.DBconnection;
import lk.ijse.application.modal.BookingDetails;
import lk.ijse.application.modal.DriverDetails;
import lk.ijse.application.modal.VehicleDetails;


public class SubController {

    public List<DriverDetails> getDrivers() throws SQLException, ClassNotFoundException{
        Connection conn = DBconnection.getInstance().getConnection();
        ResultSet set = conn.prepareStatement("Select * from additiona_driver").executeQuery();
        
         List<DriverDetails> tempList = new ArrayList();
            while(set.next()){
                tempList.add(new DriverDetails(
                       
                 set.getString(1),
                 set.getString(2)
                
                 ));
            }
            return tempList;
    }

    public List<VehicleDetails>  getVehicles() throws ClassNotFoundException, SQLException {
        Connection conn = DBconnection.getInstance().getConnection();
        ResultSet set = conn.prepareStatement("Select * from vehicle_no").executeQuery();
        
        List<VehicleDetails> tempList = new ArrayList();
            while(set.next()){
                tempList.add(new VehicleDetails(
                       
                 set.getString(1),
                 set.getString(2)
                
                 ));
     
    }
    return tempList;
}

    public Boolean saveAdditionVehicle(VehicleDetails v1) throws ClassNotFoundException, SQLException {
         Connection conn = DBconnection.getInstance().getConnection();
        PreparedStatement prepareStatement = conn.prepareStatement("insert into vehicle_no values(?,?)");
        
        prepareStatement.setObject(1, v1.getNo());
        prepareStatement.setObject(2, v1.getVehiclename());
        
        
        return prepareStatement.executeUpdate()>0;
        
    }

    public boolean saveAdditionalDrivers(DriverDetails d1) throws ClassNotFoundException, SQLException {
         Connection conn = DBconnection.getInstance().getConnection();
        PreparedStatement prepareStatement = conn.prepareStatement("insert into additiona_driver values(?,?)");
        
         prepareStatement.setObject(1, d1.getDriver());
         prepareStatement.setObject(2, d1.getNumber());
        
        
        return prepareStatement.executeUpdate()>0;
    }

    public boolean deleteDriver(String name) throws ClassNotFoundException, SQLException {
         Connection conn = DBconnection.getInstance().getConnection();
        PreparedStatement pre = conn.prepareStatement("DELETE FROM additiona_driver WHERE d_Name = '"+name+"'");
        
        
        return pre.executeUpdate()>0;
    }

    public boolean deleteVehicle(String no) throws ClassNotFoundException, SQLException {
        Connection conn = DBconnection.getInstance().getConnection();
        PreparedStatement pre = conn.prepareStatement("DELETE FROM vehicle_no WHERE Car_No = '"+no+"'");
        
        
        return pre.executeUpdate()>0;
    }
}
