package org.boketto.cyclop_client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CyclopClient {

    private static final Logger logger = LoggerFactory.getLogger(CyclopClient.class);

    public void startClient() {
        logger.info("启动客户端成功");
    }

    public void ceaseClient() {
        logger.info("终止客户端成功");
    }

}
