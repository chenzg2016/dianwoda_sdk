package com.raycloud.java.dwd.api.service;

import com.raycloud.java.dwd.api.model.*;
import com.raycloud.java.dwd.api.service.back.BackModel;

/**
 * Created by:  intelliJ IDEA
 *
 * @Author albert
 * @Description:点我达订单service
 * @Date:2017/8/22 下午5:45
 * @package:com.raycloud.java.dwd.api.service.impl
 * @Modified By:
 */
public interface OrderService {

    /**
     * 订单发送接口
     * @param orderSendModel 生成时需要设置callback，callback在config中
     * @return
     */
   BackModel orderSend(OrderSendModel orderSendModel);

    /**
     * 获取订单信息
     * @param getOrderModel
     * @return
     */
   BackModel getOrderInfo(GetOrderModel getOrderModel);

    /**
     * 取消订单接口（订单在“派单中”、“取货中”、“已到店”状态下，允许正常取消点我达配送订单）
     * @param cancelOrderModel
     * @return
     */
   BackModel cancelOrder(CancelOrderModel cancelOrderModel);

    /**
     *  修改订单的备注信息（仅限“派单中”、“配送中”状态时调用）
     * @param updateRemarkModel
     * @return
     */
   BackModel updateOrderRemark(UpdateRemarkModel updateRemarkModel);

    /**
     * 设置订单小费骑手离店前（订单状态为 [已下单] 、[已派单]、[已到店]），
     * 上游接入方可根据渠道订单编号order_original_id，确定更新小费的总金额（可多次更新）。
     * 小费总额不超过50元RMB。
     * 注意：小费总金额不能小于等于上一次的小费总金额。
     * @param orderTipModel
     * @return
     */
   BackModel updateOrderTip(OrderTipModel orderTipModel);

}
