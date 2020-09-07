/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.application.modal;


public class VehicleDetails {
    private String Vehiclename;
    private String No;

    public VehicleDetails() {
    }

    public VehicleDetails(String Vehiclename, String No) {
        this.Vehiclename = Vehiclename;
        this.No = No;
    }

    public String getVehiclename() {
        return Vehiclename;
    }

    public void setVehiclename(String Vehiclename) {
        this.Vehiclename = Vehiclename;
    }

    public String getNo() {
        return No;
    }

    public void setNo(String No) {
        this.No = No;
    }

    @Override
    public String toString() {
        return "VehicleDetails{" + "Vehiclename=" + Vehiclename + ", No=" + No + '}';
    }
   
}
