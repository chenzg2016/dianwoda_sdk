package com.raycloud.java.dwd.api.service;

import com.raycloud.java.dwd.api.model.GetComplainModel;
import com.raycloud.java.dwd.api.model.OrderComplainModel;
import com.raycloud.java.dwd.api.service.back.BackModel;

/**
 * Created by:  intelliJ IDEA
 *
 * @Author albert
 * @Description:
 * @Date:2017/8/23 下午6:02
 * @package:com.raycloud.java.dwd.api.service
 * @Modified By:
 */
public interface OrderComplainService {

    /**
     * 订单投诉
     * @param orderComplainModel
     * @return
     */
    BackModel orderComplain(OrderComplainModel orderComplainModel);

    /**
     * 查询投诉结果
     * @param getComplainModel
     * @return
     */
    BackModel searComplainResult(GetComplainModel getComplainModel);


}
