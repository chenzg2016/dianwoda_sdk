package com.raycloud.java.dwd.api.web.impl;


import com.raycloud.java.dwd.api.web.WebUtilService;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import java.io.IOException;

/**
 * Created by:  intelliJ IDEA
 *
 * @Author albert
 * @Description: 网络资源请求
 * @Date:2017/8/21 下午1:52
 * @package:com.raycloud.java.dwd.api.request
 * @Modified By:
 */
public class WebUtilServiceImpl implements WebUtilService {

    private Logger logger = Logger.getLogger(WebUtilServiceImpl.class);
    //declare client
    private CloseableHttpClient client = HttpClients.createDefault();
    //set connection time out
    //设置超时时间 setConnectTimeout：设置连接超时时间，单位毫秒
    //setConnectionRequestTimeout：设置从connect Manager获取Connection 超时时间，
    // 单位毫秒。这个属性是新加的属性，因为目前版本是可以共享连接池的
    //setSocketTimeout：请求获取数据的超时时间，单位毫秒。 如果访问一个接口，多少时间内无法返回数据，就直接放弃此次调用。
    private RequestConfig requestConfig = RequestConfig.custom()
            .setConnectTimeout(7000).setConnectionRequestTimeout(7000)
            .setSocketTimeout(10000).build();

    /**
     * post请求
     * @param url
     * @param parameter
     * @return
     * @throws IOException
     */
    @Override
    public String postMethod(String url,String parameter)throws IOException{
        //设置参数
        StringEntity entityParam = new StringEntity(parameter,ContentType.create("application/x-www-form-urlencoded","UTF-8"));
        entityParam.setContentType("application/x-www-form-urlencoded;charset=UTF-8");
        //初始化post
        HttpPost post = new HttpPost(url);
        post.setEntity(entityParam);
        //设置用户系统信息
        post.setHeader("User-Agent","raycloud-sdk-client-java");
        //暂时不调用
//        post.setConfig(requestConfig);
        //获取请求返回
        CloseableHttpResponse response = client.execute(post);
        HttpEntity entity = response.getEntity();
        String result = EntityUtils.toString(entity, "UTF-8");
        post.releaseConnection();
        logger.info("请求返回"+result);
        return result;
    }


    /**
     * get请求
     * @param url
     * @param parameter
     * @return
     * @throws IOException
     */
    @Override
    public String getMethod(String url,String parameter)throws IOException{

        return null;
    }

}
