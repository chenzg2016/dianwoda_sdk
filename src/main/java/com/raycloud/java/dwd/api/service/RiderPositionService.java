package com.raycloud.java.dwd.api.service;

import com.raycloud.java.dwd.api.model.BatchGetRiderPositionModel;
import com.raycloud.java.dwd.api.model.GetRiderPositionModel;
import com.raycloud.java.dwd.api.service.back.BackModel;

/**
 * Created by:  intelliJ IDEA
 *
 * @Author albert
 * @Description:配送员位置信息
 * @Date:2017/8/23 下午5:31
 * @package:com.raycloud.java.dwd.api.service
 * @Modified By:
 */
public interface RiderPositionService {

    /**
     * 获取单个配送员信息
     * @param getRiderPositionModel
     * @return
     */
    BackModel getRiderPosition(GetRiderPositionModel getRiderPositionModel);


    /**
     * 批量获取配送员位置订单到达终态后（已完成、已取消、异常）则不再返回
     * 最大支持20个订单的配送员位置，且必须在同一个城市。
     * @param batchGetRiderPositionModel
     * @return
     */
    BackModel getBatchRiderPosition(BatchGetRiderPositionModel batchGetRiderPositionModel);


}
