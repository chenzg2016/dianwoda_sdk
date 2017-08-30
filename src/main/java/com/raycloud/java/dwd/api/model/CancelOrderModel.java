package com.raycloud.java.dwd.api.model;

import com.raycloud.java.dwd.annotation.ParamValue;
import lombok.Data;

/**
 * Created by:  intelliJ IDEA
 *
 * @Author albert
 * @Description:订单取消model
 * @Date:2017/8/22 上午9:12
 * @package:com.raycloud.java.dwd.api.model
 * @Modified By:
 */
@Data
public class CancelOrderModel {
    @ParamValue(filedName = "order_original_id",isNotNull = true,filedDesc = "渠道订单编号")
    private String orderOriginalId;
    @ParamValue(filedName = "cancle_reason",isNotNull = true,filedDesc = "取消订单原因")
    private String cancleReason;
}
