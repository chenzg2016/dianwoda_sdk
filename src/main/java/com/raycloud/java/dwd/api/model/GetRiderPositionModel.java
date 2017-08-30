package com.raycloud.java.dwd.api.model;

import com.raycloud.java.dwd.annotation.ParamValue;
import lombok.Data;

/**
 * Created by:  intelliJ IDEA
 *
 * @Author albert
 * @Description:获取配送员位置信息
 * @Date:2017/8/22 上午9:27
 * @package:com.raycloud.java.dwd.api.model
 * @Modified By:
 */
@Data
public class GetRiderPositionModel {

    @ParamValue(filedName = "rider_code",isNotNull = true,filedDesc = "配送员编号")
    private String riderCode;
    @ParamValue(filedName = "order_original_id",isNotNull = true,filedDesc = "渠道订单编号")
    private String orderOriginalId;
}
