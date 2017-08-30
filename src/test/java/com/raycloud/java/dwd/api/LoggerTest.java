package com.raycloud.java.dwd.api;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by:  intelliJ IDEA
 *
 * @Author albert
 * @Description:
 * @Date:2017/8/25 下午2:00
 * @package:com.raycloud.java.dwd.api
 * @Modified By:
 */
public class LoggerTest {
    private Logger logger = Logger.getLogger(LoggerTest.class);



    @Test
    public void testLogger(){
        logger.error("error");
        logger.info("info");
        logger.debug("debug");
    }



}
