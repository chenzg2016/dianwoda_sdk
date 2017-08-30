package com.raycloud.java.dwd.api.model;

import com.raycloud.java.dwd.annotation.ParamValue;
import lombok.Data;

/**
 * Created by:  intelliJ IDEA
 *
 * @Author albert
 * @Description:订单派发时items的对象
 * @Date:2017/8/24 下午3:29
 * @package:com.raycloud.java.dwd.api.model
 * @Modified By:
 */
@Data
public class OrderItemsModel {

    @ParamValue(filedName ="item_name",isNotNull = true,filedDesc = "items中商品名称")
    private String item_name;
    @ParamValue(filedName ="unit",isNotNull = true,filedDesc = "items中商品单位")
    private String unit;
    @ParamValue(filedName ="quantity",isNotNull = true,filedDesc = "items中商品数量")
    private Integer quantity;
    @ParamValue(filedName ="unit_price",isNotNull = true,filedDesc = "items中单位原价(分)")
    private Long unit_price;
    @ParamValue(filedName ="discount_price",isNotNull = true,filedDesc = "items中单位折扣价(分,没有传原价)")
    private Long discount_price;
    @ParamValue(filedName ="production_time",isNotNull = true,filedDesc = "items中餐品制作时长(秒)")
    private Long production_time;


}
