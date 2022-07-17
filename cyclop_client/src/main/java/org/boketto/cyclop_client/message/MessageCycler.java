package org.boketto.cyclop_client.message;

import java.util.concurrent.LinkedBlockingQueue;

public class MessageCycler {

    private LinkedBlockingQueue<InternalMessage> messageQueue = new LinkedBlockingQueue<>();

    public InternalMessage getMessage() throws InterruptedException {
        return messageQueue.take();
    }

    public void postMessage(InternalMessage internalMessage) throws InterruptedException {
        messageQueue.put(internalMessage);
    }

}
