package com.upt.cti.aplicatiecomandat.Interfaces;

import com.upt.cti.aplicatiecomandat.DataTypes.Item;

import java.util.List;

public interface ICart {

    boolean addItemToCart(Item item);
    void removeItemFromCart(Item item);
    void submitItemsOnCommand();
    List<Item> getCart();

}
