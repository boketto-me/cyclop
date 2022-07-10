package org.boketto.cyclop_client;

public class Application {

    public static void main(String[] args) {
        CyclopClient cyclopClient = new CyclopClient();
        cyclopClient.startClient();
        //TODO，参考Windows实现消息循环
        cyclopClient.stopClient();
    }

}
