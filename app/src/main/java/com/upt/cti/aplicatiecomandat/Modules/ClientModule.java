package com.upt.cti.aplicatiecomandat.Modules;

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

    public User getNewUser(){
        return newUser;
    }
}
