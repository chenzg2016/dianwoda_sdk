package com.raycloud.java.dwd.api.model.response;

import lombok.Data;

import java.util.List;

/**
 * Created by:  intelliJ IDEA
 *
 * @Author albert
 * @Description:
 * @Date:2017/8/22 下午6:59
 * @package:com.raycloud.java.dwd.api.model.callback
 * @Modified By:
 */
@Data
public class GetOrderResponse {

    private String dwd_order_id;
    private String order_original_id;
    private Integer order_status;
    private Long time_status_update;
    private Integer service_type;
    private String abnormal_reason;
    private String rider_code;
    private String rider_name;
    private Double rider_lat;
    private Double rider_lng;
    private String rider_mobile;
    private Long time_position_update;
    private Long time_estimated_pickup;
    private String am_name;
    private String am_mobile;
    private List<LogisticInfo> logistic_info;

}

@Data
class LogisticInfo{
    private Integer order_status;

    private Long time_status_update;
}
