package org.boketto.cyclop_client.message;

import sun.misc.Signal;

import java.util.concurrent.ConcurrentHashMap;

public class MessageManager {

    private static ConcurrentHashMap<String, MessageCycler> bundleCyclerKV;

    static {
        bundleCyclerKV = new ConcurrentHashMap<>();
        bundleCyclerKV.put("global", new MessageCycler());
        Signal.handle(new Signal("INT"), signal -> postQuitMessage());
        Signal.handle(new Signal("TERM"), signal -> postQuitMessage());
    }

    /**
     * 应用程序整体消息循环
     */
    public static void cycleGlobal() {
        try {
            do {
                InternalMessage internalMessage = getMessage("global");
                if (internalMessage.getMessageId().equals(0L)) {
                    break;
                } else {
                    InternalMessage translateMessage = translateMessage(internalMessage);
                    dispatchMessage(translateMessage);
                }
            } while (true);
        } catch (InterruptedException interruptedException) {

        }
    }

    private static InternalMessage translateMessage(InternalMessage internalMessage) {
        return internalMessage;
    }

    private static void dispatchMessage(InternalMessage internalMessage) {
        //TODO，根据组件找到其消息队列，放置到消息队列尾端
    }

    public static void registerBundle(String bundleName, MessageCycler messageCycler) {
        bundleCyclerKV.put(bundleName, messageCycler);
    }

    public static InternalMessage getMessage(String bundleName) throws InterruptedException {
        return bundleCyclerKV.get(bundleName).getMessage();
    }

    public static void postMessage(String bundleName, InternalMessage internalMessage) throws InterruptedException {
        bundleCyclerKV.get(bundleName).postMessage(internalMessage);
    }

    public static void postQuitMessage() {
        //TODO，给各个组件集发送终止消息
        //TODO，主线程同步等待组件集10秒
        //TODO，给主线程发送终止消息终结客户端
        try {
            postMessage("global", InternalMessage.builder().messageId(0L).build());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void postThreadMessage(Long threadId, InternalMessage internalMessage) {

    }

    public static void defaultMessageProcessor(InternalMessage internalMessage) {

    }
}
