package com.upt.cti.aplicatiecomandat.Interfaces;

import com.upt.cti.aplicatiecomandat.DataTypes.User;

public interface IAuthentificationHandler {

    public boolean verifyClientInDatabase(User user);
    public boolean authentificateClientInDatabase(User user);
    public boolean addClientInDatabase(User user);
    public boolean removeClientFromDatabase(User user);
    public void requestDataFromDatabase();
    public boolean changePassword(String currentPassword, String newPassword);
}
