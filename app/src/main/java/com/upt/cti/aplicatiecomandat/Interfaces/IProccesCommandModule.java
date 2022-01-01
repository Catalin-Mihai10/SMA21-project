package com.upt.cti.aplicatiecomandat.Interfaces;

import com.upt.cti.aplicatiecomandat.Modules.ClientModule;

public interface IProccesCommandModule {

     boolean sendResponseToClient(ClientModule client);
     void verifyCommandResponse(boolean response);
     long getProccesID();

}
