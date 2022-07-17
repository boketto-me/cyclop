package org.boketto.cyclop_client;

import org.boketto.cyclop_client.message.MessageManager;

public class Application {

    public static void main(String[] args) {
        CyclopClient cyclopClient = new CyclopClient();
        cyclopClient.startClient();
        MessageManager.cycleGlobal();
        cyclopClient.stopClient();
    }

}
