package com.raycloud.java.dwd.api.constants;

import java.util.Date;

/**
 * Created by:  intelliJ IDEA
 *
 * @Author albert
 * @Description:系统级参数配置
 * @Date:2017/8/22 下午4:55
 * @package:com.raycloud.java.dwd.api.constants
 * @Modified By:
 */
public class SystemParamConfig {

    /**
     * 系统级参数拼接
     * @param appKey
     * @return pk=?&timestamp=?&format=?&sig=
     */
    public static String getSystemParamSetting(String appKey){
        Long timestamp = System.currentTimeMillis();
        StringBuffer systemParam = new StringBuffer(100);
        systemParam.append("pk=").append(appKey).append("&");
        systemParam.append("timestamp=").append(timestamp).append("&");
        systemParam.append("format=").append("json").append("&");
        systemParam.append("sig=");
        return systemParam.toString();
    }

}
