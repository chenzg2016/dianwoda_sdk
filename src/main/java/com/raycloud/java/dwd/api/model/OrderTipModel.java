package com.raycloud.java.dwd.api.model;

import com.raycloud.java.dwd.annotation.ParamValue;
import lombok.Data;

/**
 * Created by:  intelliJ IDEA
 *
 * @Author albert
 * @Description: 订单小费model
 * @Date:2017/8/22 上午10:05
 * @package:com.raycloud.java.dwd.api.model
 * @Modified By:
 */
@Data
public class OrderTipModel {
    @ParamValue(filedName = "order_original_id",isNotNull = true,filedDesc = "渠道订单编号")
    private String orderOriginalId;
    @ParamValue(filedName = "tip",isNotNull = true,filedDesc = "小费总金额（分）")
    private Long tip;
}
