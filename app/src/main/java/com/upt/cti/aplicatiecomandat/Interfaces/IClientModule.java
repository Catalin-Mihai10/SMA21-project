package com.upt.cti.aplicatiecomandat.Interfaces;

import com.upt.cti.aplicatiecomandat.DataTypes.Item;

public interface IClientModule {

    public void addToCart(Item item);
    public void removeFromCart(Item item);
    public void submitCommand();
    public boolean logIn();
    public void printAllCommands();
    public void removeUser();
    public void logOut();
    public void changePassword(String currentPassword, String newPassword);
    public String getUser();
    public String getPassword();
    public void commandResponse(boolean response);
}
