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
import lk.ijse.application.modal.PaymentDet;


public class PaymentController {

    public Boolean SavePayment(PaymentDet p1) throws ClassNotFoundException, SQLException {
        Connection conn = DBconnection.getInstance().getConnection();
        PreparedStatement pre = conn.prepareStatement("insert into full_payment (id,nic,name,out_date,int_date,day_rs,km_rs,advance,full_pay,carco,km,day,free)"
                + "values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
        pre.setString(1, p1.getBooking_id());
        pre.setString(2, p1.getNic());
        pre.setString(3, p1.getName());
        pre.setString(4, p1.getOutdate());
        pre.setString(5, p1.getIndate());
        pre.setString(6, p1.getDch());
        pre.setString(7, p1.getKm());
        pre.setString(8, p1.getAdvance());
        pre.setString(9, p1.getFullpayment());
        pre.setString(10, p1.getCarno());
        pre.setString(11, p1.getHkm());
        pre.setString(12, p1.getHdch());
        pre.setString(13, p1.getFree());
                

       if(pre.executeUpdate()>0){
            PreparedStatement prepareStatement = conn.prepareStatement("update Booking_all set FULL =? "
                    + "where bc_id ='"+p1.getBooking_id()+"'");
            prepareStatement.setString(1, p1.getFullpayment());
            return prepareStatement.executeUpdate()>0;
       }else{
           return false;
       }
    }

    public List<PaymentDet> getAllPayements() throws ClassNotFoundException, SQLException {
        Connection conn = DBconnection.getInstance().getConnection();
        ResultSet set = conn.prepareStatement("Select * from full_payment Order by   name asc").executeQuery();
        List<PaymentDet> tempList = new ArrayList();
            while(set.next()){
                tempList.add(new PaymentDet(
                       
                 set.getString(1),
                 set.getString(2),
                 set.getString(3),
                 set.getString(4),
                 set.getString(5),
                 set.getString(11),
                 set.getString(7),
                 set.getString(12),
                 set.getString(6),
                 set.getString(8),
                 set.getString(9),
                 set.getString(10),
                 set.getString(13)
                 ));
            }
            return tempList;
    }

    public boolean updatePayment(PaymentDet p1) throws SQLException, ClassNotFoundException {
         Connection conn = DBconnection.getInstance().getConnection();
        PreparedStatement prepareStatement = conn.prepareStatement("update full_payment set nic=? , name = ? ,  out_date=?,int_date=?,day_rs=?,"
                + "km_rs=?,advance=?,full_pay=?,carco=? ,free=? ,Km=?,day=? where id ='"+p1.getBooking_id()+"'");
         prepareStatement.setString(1, p1.getNic());
         prepareStatement.setString(2, p1.getName());
         prepareStatement.setString(3, p1.getOutdate());
         prepareStatement.setString(4, p1.getIndate());
         prepareStatement.setString(5, p1.getDch());
         prepareStatement.setString(6, p1.getKm());
         prepareStatement.setString(7, p1.getAdvance());
         prepareStatement.setString(8, p1.getFullpayment());
         prepareStatement.setString(9, p1.getCarno());
         prepareStatement.setString(10, p1.getFree());
         prepareStatement.setString(11, p1.getHkm());
         prepareStatement.setString(12, p1.getHdch());
                 
        
        return prepareStatement.executeUpdate()>0;
    }

    public boolean deletepayment(String id) throws ClassNotFoundException, SQLException {
        Connection conn = DBconnection.getInstance().getConnection();
        PreparedStatement prepareStatement = conn.prepareStatement("delete  from full_payment where id = '"+id+"'");
        
       return prepareStatement.executeUpdate()>0;
        
    }

    
}
