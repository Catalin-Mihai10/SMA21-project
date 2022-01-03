package com.upt.cti.aplicatiecomandat.Handlers;

import android.util.Log;

import com.upt.cti.aplicatiecomandat.Constants.Constants;
import com.upt.cti.aplicatiecomandat.DataTypes.Item;
import com.upt.cti.aplicatiecomandat.DataTypes.User;
import com.upt.cti.aplicatiecomandat.Interfaces.Callback;
import com.upt.cti.aplicatiecomandat.Interfaces.ICommandHandler;
import com.upt.cti.aplicatiecomandat.Modules.ClientModule;
import com.upt.cti.aplicatiecomandat.ui.Cart;

import java.util.List;

public class CommandHandler implements ICommandHandler {
    private final static AuthenticationHandler authenticationHandler = new AuthenticationHandler();
    private final static DataHandler dataHandler = new DataHandler();
    private final static Cart cart = new Cart();

    public static boolean addToCart(Item item) {
        return cart.addItemToCart(item);
    }

    public static boolean removeFromCart(Item item) {
        cart.removeItemFromCart(item);
        return false;
    }

    public static List<Item> getCart(){
        return cart.getCart();
    }

    public static boolean submitCommand(ClientModule client) {
         dataHandler.proccesItemData(cart);
         dataHandler.proccesUserData(client);
         cart.submitItemsOnCommand();
         return true;
    }

    public static void logIn(User user, Callback<Boolean> startMainActivity) {
        authenticationHandler.checkIfClientIsInDatabase(user, data -> {
            if(data) startMainActivity.callback(true);
        });
    }

    public static void register(User user, Callback<Boolean> checkIfUserAlreadyExists) {
        authenticationHandler.addClientInDatabase(user, data -> {
             if(data) {
                 checkIfUserAlreadyExists.callback(true);
                 Log.d(Constants.COMMAND_HANDLER_TAG, "User added successfully!");
             }
             else{
                 Log.d(Constants.COMMAND_HANDLER_TAG, "User already exists!");
             }
         });
    }

    public static void printAllCommands() {}

    public static void removeUser(User user) {
        if(authenticationHandler.removeClientFromDatabase(user))
            Log.d(Constants.COMMAND_HANDLER_TAG, "User removed successfully!");
        else Log.d(Constants.COMMAND_HANDLER_TAG, "ERROR: User was not removed!");
    }

    public static void logOut(ClientModule client) {

    }

    public static boolean changePassword(String currentPassword, String newPassword) {
        return authenticationHandler.changePassword(currentPassword, newPassword);
    }

}
