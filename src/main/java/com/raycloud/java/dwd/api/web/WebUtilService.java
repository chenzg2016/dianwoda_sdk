package com.raycloud.java.dwd.api.web;

import java.io.IOException;

/**
 * Created by:  intelliJ IDEA
 *
 * @Author albert
 * @Description:使用代理模式设计请求接口
 * @Date:2017/8/24 上午9:20
 * @package:com.raycloud.java.dwd.api.request
 * @Modified By:
 */
public interface WebUtilService {

    /**
     * 执行post请求
     * @param url
     * @param parameter
     * @return
     * @throws IOException
     */
     String postMethod(String url,String parameter)throws IOException;

    /**
     * 执行get请求
     * @param url
     * @param parameter
     * @return
     * @throws IOException
     */
     String getMethod(String url,String parameter)throws IOException;

}
