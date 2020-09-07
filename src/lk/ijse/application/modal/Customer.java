/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.application.modal;

public class Customer {

private String name;
private String nic;
private String address;
private String number;
private String id;

    public Customer() {
    }

    public Customer(String name, String nic, String address, String number,String id) {
        this.name = name;
        this.nic = nic;
        this.address = address;
        this.number = number;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Customer{" + "name=" + name + ", nic=" + nic + ", address=" + address + ", number=" + number + ", id=" + id + '}';
    }

   

   



    
}
