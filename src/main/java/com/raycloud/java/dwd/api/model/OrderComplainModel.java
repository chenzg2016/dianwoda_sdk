package com.raycloud.java.dwd.api.model;

import com.raycloud.java.dwd.annotation.ParamValue;
import lombok.Data;

/**
 * Created by:  intelliJ IDEA
 *
 * @Author albert
 * @Description:订单投诉model
 * @Date:2017/8/22 上午9:37
 * @package:com.raycloud.java.dwd.api.model
 * @Modified By:
 */
@Data
public class OrderComplainModel {
    @ParamValue(filedName = "order_original_id",isNotNull = true,filedDesc = "外部订单id")
    private String orderOriginalId;
    @ParamValue(filedName = "complain_source",isNotNull = true,filedDesc = "投诉来源商户：2；用户：3")
    private Integer complainSource;
    @ParamValue(filedName = "complain_content",isNotNull = true,filedDesc = "内容json数组")
    private String complainContent;
    @ParamValue(filedName = "complain_time",isNotNull = true,filedDesc = "投诉时间时间戳")
    private Long complainTime;
}
