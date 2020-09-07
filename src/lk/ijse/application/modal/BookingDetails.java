/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.application.modal;


public class BookingDetails {
    private String Fullname;
    private String NIC;
    private String CarNumber;
    private String Drivername;
    private String Hiretype;
    private String Advance;
    private String Fullpayment;
    private String date;
    private String id;

    public BookingDetails() {
    }

    public BookingDetails(String Fullname, String NIC,String CarNumber, String Drivername, String Hiretype, String Advance, String Fullpayment, String date,String id) {
        this.Fullname = Fullname;
        this.NIC = NIC;
        this.CarNumber = CarNumber;
        this.Drivername = Drivername;
        this.Hiretype = Hiretype;
        this.Advance = Advance;
        this.Fullpayment = Fullpayment;
        this.date = date;
        this.id=id;
    }

    public String getFullname() {
        return Fullname;
    }

    public void setFullname(String Fullname) {
        this.Fullname = Fullname;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public String getCarNumber() {
        return CarNumber;
    }

    public void setCarNumber(String CarNumber) {
        this.CarNumber = CarNumber;
    }

    public String getDrivername() {
        return Drivername;
    }

    public void setDrivername(String Drivername) {
        this.Drivername = Drivername;
    }

    public String getHiretype() {
        return Hiretype;
    }

    public void setHiretype(String Hiretype) {
        this.Hiretype = Hiretype;
    }

    public String getAdvance() {
        return Advance;
    }

    public void setAdvance(String Advance) {
        this.Advance = Advance;
    }

    public String getFullpayment() {
        return Fullpayment;
    }

    public void setFullpayment(String Fullpayment) {
        this.Fullpayment = Fullpayment;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "BookingDetails{" + "Fullname=" + Fullname + ", NIC=" + NIC + ", CarNumber=" + CarNumber + ", Drivername=" + Drivername + ", Hiretype=" + Hiretype + ", Advance=" + Advance + ", Fullpayment=" + Fullpayment + ", date=" + date + ", id=" + id + '}';
    }

   
    
    
}
