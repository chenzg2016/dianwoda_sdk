package com.raycloud.java.dwd.callback;

import com.raycloud.java.dwd.api.model.response.OrderOptionModel;
import com.raycloud.java.dwd.api.service.back.BackModel;

/**
 * Created by:  intelliJ IDEA
 *
 * @Author albert
 * @Description:
 * @Date:2017/8/24 上午10:37
 * @package:com.raycloud.java.dwd.callback
 * @Modified By:
 */
public interface OrderCallbackService {

    /**
     * 模拟接受订单
     * @param orderOptionModel
     * @return
     */
    BackModel acceptOrder(OrderOptionModel orderOptionModel);

    /**
     * 模拟到店
     * @param orderOptionModel
     * @return
     */
    BackModel arrivedShop(OrderOptionModel orderOptionModel);

    /**
     * 模拟完成取货
     * @param orderOptionModel
     * @return
     */
    BackModel finishPackage(OrderOptionModel orderOptionModel);

    /**
     * 模拟配送完成
     * @param orderOptionModel
     * @return
     */
    BackModel finishDelivery(OrderOptionModel orderOptionModel);


}
