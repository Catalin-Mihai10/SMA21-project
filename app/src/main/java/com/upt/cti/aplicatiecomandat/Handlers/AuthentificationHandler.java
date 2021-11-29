package com.upt.cti.aplicatiecomandat.Handlers;

import com.upt.cti.aplicatiecomandat.Interfaces.IAuthentificationHandler;

public class AuthentificationHandler implements IAuthentificationHandler{

    public AuthentificationHandler(){}

    @Override
    public boolean verifyClientInDatabase(String user, String password) { return false; }

    @Override
    public boolean addClientInDatabase(String user, String password) { return false; }

    @Override
    public boolean removeClientFromDatabase(String user, String password) { return false; }

    @Override
    public void requestDataFromDatabase() {}

    @Override
    public boolean changePassword(String password) {
        return false;
    }
}
