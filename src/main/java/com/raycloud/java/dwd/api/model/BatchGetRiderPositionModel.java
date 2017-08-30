package com.raycloud.java.dwd.api.model;

import com.raycloud.java.dwd.annotation.ParamValue;
import lombok.Data;

/**
 * Created by:  intelliJ IDEA
 *
 * @Author albert
 * @Description:批量获取配送员位置信息
 * @Date:2017/8/22 上午9:27
 * @package:com.raycloud.java.dwd.api.model
 * @Modified By:
 */
@Data
public class BatchGetRiderPositionModel {

    @ParamValue(filedName = "city_code",filedDesc = "城市编码")
    private String cityCode;
    @ParamValue(filedName = "order_original_ids",isNotNull = true,filedDesc = "渠道订单号用”,”分隔最多20个")
    private String orderOriginalIds;
}
