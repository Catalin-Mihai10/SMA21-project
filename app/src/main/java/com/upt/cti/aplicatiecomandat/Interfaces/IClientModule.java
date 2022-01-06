package com.upt.cti.aplicatiecomandat.Interfaces;

public interface IClientModule {
    void logIn(Callback<Boolean> callback);
    void register(Callback<Boolean> callback);
}
