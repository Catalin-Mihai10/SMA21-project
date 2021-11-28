package com.upt.cti.aplicatiecomandat.Handlers;

import com.upt.cti.aplicatiecomandat.Interfaces.IDataHandler;
import com.upt.cti.aplicatiecomandat.Modules.ClientModule;
import com.upt.cti.aplicatiecomandat.Modules.ProccesCommandModule;

public class DataHandler implements IDataHandler{
    private ProccesCommandModule proccesCommandModule;

    public DataHandler(){}

    @Override
    public void proccesItemData() {}

    @Override
    public void proccesUserData(ClientModule clientModule) {}
}
