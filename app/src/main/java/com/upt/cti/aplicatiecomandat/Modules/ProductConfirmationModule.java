package com.upt.cti.aplicatiecomandat.Modules;

import com.upt.cti.aplicatiecomandat.Interfaces.IProductConfirmationModule;

public class ProductConfirmationModule implements IProductConfirmationModule{
    private ProccesCommandModule proccesCommandModule;

    public ProductConfirmationModule(ProccesCommandModule proccesCommandModule){
        this.proccesCommandModule = proccesCommandModule;
    }

    @Override
    public void validateProviderData(boolean response) {
        proccesCommandModule.verifyCommandResponse(response);
    }
}
