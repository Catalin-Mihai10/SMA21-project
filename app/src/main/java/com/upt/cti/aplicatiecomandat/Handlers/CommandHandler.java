package com.upt.cti.aplicatiecomandat.Handlers;

import com.upt.cti.aplicatiecomandat.DataTypes.Item;
import com.upt.cti.aplicatiecomandat.Interfaces.ICommandHandler;
import com.upt.cti.aplicatiecomandat.Modules.ClientModule;
import com.upt.cti.aplicatiecomandat.ui.Cart;

import java.util.ArrayList;

public class CommandHandler implements ICommandHandler {
    private static ArrayList<ClientModule> clientModulesList;
    private static AuthentificationHandler authentificationHandler;
    private static DataHandler dataHandler;
    private static Cart cart;

    public CommandHandler(){
        clientModulesList = new ArrayList<>();
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

    public static void logIn(String user, String password) {
        boolean response = authentificationHandler.verifyClientInDatabase(user, password);

        if(!response) System.out.println("User or password is incorrect");
    }

    public static void register(ClientModule client) {
        authentificationHandler.addClientInDatabase(client.getUser(), client.getPassword());

        for(ClientModule clientIterator : clientModulesList)
            if(!doesUserExist(clientIterator, client)) clientModulesList.add(client);
    }

    public static void printAllCommands() {}

    public static void removeUser(ClientModule client) {
        authentificationHandler.removeClientFromDatabase(client.getUser(), client.getPassword());

        for(ClientModule clientIterator : clientModulesList)
            if(doesUserExist(clientIterator,client)) clientModulesList.remove(clientIterator);

    }

    public static void logOut(ClientModule client) {
        for(ClientModule clientIterator : clientModulesList)
            if(clientIterator.getUser().equals(client.getUser())) clientModulesList.remove(clientIterator);
    }

    public static boolean changePassword(String password) {
        return authentificationHandler.changePassword(password);
    }

    private static boolean doesUserExist(ClientModule clientIterator, ClientModule client){
        if(clientIterator.getUser().equals(client.getUser())) return true;
        return false;
    }

}
