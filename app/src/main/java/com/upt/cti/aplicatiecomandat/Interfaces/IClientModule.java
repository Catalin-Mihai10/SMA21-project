package com.upt.cti.aplicatiecomandat.Interfaces;

import com.upt.cti.aplicatiecomandat.DataTypes.Item;

public interface IClientModule {

    void addToCart(Item item);
    void removeFromCart(Item item);
    void submitCommand();
    void logIn(Callback<Boolean> callback);
    void register(Callback<Boolean> callback);
    void printAllCommands();
    void removeUser();
    void logOut();
    void changePassword(String currentPassword, String newPassword);
    void commandResponse(boolean response);
}
