package com.upt.cti.aplicatiecomandat.Interfaces;

import com.upt.cti.aplicatiecomandat.DataTypes.Item;

import java.util.List;

public interface ICart {

    boolean addItemToCart(Item item);
    boolean removeItemFromCart(Item item);
    boolean submitItemsOnCommand();
    List<Item> getCart();

}
