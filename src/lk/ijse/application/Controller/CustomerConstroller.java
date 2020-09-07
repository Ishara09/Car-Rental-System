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
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.ijse.application.DB.DBconnection;
import lk.ijse.application.modal.Customer;

/**
 *
 * @author Mora
 */
public class CustomerConstroller {

    public boolean saveCustomer(Customer c1) throws SQLException{
       Connection connection = null;
        try {
       connection = DBconnection.getInstance().getConnection();
       connection.setAutoCommit(false);
        PreparedStatement pre;
        
            pre = connection.prepareStatement("insert into Customer(cus_name,cus_NIC,cus_Address,cus_Number,bc_id)"
                    + " values(?,?,?,?,?)");
        
        pre.setObject(1, c1.getName());
        pre.setObject(2, c1.getNic());
        pre.setObject(3, c1.getAddress());
        pre.setObject(4, c1.getNumber());
        pre.setObject(5, c1.getId());
        
        Boolean issaved = pre.executeUpdate()>0;
        
        if (issaved) {
           PreparedStatement prepareStatement = connection.prepareStatement("insert into booking (Customer_id , Booking_id) values (?,?)");
            prepareStatement.setString(1, c1.getName());
            prepareStatement.setString(2, c1.getId());
            
            boolean isSaved1 = prepareStatement.executeUpdate()>0;
            
            if (isSaved1) {
                connection.commit();
                return true;
            }else{
                connection.rollback();
                return false;
            }
            
        }else{
            connection.rollback();
            return false;
            
        }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerConstroller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomerConstroller.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            connection.setAutoCommit(true);
        }
        return false;
    }

    public Customer getdetails(String trim) throws ClassNotFoundException, SQLException {
         Connection conn = DBconnection.getInstance().getConnection();
        ResultSet set = conn.prepareStatement("Select * from Customer where bc_id = +'"+trim+"'").executeQuery();
        
         if (set.next()) {
            return new Customer(
                 set.getString(2),
                 set.getString(3),
                 set.getString(4),
                 set.getString(5),
                 set.getString(6)
                  
            );   
            }
        return null;
        
    }

    public boolean update(String Vid, Customer c1) throws ClassNotFoundException, SQLException{
        Connection conn = DBconnection.getInstance().getConnection();
         PreparedStatement pre = conn.prepareStatement("update Customer set Cus_Name = ?, cus_Address=? "
                 + ",cus_Number =? , cus_NIC = ? where bc_id ='"+Vid+"'");
        pre.setString(1,c1.getName());
        pre.setString(2, c1.getAddress());
        pre.setString(3, c1.getNumber());
        pre.setString(4, c1.getNic());
        return pre.executeUpdate()>0;
        
    }

    public int getcount() throws ClassNotFoundException, SQLException {
         Connection conn = DBconnection.getInstance().getConnection();
         
         ResultSet set = conn.prepareStatement("SELECT COUNT(DISTINCT cus_name) FROM customer;").executeQuery();
       
       
         if (set.next()) {
            return set.getInt(1);
        }
         return 0;
    }
    
}
