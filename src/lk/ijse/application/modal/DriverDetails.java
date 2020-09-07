/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.application.modal;


public class DriverDetails {
    private String Driver;
    private String number;

    public DriverDetails() {
    }

    public DriverDetails(String Driver, String number) {
        this.Driver = Driver;
        this.number = number;
    }

    public String getDriver() {
        return Driver;
    }

    public void setDriver(String Driver) {
        this.Driver = Driver;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "DriverDetails{" + "Driver=" + Driver + ", number=" + number + '}';
    }

   
    
    
}
