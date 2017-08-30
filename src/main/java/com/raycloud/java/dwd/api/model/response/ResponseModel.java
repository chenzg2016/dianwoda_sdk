package com.raycloud.java.dwd.api.model.response;

import lombok.Data;

/**
 * Created by:  intelliJ IDEA
 *
 * @Author albert
 * @Description: 接口调用响应结果
 * @Date:2017/8/22 下午5:55
 * @package:com.raycloud.java.dwd.api.model.callback
 * @Modified By:
 */
@Data
public class ResponseModel{
    private String errorCode;
    private String result;
    private boolean success;
    private String message;

}
