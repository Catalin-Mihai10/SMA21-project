package com.upt.cti.aplicatiecomandat.Handlers;

import com.upt.cti.aplicatiecomandat.DataTypes.Item;
import com.upt.cti.aplicatiecomandat.Interfaces.IDataHandler;
import com.upt.cti.aplicatiecomandat.Modules.ClientModule;
import com.upt.cti.aplicatiecomandat.Modules.ProccesCommandModule;
import com.upt.cti.aplicatiecomandat.ui.Cart;

public class DataHandler implements IDataHandler{
    private ProccesCommandModule proccesCommandModule;
    private static ProviderHandler providerHandler;

    public DataHandler(){
        proccesCommandModule = new ProccesCommandModule();
        providerHandler = new ProviderHandler(proccesCommandModule);
    }

    @Override
    public void proccesItemData(Cart cart) {
        for(Item itemIterator : cart.getCart()){
            providerHandler.verifyProviderDataInDatabase(itemIterator);
        }
    }

    @Override
    public void proccesUserData(ClientModule client) {
        proccesCommandModule.sendResponseToClient(client);
    }

    @Override
    public void removedProccesedItemData(Item item) {

    }
}
