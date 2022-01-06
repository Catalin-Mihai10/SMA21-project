package com.upt.cti.aplicatiecomandat.DataTypes;

public class PurchaseInformation {
    private final String user;
    private String phone;
    private String address;
    private String country;
    private String city;

    public PurchaseInformation(String user, String phone, String address, String country, String city){
        this.user = user;
        this.phone = phone;
        this.address = address;
        this.country = country;
        this.city = city;
    }


    public void setPhone(String phone){
        this.phone = phone;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public void setCountry(String country){
        this.country = country;
    }

    public void setCity(String city){
        this.city = city;
    }

    public String getUser(){
        return user;
    }

    public String getPhone(){
        return phone;
    }

    public String getAddress(){
        return address;
    }

    public String getCountry(){
        return country;
    }

    public String getCity(){
        return city;
    }
}
