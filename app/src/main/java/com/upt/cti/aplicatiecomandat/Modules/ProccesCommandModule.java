package com.upt.cti.aplicatiecomandat.Modules;

import com.upt.cti.aplicatiecomandat.Interfaces.IProccesCommandModule;

public class ProccesCommandModule implements IProccesCommandModule{

    public ProccesCommandModule(){}

    @Override
    public boolean sendResponseToClient() {
        return false;
    }

    @Override
    public boolean verifyCommandResponse() {
        return false;
    }

    @Override
    public int getProccesID() {
        return 0;
    }
}
