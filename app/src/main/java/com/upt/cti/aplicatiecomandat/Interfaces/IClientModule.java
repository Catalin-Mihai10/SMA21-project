package com.upt.cti.aplicatiecomandat.Interfaces;

import com.upt.cti.aplicatiecomandat.DataTypes.Item;

public interface IClientModule {

    public void addToCart(Item item);
    public void removeFromCart(Item item);
    public void submitCommand();
    public void logIn();
    public void printAllCommands();
    public void removeUser();
    public void logOut();
    public void changePassword(String password);
    public String getUser();
    public String getPassword();
    public void commandResponse(boolean response);
}
