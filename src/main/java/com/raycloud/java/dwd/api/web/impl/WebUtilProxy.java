package com.raycloud.java.dwd.api.web.impl;

import com.raycloud.java.dwd.api.web.WebUtilService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by:  intelliJ IDEA
 *
 * @Author albert
 * @Description: 为了后期加上日志
 * @Date:2017/8/24 上午9:33
 * @package:com.raycloud.java.dwd.api.request.impl
 * @Modified By:
 */
public class WebUtilProxy implements WebUtilService {

    private static Logger  logger = LoggerFactory.getLogger(WebUtilService.class);

    private WebUtilServiceImpl webUtilServiceImpl;

    public WebUtilProxy() {
        this.webUtilServiceImpl = new WebUtilServiceImpl();
    }

    @Override
    public String postMethod(String url, String parameter) throws IOException {
        beforeAction(url);
        String message = webUtilServiceImpl.postMethod(url,parameter);
        afterAction(url);
        return message;
    }

    @Override
    public String getMethod(String url, String parameter) throws IOException {
        beforeAction(url);
        String message = webUtilServiceImpl.getMethod(url,parameter);
        afterAction(url);
        return message;
    }

    private void beforeAction(String url){
        logger.info("点我达请求Url{}开始",url);
    }

    private void afterAction(String url){
        logger.info("点我达请求url{}结束",url);
    }

}
