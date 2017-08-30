package com.raycloud.java.dwd.api.model;

import com.raycloud.java.dwd.annotation.ParamValue;
import lombok.Data;

/**
 * Created by:  intelliJ IDEA
 *
 * @Author albert
 * @Description:更新订单备注model
 * @Date:2017/8/22 上午9:12
 * @package:com.raycloud.java.dwd.api.model
 * @Modified By:
 */
@Data
public class UpdateRemarkModel {
    @ParamValue(filedName = "order_original_id",isNotNull = true,filedDesc = "渠道订单编号")
    private String orderOriginalId;
    @ParamValue(filedName = "order_info_content",isNotNull = true,filedDesc = "订单备注")
    private String orderInfoContent;
}
