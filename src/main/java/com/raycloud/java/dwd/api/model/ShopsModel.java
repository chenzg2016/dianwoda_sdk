package com.raycloud.java.dwd.api.model;

import com.raycloud.java.dwd.annotation.ParamValue;
import lombok.Data;

/**
 * Created by:  intelliJ IDEA
 *
 * @Author albert
 * @Description:创建站点时shop结构
 * @Date:2017/8/22 上午9:55
 * @package:com.raycloud.java.dwd.api.model
 * @Modified By:
 */
@Data
public class ShopsModel {
    @ParamValue(filedName = "city_code",isNotNull = true,filedDesc = "行政区划代码")
    private String city_code;
    @ParamValue(filedName = "external_shopid",isNotNull = true,filedDesc = "外部商家编号")
    private String external_shopid;
    @ParamValue(filedName = "shop_title",isNotNull = true,filedDesc = "商家名称")
    private String shop_title;
    @ParamValue(filedName = "mobile",isNotNull = true,filedDesc = "商家联系电话")
    private String mobile;
    @ParamValue(filedName = "lng",isNotNull = true,filedDesc = "商家经度坐标")
    private Long lng;
    @ParamValue(filedName = "lat",isNotNull = true,filedDesc = "商家纬度坐标")
    private Long lat;
    @ParamValue(filedName = "addr",isNotNull = true,filedDesc = "商家文本地址")
    private String addr;
}
