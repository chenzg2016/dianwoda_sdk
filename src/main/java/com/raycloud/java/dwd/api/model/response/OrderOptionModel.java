package com.raycloud.java.dwd.api.model.response;

import com.raycloud.java.dwd.annotation.ParamValue;
import lombok.Data;

/**
 * Created by:  intelliJ IDEA
 *
 * @Author albert
 * @Description:测试订单接受，完成到店，完成取货，配送完成仅测试接口可用
 * @Date:2017/8/22 上午10:10
 * @package:com.raycloud.java.dwd.api.model.callback
 * @Modified By:
 */
@Data
public class OrderOptionModel {
    @ParamValue(filedName = "order_original_id",isNotNull = true,filedDesc = "渠道订单编号")
    private String orderOriginalId;
}
