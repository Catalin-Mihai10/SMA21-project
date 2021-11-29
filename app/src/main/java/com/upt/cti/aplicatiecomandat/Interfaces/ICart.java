package com.upt.cti.aplicatiecomandat.Interfaces;

import com.upt.cti.aplicatiecomandat.DataTypes.Item;

public interface ICart {

    public boolean addItemToCart(Item item);
    public boolean removeItemFromCart(Item item);
    public boolean submitItemsOnCommand();

}
