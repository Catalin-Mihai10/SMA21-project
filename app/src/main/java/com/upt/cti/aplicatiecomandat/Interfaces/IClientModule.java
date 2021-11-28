package com.upt.cti.aplicatiecomandat.Interfaces;

public interface IClientModule {

    public boolean addToCart(/*item : Item*/);
    public boolean removeFromCart(/*item : Item*/);
    public boolean submitCommand(/*item : Item*/);
    public void logIn(String user, String password);
    public void printAllCommands();
    public void removeUser();
    public void logOut();
    public void changePassword(String password);
    public String getUser();
    public String getPassword();
}
