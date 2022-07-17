package org.boketto.cyclop_client.message;

import sun.misc.Signal;

public class MessageManager {

    static {
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
                InternalMessage translateMessage = translateMessage(internalMessage);
                dispatchMessage(translateMessage);
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

    public static InternalMessage getMessage(String bundleName) throws InterruptedException {
        //TODO
        return new InternalMessage();
    }

    public static void postMessage(String bundleName, InternalMessage internalMessage) {

    }

    public static void postQuitMessage() {
        //TODO，给各个组件集发送终止消息
        //TODO，主线程同步等待组件集10秒
        //TODO，给主线程发送终止消息终结客户端
    }

    public static void postThreadMessage(Long threadId, InternalMessage internalMessage) {

    }

    public static void defaultMessageProcessor(InternalMessage internalMessage) {

    }
}
