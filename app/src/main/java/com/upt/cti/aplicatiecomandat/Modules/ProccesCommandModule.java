package com.upt.cti.aplicatiecomandat.Modules;

import com.upt.cti.aplicatiecomandat.Interfaces.IProccesCommandModule;

import java.util.Random;

public class ProccesCommandModule implements IProccesCommandModule{
    private boolean commandHasBeenValidated;
    private long proccesCommandID;

    public ProccesCommandModule(){
        commandHasBeenValidated = false;

        Random randomNumber = new Random();
        long proccesID = randomNumber.nextInt(10000);

        proccesCommandID = proccesID;
    }

    @Override
    public boolean sendResponseToClient(ClientModule client) {

        while(true){
            if(commandHasBeenValidated) break;
        }

        client.commandResponse(true);
        return true;
    }

    @Override
    public void verifyCommandResponse(boolean response) {
        commandHasBeenValidated = response;
    }

    @Override
    public long getProccesID() {
        return proccesCommandID;
    }
}
