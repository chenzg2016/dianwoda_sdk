package com.raycloud.java.dwd.api.service.back;

import com.raycloud.java.dwd.api.model.response.GetComplainResponse;
import com.raycloud.java.dwd.api.model.response.GetOrderResponse;
import com.raycloud.java.dwd.api.model.response.GetRiderPositionResponse;
import com.raycloud.java.dwd.api.model.response.SendOrderResultModel;
import lombok.Data;

import java.util.List;

/**
 * Created by:  intelliJ IDEA
 *
 * @Author albert
 * @Description: 统一返回结果
 * @Date:2017/8/23 下午1:57
 * @package:com.raycloud.java.dwd.api.service.back
 * @Modified By:
 */
@Data
public class BackModel {

    /**
     * 错误代码 0 表示正常
     */
    private String errorCode;
    /**
     * 响应状态 true成功 false 失败
     */
    private boolean success;
    /**
     *错误代码不为0 and success 是false时message存在
     */
    private String message;

    /**
     *发单时 success 为true时result json数据
     */
    private SendOrderResultModel sendOrderResultModel;

    /**
     * 获取订单接口返回数据类
     */
    private GetOrderResponse getOrderResponse;

    /**
     * 获取配送员位置信息（单个）
     */
    private GetRiderPositionResponse getRiderPositionResponse;

    /**
     * 获取配送员位置信息（批量）
     */
    private List<GetRiderPositionResponse> getRiderPositionResponses;

    /**
     * 查询投诉信息
     */
    private GetComplainResponse getComplainResponse;



}
