package com.upt.cti.aplicatiecomandat.DataTypes;

import com.upt.cti.aplicatiecomandat.Interfaces.ICart;

import java.util.ArrayList;
import java.util.List;

public class Cart implements ICart{
    private final List<Item> cart;

    public Cart(){
        cart = new ArrayList<>();
    }

    @Override
    public boolean addItemToCart(Item item) {
        cart.add(item);
        return true;
    }

    @Override
    public void removeItemFromCart(Item item) {
        if(cart.isEmpty()) return;

        cart.removeIf(itemIterator -> itemIterator.equals(item));
    }

    @Override
    public void submitItemsOnCommand() {
        if(cart.isEmpty()) return;
        cart.clear();
    }


    public List<Item> getCart(){
        return cart;
    }

}
