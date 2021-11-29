package com.upt.cti.aplicatiecomandat.Interfaces;

import com.upt.cti.aplicatiecomandat.Modules.ClientModule;

public interface IProccesCommandModule {

    public boolean sendResponseToClient(ClientModule client);
    public void verifyCommandResponse(boolean response);
    public long getProccesID();

}
