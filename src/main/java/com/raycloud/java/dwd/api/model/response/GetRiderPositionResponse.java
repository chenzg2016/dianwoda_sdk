package com.raycloud.java.dwd.api.model.response;

import lombok.Data;

/**
 * Created by:  intelliJ IDEA
 *
 * @Author albert
 * @Description:获取配送员位置信息（批量）
 * @Date:2017/8/22 下午8:27
 * @package:com.raycloud.java.dwd.api.model.callback
 * @Modified By:
 */
@Data
public class GetRiderPositionResponse {
    private String order_original_id;
    private String rider_code;
    private String rider_mobile;
    private Float rider_lat;
    private Float rider_lng;
    private Long time_position_update;

}
