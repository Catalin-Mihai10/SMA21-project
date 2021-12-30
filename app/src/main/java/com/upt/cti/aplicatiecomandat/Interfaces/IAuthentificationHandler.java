package com.upt.cti.aplicatiecomandat.Interfaces;

public interface IAuthentificationHandler {

    public boolean verifyClientInDatabase(String user, String password);
    public boolean addClientInDatabase(String user, String password);
    public boolean removeClientFromDatabase(String user, String password);
    public void requestDataFromDatabase();
    public boolean changePassword(String currentPassword, String newPassword);
}
