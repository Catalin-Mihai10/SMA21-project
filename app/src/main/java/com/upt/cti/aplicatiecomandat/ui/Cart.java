package com.upt.cti.aplicatiecomandat.ui;

import com.upt.cti.aplicatiecomandat.Interfaces.ICart;
import com.upt.cti.aplicatiecomandat.DataTypes.Item;

import java.util.ArrayList;

public class Cart implements ICart{
    private ArrayList<Item> cart;

    public Cart(){
        cart = new ArrayList<>();
    }

    @Override
    public boolean addItemToCart(Item item) {

        for(Item itemIterator : cart)
            if(itemIterator.equals(item)) return false;

        cart.add(item);
        return true;
    }

    @Override
    public boolean removeItemFromCart(Item item) {
        if(cart.isEmpty()) return false;

        for(Item itemIterator : cart)
            if(itemIterator.equals(item)) {
                cart.remove(itemIterator);
                return true;
            }

        return false;
    }

    @Override
    public boolean submitItemsOnCommand() {
        if(cart.isEmpty()) return false;

        for(Item itemIterator : cart)
            cart.remove(itemIterator);

        return true;
    }

}
