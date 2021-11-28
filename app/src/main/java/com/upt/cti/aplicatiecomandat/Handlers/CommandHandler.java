package com.upt.cti.aplicatiecomandat.Handlers;

import com.upt.cti.aplicatiecomandat.Interfaces.ICommandHandler;
import com.upt.cti.aplicatiecomandat.Modules.ClientModule;

import java.util.ArrayList;

public class CommandHandler implements ICommandHandler {
    private static ArrayList<ClientModule> clientModulesList;
    private static AuthentificationHandler authentificationHandler;
    private static DataHandler dataHandler;

    public CommandHandler(){
        clientModulesList = new ArrayList<>();
        authentificationHandler = new AuthentificationHandler();
        dataHandler = new DataHandler();
    }

    public static boolean addToCart() {
        return false;
    }

    public static boolean removeFromCart() {
        return false;
    }

    public static boolean submitCommand() {
         dataHandler.proccesItemData();
         return true;
    }

    public static void logIn(String user, String password) { authentificationHandler.verifyClientInDatabase(user, password); }

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

    public static void logOut() {}

    public static void changePassword(String password) {}

    private static boolean doesUserExist(ClientModule clientIterator, ClientModule client){
        if(clientIterator.getUser().equals(client.getUser())) return true;
        return false;
    }

}
