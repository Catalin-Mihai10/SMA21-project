package com.upt.cti.aplicatiecomandat.Handlers;

import android.util.Log;

import com.upt.cti.aplicatiecomandat.Constants.Constants;
import com.upt.cti.aplicatiecomandat.DataTypes.Item;
import com.upt.cti.aplicatiecomandat.Interfaces.ICommandHandler;
import com.upt.cti.aplicatiecomandat.Modules.ClientModule;
import com.upt.cti.aplicatiecomandat.ui.Cart;

import java.util.ArrayList;

public class CommandHandler implements ICommandHandler {
    private static AuthentificationHandler authentificationHandler;
    private static DataHandler dataHandler;
    private static Cart cart;

    public CommandHandler(){
        authentificationHandler = new AuthentificationHandler();
        dataHandler = new DataHandler();
        cart = new Cart();
    }

    public static boolean addToCart(Item item) {
        return cart.addItemToCart(item);
    }

    public static boolean removeFromCart(Item item) {
        cart.removeItemFromCart(item);
        return false;
    }

    public static boolean submitCommand(ClientModule client) {
         dataHandler.proccesItemData(cart);
         dataHandler.proccesUserData(client);
         cart.submitItemsOnCommand();
         return true;
    }

    public static boolean logIn(ClientModule client) {
        boolean response = authentificationHandler.verifyClientInDatabase(client.getUser(), client.getPassword());

        return response;
    }

    public static boolean register(ClientModule client) {
        boolean response = authentificationHandler.addClientInDatabase(client.getUser(), client.getPassword());

        if(response)
            Log.d(Constants.COMMANDHANDLER_TAG, "User added succesfully!");
        else Log.d(Constants.COMMANDHANDLER_TAG, "User already exists!");

        return response;
    }

    public static void printAllCommands() {}

    public static void removeUser(ClientModule client) {
        if(authentificationHandler.removeClientFromDatabase(client.getUser(), client.getPassword()))
            Log.d(Constants.COMMANDHANDLER_TAG, "User removed succesfully!");
        else Log.d(Constants.COMMANDHANDLER_TAG, "ERROR: User was not removed!");
    }

    public static void logOut(ClientModule client) {
    }

    public static boolean changePassword(String currentPassword, String newPassword) {
        return authentificationHandler.changePassword(currentPassword, newPassword);
    }

}
