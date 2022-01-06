package com.upt.cti.aplicatiecomandat.Interfaces;

import com.upt.cti.aplicatiecomandat.DataTypes.User;

public interface IAuthenticationHandler {
     void verifyClientInDatabase(User user, Callback<Boolean> callback);
     void checkIfClientIsInDatabase(User user, Callback<Boolean> callback);
     void addClientInDatabase(User user,Callback<Boolean> callback);
}
