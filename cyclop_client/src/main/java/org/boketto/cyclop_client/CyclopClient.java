package org.boketto.cyclop_client;

import org.boketto.cyclop_client.bundle.NetworkBundle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CyclopClient {

    private static final Logger logger = LoggerFactory.getLogger(CyclopClient.class);

    public void startClient() {
        logger.info("启动客户端成功");
        //TODO，实现一个工具类，扫描抽象类的所有子类，然后依次启动，目前直接写死以方便测试
        new NetworkBundle().start();
    }

    public void stopClient() {
        logger.info("终止客户端成功");
    }

}
