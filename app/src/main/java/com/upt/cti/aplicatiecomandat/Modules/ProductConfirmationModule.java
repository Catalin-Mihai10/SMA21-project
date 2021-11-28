package com.upt.cti.aplicatiecomandat.Modules;

import com.upt.cti.aplicatiecomandat.Interfaces.IProductConfirmationModule;

public class ProductConfirmationModule implements IProductConfirmationModule{
    private ProccesCommandModule proccesCommandModule;

    public ProductConfirmationModule(){}

    @Override
    public boolean validateProviderData() {
        return false;
    }
}
