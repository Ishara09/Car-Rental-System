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

public class BookingController {

    public boolean saveBooking(BookingDetails b1) throws ClassNotFoundException, SQLException {
         Connection conn = DBconnection.getInstance().getConnection();
        PreparedStatement pre = conn.prepareStatement("insert into Booking_all (Customer_name,Car_No,d_Name,Hire,Advanced_paymet,FULL,NIC,bc_id,Vehical_outDate)"
                + "values(?,?,?,?,?,?,?,?,?)");
        
        
        
        pre.setObject(1, b1.getFullname());
        pre.setString(2, b1.getCarNumber());
        //pre.setString(3, b1.getDate());
        pre.setString(3, b1.getDrivername());
        pre.setString(4, b1.getHiretype());
        pre.setString(5, b1.getAdvance());
        pre.setString(6, b1.getFullpayment());
        pre.setString(7, b1.getNIC());
        pre.setString(8, b1.getId());
        pre.setString(9, b1.getDate());
       if(pre.executeUpdate()>0){
        PreparedStatement pre1=conn.prepareStatement("insert into bc_id (ID) values(?)");
        pre1.setString(1, b1.getId());
        
        if(pre1.executeUpdate()>0){
             PreparedStatement pre2=conn.prepareStatement("DELETE FROM vehicle_no WHERE Car_No ='"+b1.getCarNumber() +"' ");
             
            return pre2.executeUpdate()>0;
                 
                
       }else{
            return false;
        }
    
    }else{
          return false; 
       }
    }

    public List<BookingDetails> getPendingPay() throws ClassNotFoundException, SQLException {
        Connection conn = DBconnection.getInstance().getConnection();
        ResultSet set = conn.prepareStatement("Select * from Booking_all where FULL = '' ORDER BY Vehical_outDate DESC").executeQuery();
         List<BookingDetails> tempList = new ArrayList();
            while(set.next()){
                tempList.add(new BookingDetails(
                       
                 set.getString(2),
                 set.getString(9),
                 set.getString(3),
                 set.getString(5),
                 set.getString(6),
                 set.getString(7),
                 set.getString(8),
                 set.getString(4),
                 set.getString(10)
                 ));
            }
            return tempList;
    }

    public boolean deleteBooking(String trim) throws ClassNotFoundException, SQLException {
        Connection conn = DBconnection.getInstance().getConnection();
        PreparedStatement pre = conn.prepareStatement("delete from Booking_all where bc_ID = +'"+trim+"'");
        if(pre.executeUpdate()>0){
        PreparedStatement pre1 = conn.prepareStatement("delete from Customer where bc_ID = +'"+trim+"'");
        
         if(pre1.executeUpdate()>0){
        PreparedStatement pre2 = conn.prepareStatement("delete from bc_id where ID = +'"+trim+"'");   
        return pre2.executeUpdate()>0;
        }
        }else{
            return false;
        }
        return false;
    }

    public String getID() throws SQLException, ClassNotFoundException {
        ResultSet set=DBconnection.getInstance().getConnection().prepareStatement(""
                + "SELECT ID FROM BC_ID ORDER BY ID DESC LIMIT 1").executeQuery();
        
         if(set.next()){
            String tempId=set.getString(1);
            String[] arr = tempId.split("BC");
            int id=Integer.parseInt(arr[1]);
            id+=1;
            if(id<10){
                return "BC00"+id;
            }else if(id<100){
                return "BC0"+id;
            }else{
                return "BC"+id;
            }
        }else{
            return "BC001";
        }
}

    public BookingDetails getdetails(String trim) throws ClassNotFoundException, SQLException {
        Connection conn = DBconnection.getInstance().getConnection();
        ResultSet set = conn.prepareStatement("Select * from Booking_all where bc_id = +'"+trim+"'").executeQuery();
        
         if (set.next()) {
            return new BookingDetails(
                 set.getString(2),
                 set.getString(9),
                 set.getString(3),
                 set.getString(5),
                 set.getString(6),
                 set.getString(7),
                 set.getString(8),
                 set.getString(4),
                 set.getString(10)
                   
            );   
            }
        return null;
    }

    public boolean update(String Vid, BookingDetails b1) throws SQLException, ClassNotFoundException{
         Connection conn = DBconnection.getInstance().getConnection();
       PreparedStatement pre = conn.prepareStatement("update Booking_all set Customer_name = ? ,Car_No =? ,d_Name = ?,"
               + "Hire =?,Advanced_paymet =? , NIC = ? ,Vehical_outDate =? where bc_id='"+Vid+"'");
        pre.setObject(1,b1.getFullname());
        pre.setString(2,b1.getCarNumber() );
        pre.setString(3,b1.getDrivername());
        pre.setString(4,b1.getHiretype());
        pre.setString(5,b1.getAdvance());
        pre.setString(6,b1.getNIC());
        pre.setString(7,b1.getDate());
        
        return pre.executeUpdate()>0;
    }

    public int getcount() throws ClassNotFoundException, SQLException {
        Connection conn = DBconnection.getInstance().getConnection();
        ResultSet set = conn.prepareStatement("select count(bc_id) from Booking_all").executeQuery();
        
        
        if (set.next()) {
            return set.getInt(1);
        }
         return 0;
    }

    public int pendingCount() throws SQLException, ClassNotFoundException{
        Connection conn = DBconnection.getInstance().getConnection();
        ResultSet set = conn.prepareStatement("select count(bc_id) from Booking_all where FULL =''").executeQuery();
        
        if (set.next()) {
            return set.getInt(1);
        }
         return 0;
    }

    public int getAllearn() throws ClassNotFoundException, SQLException {
         Connection conn = DBconnection.getInstance().getConnection();
         ResultSet set = conn.prepareStatement("select SUM(full_pay) from Full_payment").executeQuery();
         
          if (set.next()) {
            return set.getInt(1);
        }
         return 0;
    }

    public BookingDetails getPaymentDetail(String bbid) throws ClassNotFoundException, SQLException {
        Connection conn = DBconnection.getInstance().getConnection();
        ResultSet set = conn.prepareStatement("Select * from booking_all where bc_ID = '"+bbid+"'").executeQuery();
         if (set.next()) {
            return new BookingDetails(
                 set.getString(2),
                 set.getString(9),
                 set.getString(3),
                 set.getString(5),
                 set.getString(6),
                 set.getString(7),
                 set.getString(8),
                 set.getString(4),
                 set.getString(10)
                   
            );   
            }
        return null;
        
    }
}
