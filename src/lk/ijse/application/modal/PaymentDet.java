/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.application.modal;


public class PaymentDet {
   private String Booking_id;
   private String nic;
   private String name;
   private String outdate;
   private String indate;
   private String hkm;
   private String km;
   private String hdch;
   private String dch;
   private String advance;
   private String fullpayment;
   private String carno;
   private String free;
   
    public PaymentDet() {
    }

    public PaymentDet(String Booking_id, String nic, String name, String outdate, String indate, String hkm, String km, String hdch, String dch, String advance, String fullpayment, String carno,String free) {
        this.Booking_id = Booking_id;
        this.nic = nic;
        this.name = name;
        this.outdate = outdate;
        this.indate = indate;
        this.hkm = hkm;
        this.km = km;
        this.hdch = hdch;
        this.dch = dch;
        this.advance = advance;
        this.fullpayment = fullpayment;
        this.carno = carno;
        this.free = free;
    }

    public String getBooking_id() {
        return Booking_id;
    }

    public void setBooking_id(String Booking_id) {
        this.Booking_id = Booking_id;
    }

    public String getFree() {
        return free;
    }

    public void setFree(String free) {
        this.free = free;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOutdate() {
        return outdate;
    }

    public void setOutdate(String outdate) {
        this.outdate = outdate;
    }

    public String getIndate() {
        return indate;
    }

    public void setIndate(String indate) {
        this.indate = indate;
    }

    public String getHkm() {
        return hkm;
    }

    public void setHkm(String hkm) {
        this.hkm = hkm;
    }

    public String getKm() {
        return km;
    }

    public void setKm(String km) {
        this.km = km;
    }

    public String getHdch() {
        return hdch;
    }

    public void setHdch(String hdch) {
        this.hdch = hdch;
    }

    public String getDch() {
        return dch;
    }

    public void setDch(String dch) {
        this.dch = dch;
    }

    public String getAdvance() {
        return advance;
    }

    public void setAdvance(String advance) {
        this.advance = advance;
    }

    public String getFullpayment() {
        return fullpayment;
    }

    public void setFullpayment(String fullpayment) {
        this.fullpayment = fullpayment;
    }

    public String getCarno() {
        return carno;
    }

    public void setCarno(String carno) {
        this.carno = carno;
    }

    @Override
    public String toString() {
        return "PaymentDet{" + "Booking_id=" + Booking_id + ", nic=" + nic + ", name=" + name + ", outdate=" + outdate + ", indate=" + indate + ", hkm=" + hkm + ", km=" + km + ", hdch=" + hdch + ", dch=" + dch + ", advance=" + advance + ", fullpayment=" + fullpayment + ", carno=" + carno + ", free=" + free + '}';
    }

   
  
}
