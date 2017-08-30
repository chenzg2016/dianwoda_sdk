package com.raycloud.java.dwd.api.base;

import com.raycloud.java.dwd.api.constants.DwdUrlConstant;

/**
 * Created by:  intelliJ IDEA
 *
 * @Author albert
 * @Description: 点我达请求配置
 * @Date:2017/8/22 下午5:05
 * @package:com.raycloud.java.dwd.api.base
 * @Modified By:
 */
public class Config {

    private String appSecret;
    private String appKey;
    private String baseUrl;
    private String callback;
    /**
     * @param appSecret 开发者secret
     * @param isSandBox 是否沙箱环境
     */
    public Config(String appSecret,String appKey, boolean isSandBox,String callback) {
        this.appSecret = appSecret;
        if(isSandBox){
            this.appKey = appKey;
            this.appSecret = appSecret;
            this.baseUrl = DwdUrlConstant.BASIC_IP_SANDBOX;
            this.callback = callback;
        }else {
            this.appKey = appKey;
            this.appSecret = appSecret;
            this.baseUrl = DwdUrlConstant.BASIC_IP;
            this.callback =callback;
        }
    }

    public String getAppSecret() {
        return appSecret;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getAppKey() {
        return appKey;
    }

    public String getCallback() {
        return callback;
    }
}
