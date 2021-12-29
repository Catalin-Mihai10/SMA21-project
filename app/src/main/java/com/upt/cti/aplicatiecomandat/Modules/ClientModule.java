package com.upt.cti.aplicatiecomandat.Modules;

import com.upt.cti.aplicatiecomandat.DataTypes.Item;
import com.upt.cti.aplicatiecomandat.Handlers.CommandHandler;
import  com.upt.cti.aplicatiecomandat.Interfaces.IClientModule;

public class ClientModule implements IClientModule {
    private final String user;
    private final String password;

    public ClientModule(String user, String password) {
        this.user = user;
        this.password = password;

    }

    @Override
    public void addToCart(Item item) {

        boolean response = CommandHandler.addToCart(item);

        if(response) System.out.println("Item added to cart succesfully!");
        else System.out.println("Item was not added to cart!");
    }

    @Override
    public void removeFromCart(Item item) {

        boolean response = CommandHandler.removeFromCart(item);

        if(response) System.out.println("Item removed from cart succesfully!");
        else System.out.println("Item was not removed from cart!");
    }

    @Override
    public void submitCommand() {

        boolean response = CommandHandler.submitCommand(this);

        if(response) System.out.println("Command submited succesfully!");
        else System.out.println("Command was not submited!");
    }

    @Override
    public void logIn() { CommandHandler.logIn(this); }

    public void register() { CommandHandler.register(this); }

    @Override
    public void printAllCommands() { CommandHandler.printAllCommands(); }

    @Override
    public void removeUser() { CommandHandler.removeUser(this); }

    @Override
    public void logOut() { CommandHandler.logOut(this); }

    @Override
    public void changePassword(String newPassword) {

        String passwordConvention = "Has to be 8 letters long and must contain at least 1 number,1 capital Letter and 1 special character";
        boolean response = CommandHandler.changePassword(newPassword);

        if(response) System.out.println("Password changed succesfully!");
        else System.out.println("Password does not respect convention: \n" + passwordConvention);

    }

    @Override
    public String getUser() {
        return this.user;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public void commandResponse(boolean response) {
        if(response) System.out.println("Command succefully registered!");
        else System.out.println("ERROR: Command not registered");
    }
}
