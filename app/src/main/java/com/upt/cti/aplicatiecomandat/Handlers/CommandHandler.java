package com.upt.cti.aplicatiecomandat.Handlers;

import android.util.Log;

import com.upt.cti.aplicatiecomandat.Constants.Constants;
import com.upt.cti.aplicatiecomandat.DataTypes.Item;
import com.upt.cti.aplicatiecomandat.DataTypes.User;
import com.upt.cti.aplicatiecomandat.Interfaces.ICommandHandler;
import com.upt.cti.aplicatiecomandat.Modules.ClientModule;
import com.upt.cti.aplicatiecomandat.ui.Cart;

import java.util.ArrayList;

public class CommandHandler implements ICommandHandler {
    private static AuthentificationHandler authentificationHandler = new AuthentificationHandler();
    private static DataHandler dataHandler = new DataHandler();
    private static Cart cart = new Cart();

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

    public static boolean logIn(User user) {
        boolean response = authentificationHandler.authentificateClientInDatabase(user);

        return response;
    }

    public static boolean register(User user) {
        boolean response = authentificationHandler.addClientInDatabase(user);

        if(response)
            Log.d(Constants.COMMANDHANDLER_TAG, "User added succesfully!");
        else Log.d(Constants.COMMANDHANDLER_TAG, "User already exists!");

        return response;
    }

    public static void printAllCommands() {}

    public static void removeUser(User user) {
        if(authentificationHandler.removeClientFromDatabase(user))
            Log.d(Constants.COMMANDHANDLER_TAG, "User removed succesfully!");
        else Log.d(Constants.COMMANDHANDLER_TAG, "ERROR: User was not removed!");
    }

    public static void logOut(ClientModule client) {
    }

    public static boolean changePassword(String currentPassword, String newPassword) {
        return authentificationHandler.changePassword(currentPassword, newPassword);
    }

}
