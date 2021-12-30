package com.upt.cti.aplicatiecomandat.DataTypes;

import java.util.Random;

public class User {
    private String username;
    private String password;
    private int userID;

    public User(){}

    public User(String username, String password){
        this.username = username;
        this.password = password;
        userID = generateUserID();
    }

    private int generateUserID(){
        Random rnd = new Random();
        return rnd.nextInt(999999);
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public String getUserID(){
        return String.valueOf(userID);
    }
}
