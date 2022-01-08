package com.upt.cti.aplicatiecomandat.Handlers;

import com.upt.cti.aplicatiecomandat.DataTypes.Item;
import com.upt.cti.aplicatiecomandat.DataTypes.PurchaseInformation;
import com.upt.cti.aplicatiecomandat.DataTypes.User;
import com.upt.cti.aplicatiecomandat.Interfaces.Callback;
import com.upt.cti.aplicatiecomandat.DataTypes.Cart;

import java.util.List;

public class CommandHandler {
    private final static AuthenticationHandler authenticationHandler = new AuthenticationHandler();
    private final static Cart cart = new Cart();
    private static User applicationUser = null;
    private static PurchaseInformation purchaseInformation;

    public static boolean addToCart(Item item) {
        return cart.addItemToCart(item);
    }

    public static void removeFromCart(Item item) {
        cart.removeItemFromCart(item);
    }

    public static void submitItemsForCommand(){
        cart.submitItemsOnCommand();
    }

    public static List<Item> getCart(){
        return cart.getCart();
    }

    public static void saveUserInternally(User user){
        applicationUser = user;
    }

    public static User getApplicationUser(){
        return applicationUser;
    }

    public static Cart getFinalCommand(){ return cart;}

    public static void logIn(User user, Callback<Boolean> startMainActivity) {
        authenticationHandler.checkIfClientIsInDatabase(user, data -> {
            if(data) startMainActivity.callback(true);
            else startMainActivity.callback(false);
        });
    }

    public static void register(User user, Callback<Boolean> checkIfUserAlreadyExists) {
        authenticationHandler.addClientInDatabase(user, data -> {
             if(data) checkIfUserAlreadyExists.callback(true);
             else checkIfUserAlreadyExists.callback(false);
         });
    }

    public static void setPurchaseInformation(PurchaseInformation information){
        purchaseInformation = information;
    }

    public static PurchaseInformation getPurchaseInformation(){
        return purchaseInformation;
    }

    public static void setPhone(String phone){
        purchaseInformation.setPhone(phone);
    }

    public static void setAddress(String address){
        purchaseInformation.setAddress(address);
    }

    public static void setCountry(String country){
        purchaseInformation.setCountry(country);
    }

    public static void setCity(String city){
        purchaseInformation.setCity(city);
    }


}
