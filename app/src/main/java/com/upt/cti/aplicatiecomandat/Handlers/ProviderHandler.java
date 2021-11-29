package com.upt.cti.aplicatiecomandat.Handlers;

import com.upt.cti.aplicatiecomandat.DataTypes.Item;
import com.upt.cti.aplicatiecomandat.Interfaces.IProviderHandler;
import com.upt.cti.aplicatiecomandat.Modules.ProccesCommandModule;
import com.upt.cti.aplicatiecomandat.Modules.ProductConfirmationModule;

public class ProviderHandler implements IProviderHandler{
    private ProductConfirmationModule productConfirmationModule;

    public ProviderHandler(ProccesCommandModule proccesCommandModule){
        productConfirmationModule = new ProductConfirmationModule(proccesCommandModule);
    }

    @Override
    public void verifyProviderDataInDatabase(Item item) {
        productConfirmationModule.validateProviderData(false);
    }
}
