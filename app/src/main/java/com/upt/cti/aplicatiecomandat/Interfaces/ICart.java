package com.upt.cti.aplicatiecomandat.Interfaces;

import com.upt.cti.aplicatiecomandat.DataTypes.Item;

import java.util.List;

public interface ICart {

    public boolean addItemToCart(Item item);
    public boolean removeItemFromCart(Item item);
    public boolean submitItemsOnCommand();
    public List<Item> getCart();

}
