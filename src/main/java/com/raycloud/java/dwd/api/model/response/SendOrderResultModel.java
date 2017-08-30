package com.raycloud.java.dwd.api.model.response;

import lombok.Data;

/**
 * Created by:  intelliJ IDEA
 *
 * @Author albert
 * @Description: 订单派送成功后返回true的result结果信息
 * @Date:2017/8/22 下午6:10
 * @package:com.raycloud.java.dwd.api.model.callback
 * @Modified By:
 */
@Data
public class SendOrderResultModel {
    private String dwd_order_id;

    private String skycon;

    private String price;

    private String distance;

}
