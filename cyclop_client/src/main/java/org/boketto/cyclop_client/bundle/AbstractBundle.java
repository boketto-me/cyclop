package org.boketto.cyclop_client.bundle;

import org.boketto.cyclop_client.message.MessageCycler;
import org.boketto.cyclop_client.message.MessageManager;

public abstract class AbstractBundle extends Thread implements BundleContract {

    private MessageCycler messageCycler = new MessageCycler();

    @Override
    public abstract String businessType();

    @Override
    public void run() {
        String bizType = businessType();
        MessageManager.registerBundle(bizType, messageCycler);
    }

}
