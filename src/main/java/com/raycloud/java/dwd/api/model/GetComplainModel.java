package com.raycloud.java.dwd.api.model;

import com.raycloud.java.dwd.annotation.ParamValue;
import lombok.Data;

/**
 * Created by:  intelliJ IDEA
 *
 * @Author albert
 * @Description:查询投诉结果
 * @Date:2017/8/22 上午9:42
 * @package:com.raycloud.java.dwd.api.model
 * @Modified By:
 */
@Data
public class GetComplainModel {

    @ParamValue(filedName = "order_original_id",isNotNull = true,filedDesc = "渠道订单号")
    private String orderOriginalId;
    @ParamValue(filedName = "order_complain_original_id",filedDesc = "渠道投诉编号")
    private String orderComplainOriginalId;
    @ParamValue(filedName = "complain_type",isNotNull = true,filedDesc = "投诉类型编号")
    private String complainType;

}
