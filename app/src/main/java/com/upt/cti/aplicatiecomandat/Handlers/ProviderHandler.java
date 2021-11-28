package com.upt.cti.aplicatiecomandat.Handlers;

import com.upt.cti.aplicatiecomandat.Interfaces.IProviderHandler;
import com.upt.cti.aplicatiecomandat.Modules.ProductConfirmationModule;

public class ProviderHandler implements IProviderHandler{
    private ProductConfirmationModule productConfirmationModule;

    public ProviderHandler(){}

    @Override
    public boolean verifyProviderDataInDatabase() {
        return false;
    }
}
