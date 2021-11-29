package com.upt.cti.aplicatiecomandat.Handlers;

import com.upt.cti.aplicatiecomandat.DataTypes.Item;
import com.upt.cti.aplicatiecomandat.Interfaces.IDataHandler;
import com.upt.cti.aplicatiecomandat.Modules.ClientModule;
import com.upt.cti.aplicatiecomandat.Modules.ProccesCommandModule;
import com.upt.cti.aplicatiecomandat.ui.Cart;

public class DataHandler implements IDataHandler{
    private ProccesCommandModule proccesCommandModule;

    public DataHandler(){}

    @Override
    public void proccesItemData(Cart cart) {}

    @Override
    public void proccesUserData(ClientModule clientModule) {}

    @Override
    public void removedProccesedItemData(Item item) {

    }
}
