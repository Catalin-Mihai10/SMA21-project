package com.upt.cti.aplicatiecomandat.Interfaces;

import com.upt.cti.aplicatiecomandat.DataTypes.Item;
import com.upt.cti.aplicatiecomandat.Modules.ClientModule;
import com.upt.cti.aplicatiecomandat.ui.Cart;

public interface IDataHandler {

    void proccesItemData(Cart cart);
    void proccesUserData(ClientModule clientModule);
    void removedProccesedItemData(Item item);
}
