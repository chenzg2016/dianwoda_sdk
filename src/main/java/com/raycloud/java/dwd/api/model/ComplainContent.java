package com.raycloud.java.dwd.api.model;

import com.raycloud.java.dwd.annotation.ParamValue;
import lombok.Data;

/**
 * Created by:  intelliJ IDEA
 *
 * @Author albert
 * @Description:订单投诉内容的json体
 * @Date:2017/8/22 下午4:45
 * @package:com.raycloud.java.dwd.api.model
 * @Modified By:
 */
@Data
public class ComplainContent {
    @ParamValue(filedName = "code", isNotNull = true, filedDesc = "投诉类型")
    private String code;
    @ParamValue(filedName = "reason", filedDesc = "投诉原因描述")
    private String reason;
    @ParamValue(filedName = "order_complain_original_id", filedDesc = "渠道传过来的区分投诉的唯一编号")
    private String order_complain_original_id;
}
