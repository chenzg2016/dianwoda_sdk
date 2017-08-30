package com.raycloud.java.dwd.api.model.callback;

import com.raycloud.java.dwd.annotation.ParamValue;
import lombok.Data;

/**
 * Created by:  intelliJ IDEA
 *
 * @Author albert
 * @Description: 回调model
 * @Date:2017/8/22 上午10:15
 * @package:com.raycloud.java.dwd.api.model.callback
 * @Modified By:
 */
@Data
public class OrderCallback {
    @ParamValue(filedName = "order_original_id",filedDesc ="渠道订单编号",isNotNull = true)
    private String order_original_id;//渠道订单编号
    @ParamValue(filedName = "order_status",filedDesc ="订单状态",isNotNull = true)
    private Integer order_status;//订单状态
    @ParamValue(filedName = "cancel_reason",filedDesc ="订单取消原因")
    private String cancel_reason;//订单取消原因
    @ParamValue(filedName = "abnormal_reason",filedDesc ="异常订单原因")
    private String abnormal_reason;//异常订单原因
    @ParamValue(filedName = "rider_code",filedDesc ="配送员编号")
    private String rider_code;//配送员编号
    @ParamValue(filedName = "rider_name",filedDesc ="配送员姓名")
    private String rider_name;//配送员姓名
    @ParamValue(filedName = "rider_mobile",filedDesc ="配送员手机号")
    private String rider_mobile;//配送员手机号
    @ParamValue(filedName = "time_status_update",filedDesc ="更新时间戳",isNotNull = true)
    private Long time_status_update;//更新时间戳
    private String sig;//验证签名
}
