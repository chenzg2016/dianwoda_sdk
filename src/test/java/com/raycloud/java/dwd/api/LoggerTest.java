package com.raycloud.java.dwd.api;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    private Logger logger = LoggerFactory.getLogger(LoggerTest.class);



    @Test
    public void testLogger(){
        String a = "info";
        String b = "debug";
        String c = "error";

        logger.error("error{}",c);
        logger.info("info{}",a);
        logger.debug("debug{}",b);
    }



}
