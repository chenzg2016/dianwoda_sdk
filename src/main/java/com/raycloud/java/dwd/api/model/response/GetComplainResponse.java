package com.raycloud.java.dwd.api.model.response;

import lombok.Data;

/**
 * Created by:  intelliJ IDEA
 *
 * @Author albert
 * @Description: 查询投诉信息
 * @Date:2017/8/23 下午3:27
 * @package:com.raycloud.java.dwd.api.model.response
 * @Modified By:
 */
@Data
public class GetComplainResponse {

    private String order_complain_original_id;
    private String order_original_id;
    private String complain_type;
    private String reason;
    private Integer result;
    private String result_content;

}
