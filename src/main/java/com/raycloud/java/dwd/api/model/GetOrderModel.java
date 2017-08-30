package com.raycloud.java.dwd.api.model;

import com.raycloud.java.dwd.annotation.ParamValue;
import lombok.Data;

/**
 * Created by:  intelliJ IDEA
 *
 * @Author albert
 * @Description:获取订单model
 * @Date:2017/8/22 上午9:09
 * @package:com.raycloud.java.dwd.api.model
 * @Modified By:
 */
@Data
public class GetOrderModel {
    @ParamValue(filedName = "order_original_id",isNotNull = true,filedDesc = "渠道订单编号")
    private String orderOriginalId;
}
