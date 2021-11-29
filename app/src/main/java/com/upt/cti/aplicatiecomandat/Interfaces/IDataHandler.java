package com.upt.cti.aplicatiecomandat.Interfaces;

import com.upt.cti.aplicatiecomandat.DataTypes.Item;
import com.upt.cti.aplicatiecomandat.Modules.ClientModule;
import com.upt.cti.aplicatiecomandat.ui.Cart;

public interface IDataHandler {

    public void proccesItemData(Cart cart);
    public void proccesUserData(ClientModule clientModule);
    public void removedProccesedItemData(Item item);
}
