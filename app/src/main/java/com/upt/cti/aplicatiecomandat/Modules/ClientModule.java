package com.upt.cti.aplicatiecomandat.Modules;

import com.upt.cti.aplicatiecomandat.Handlers.CommandHandler;
import  com.upt.cti.aplicatiecomandat.Interfaces.IClientModule;

public class ClientModule implements IClientModule {
    private String user;
    private String password;

    public ClientModule(String user, String password) {
        this.user = user;
        this.password = password;

        register();
    }

    @Override
    public boolean addToCart() { return CommandHandler.addToCart(); }

    @Override
    public boolean removeFromCart() {
        return CommandHandler.removeFromCart();
    }

    @Override
    public boolean submitCommand() {
        return CommandHandler.submitCommand();
    }

    @Override
    public void logIn(String user, String password) { CommandHandler.logIn(user, password); }

    private void register() { CommandHandler.register(this); }

    @Override
    public void printAllCommands() { CommandHandler.printAllCommands(); }

    @Override
    public void removeUser() { CommandHandler.removeUser(this); }

    @Override
    public void logOut() { CommandHandler.logOut(); }

    @Override
    public void changePassword(String newPassword) { CommandHandler.changePassword(newPassword); }

    @Override
    public String getUser() {
        return this.user;
    }

    @Override
    public String getPassword() {
        return this.password;
    }
}
