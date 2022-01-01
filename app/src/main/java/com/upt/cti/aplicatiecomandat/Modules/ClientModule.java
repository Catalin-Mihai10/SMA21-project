package com.upt.cti.aplicatiecomandat.Modules;

import com.upt.cti.aplicatiecomandat.DataTypes.Item;
import com.upt.cti.aplicatiecomandat.DataTypes.User;
import com.upt.cti.aplicatiecomandat.Handlers.CommandHandler;
import com.upt.cti.aplicatiecomandat.Interfaces.Callback;
import  com.upt.cti.aplicatiecomandat.Interfaces.IClientModule;

public class ClientModule implements IClientModule {
    private final User newUser;

    public ClientModule(String user, String password) {
        newUser = new User(user, password);
    }

    @Override
    public void addToCart(Item item) {

        boolean response = CommandHandler.addToCart(item);

        if(response) System.out.println("Item added to cart successfully!");
        else System.out.println("Item was not added to cart!");
    }

    @Override
    public void removeFromCart(Item item) {

        boolean response = CommandHandler.removeFromCart(item);

        if(response) System.out.println("Item removed from cart successfully!");
        else System.out.println("Item was not removed from cart!");
    }

    @Override
    public void submitCommand() {

        boolean response = CommandHandler.submitCommand(this);

        if(response) System.out.println("Command submitted successfully!");
        else System.out.println("Command was not submitted!");
    }

    @Override
    public void logIn(Callback<Boolean> startMainActivity) {
        CommandHandler.logIn(newUser, data -> {
            if(data) startMainActivity.callback(true);
        });
    }

    @Override
    public void register(Callback<Boolean> startMainActivity) {
        CommandHandler.register(newUser, data -> {
           if(data) startMainActivity.callback(true);
        });
    }

    @Override
    public void printAllCommands() { CommandHandler.printAllCommands(); }

    @Override
    public void removeUser() { CommandHandler.removeUser(newUser); }

    @Override
    public void logOut() { CommandHandler.logOut(this); }

    @Override
    public void changePassword(String currentPassword, String newPassword) {

        String passwordConvention = "Has to be 8 letters long and must contain at least 1 number,1 capital Letter and 1 special character";
        boolean response = CommandHandler.changePassword(currentPassword, newPassword);

        if(response) System.out.println("Password changed successfully!");
        else System.out.println("Password does not respect convention: \n" + passwordConvention);

    }

    @Override
    public void commandResponse(boolean response) {
        if(response) System.out.println("Command successfully registered!");
        else System.out.println("ERROR: Command not registered");
    }
}
