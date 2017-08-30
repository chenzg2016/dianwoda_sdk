package com.raycloud.java.dwd.api.service.impl;

import com.alibaba.fastjson.JSON;
import com.raycloud.java.dwd.api.base.Config;
import com.raycloud.java.dwd.api.constants.DwdUrlConstant;
import com.raycloud.java.dwd.api.constants.MessageConstant;
import com.raycloud.java.dwd.api.constants.SystemParamConfig;
import com.raycloud.java.dwd.api.enums.DwdStatusEnum;
import com.raycloud.java.dwd.api.model.*;
import com.raycloud.java.dwd.api.model.response.GetOrderResponse;
import com.raycloud.java.dwd.api.model.response.ResponseModel;
import com.raycloud.java.dwd.api.model.response.SendOrderResultModel;
import com.raycloud.java.dwd.api.service.OrderService;
import com.raycloud.java.dwd.api.service.back.BackModel;
import com.raycloud.java.dwd.callback.impl.OrderCallbackServiceImpl;
import com.raycloud.java.dwd.util.StringUtils;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by:  intelliJ IDEA
 *
 * @Author albert
 * @Description:
 * @Date:2017/8/23 上午10:23
 * @package:com.raycloud.java.dwd.api.service.impl
 * @Modified By:
 */
public class OrderServiceImpl extends AbstractBaseService implements OrderService {

    private Logger logger = Logger.getLogger(OrderCallbackServiceImpl.class);

    public OrderServiceImpl(Config config) {
        super(config);
    }

    @Override
    public BackModel orderSend(OrderSendModel orderSendModel) {
        String requestPath = DwdUrlConstant.ORDER_SEND;
        ResponseModel responseModel = null;
        try {
            if (StringUtils.notEmpty(orderSendModel.getItems())){
                List<OrderItemsModel> orderItemsModels = JSON.parseArray(orderSendModel.getItems(),OrderItemsModel.class);
                String message = checkListModel(orderItemsModels);
                if (StringUtils.notEmpty(message)){
                    return createBackModel(MessageConstant.SYSTEM_ERROR, false,
                            "发单失败，信息：" + message, null);
                }
            }
            String requestParam = requestParam(orderSendModel);
            String result = actionRequest(requestParam, requestPath);
            responseModel = new ResponseModel();
            responseModel = JSON.parseObject(result, ResponseModel.class);
            if (responseModel.isSuccess()) {
                //解析result
                SendOrderResultModel sendOrderResultModel = new SendOrderResultModel();
                sendOrderResultModel = JSON.parseObject(responseModel.getResult(), SendOrderResultModel.class);
                // 定义返回结果
                return createBackModel(responseModel.getErrorCode(), responseModel.isSuccess(),
                        "发单成功！", sendOrderResultModel);
            } else {
                //定义返回结果
                return createBackModel(responseModel.getErrorCode(), responseModel.isSuccess(),
                        "发单失败，信息：" + responseModel.getMessage(), null);
            }
        } catch (Exception e) {
            logger.error("发单失败", e);
            //定义返回结果
            return createBackModel(MessageConstant.SYSTEM_ERROR, false,
                    "发单失败，信息：" + e.getMessage(), null);
        }
    }

    @Override
    public BackModel getOrderInfo(GetOrderModel getOrderModel) {
        String requestPath = DwdUrlConstant.ORDER_GET;
        ResponseModel responseModel = null;
        try {
            String requestParam = requestParam(getOrderModel);
            String result = actionRequest(requestParam, requestPath);
            responseModel = new ResponseModel();
            responseModel = JSON.parseObject(result, ResponseModel.class);
            if (responseModel.isSuccess()) {
                GetOrderResponse getOrderResponse = new GetOrderResponse();
                getOrderResponse = JSON.parseObject(responseModel.getResult(), GetOrderResponse.class);

                return createBackModel(responseModel.getErrorCode(), true,
                        "获取订单成功", getOrderResponse);
            } else {
                return createBackModel(responseModel.getErrorCode(), false,
                        "获取订单失败:" + responseModel.getMessage(), null);
            }
        } catch (Exception e) {
            logger.error("获取订单失败", e);
            return createBackModel(MessageConstant.SYSTEM_ERROR, false,
                    "获取订单失败:" + e.getMessage(), null);
        }
    }

    @Override
    public BackModel cancelOrder(CancelOrderModel cancelOrderModel) {
        String requestPath = DwdUrlConstant.ORDER_CANCEL;
        ResponseModel responseModel = null;
        try {
            String message = checkOrderStatus(cancelOrderModel.getOrderOriginalId(),
                    MessageConstant.CANCEL);

            if (StringUtils.notEmpty(message)){
                return createBackModel(MessageConstant.SYSTEM_ERROR, false,
                        "取消失败:" + message, null);
            }
            String requestParam = requestParam(cancelOrderModel);
            String result = actionRequest(requestParam, requestPath);
            responseModel = new ResponseModel();
            responseModel = JSON.parseObject(result, ResponseModel.class);
            if (responseModel.isSuccess()) {
                return createBackModel(responseModel.getErrorCode(), true,
                        "操作成功", null);
            } else {
                return createBackModel(responseModel.getErrorCode(), false,
                        "取消失败:" + responseModel.getMessage(), null);
            }
        } catch (Exception e) {
            logger.error("取消失败", e);
            return createBackModel(MessageConstant.SYSTEM_ERROR, false,
                    "操作失败:" + e.getMessage(), null);
        }
    }

    @Override
    public BackModel updateOrderRemark(UpdateRemarkModel updateRemarkModel) {
        String requestPath = DwdUrlConstant.ORDER_UPDATE_REMARK;
        ResponseModel responseModel = null;
        try {
            //校验状态
            String message = checkOrderStatus(updateRemarkModel.getOrderOriginalId(),
                    MessageConstant.UPDATE_MARK);
            if (StringUtils.notEmpty(message)){
                return createBackModel(MessageConstant.SYSTEM_ERROR, false,
                        "更新订单备注失败:" + message, null);
            }
            String requestParam = requestParam(updateRemarkModel);
            String result = actionRequest(requestParam, requestPath);
            responseModel = new ResponseModel();
            responseModel = JSON.parseObject(result, ResponseModel.class);
            if (responseModel.isSuccess()) {
                return createBackModel(responseModel.getErrorCode(), true,
                        "操作成功", null);
            } else {
                return createBackModel(responseModel.getErrorCode(), false,
                        "更新订单备注失败：" + responseModel.getMessage(), null);
            }
        } catch (Exception e) {
            logger.error("更新订单备注失败", e);
            return createBackModel(MessageConstant.SYSTEM_ERROR, false,
                    "更新订单备注失败：" + e.getMessage(), null);
        }
    }

    @Override
    public BackModel updateOrderTip(OrderTipModel orderTipModel) {
        String requestPath = DwdUrlConstant.ORDER_TIP;
        ResponseModel responseModel = null;
        try {
            //校验状态
            String message = checkOrderStatus(orderTipModel.getOrderOriginalId(),
                    MessageConstant.UPDATE_TIP);
            if (StringUtils.notEmpty(message)){
                return createBackModel(MessageConstant.SYSTEM_ERROR, false,
                        "新增小费失败:" + message, null);
            }
            String requestParam = requestParam(orderTipModel);
            String result = actionRequest(requestParam, requestPath);
            responseModel = new ResponseModel();
            responseModel = JSON.parseObject(result, ResponseModel.class);
            if (responseModel.isSuccess()) {
                return createBackModel(responseModel.getErrorCode(), true,
                        "新增小费成功", null);
            } else {
                return createBackModel(responseModel.getErrorCode(), false,
                        "新增小费失败：" + responseModel.getMessage(), null);
            }
        } catch (Exception e) {
            logger.error("新增小费失败", e);
            return createBackModel(MessageConstant.SYSTEM_ERROR, false,
                    "新增小费失败：" + e.getMessage(), null);
        }
    }

    /**
     * 校验订单状态是否可以操作
     * @param orderId
     * @param type
     * @return
     */
    private String checkOrderStatus(String orderId, int type) {
        String message = null;
        GetOrderModel getOrderModel = new GetOrderModel();
        getOrderModel.setOrderOriginalId(orderId);
        BackModel backModel = getOrderInfo(getOrderModel);
        if (backModel.isSuccess()) {
            Integer status = backModel.getGetOrderResponse().getOrder_status();
            if (type == MessageConstant.CANCEL) {
                //0 3 5 10
                if (status < DwdStatusEnum.DELIVERY_ORDER.getCode()) {
                    return message;
                } else {
                    message = "当前订单状态不能取消";
                }
            } else if (type == MessageConstant.UPDATE_MARK) {
                if (status == DwdStatusEnum.ACCESS_ORDER.getCode() ||
                        status == DwdStatusEnum.DELIVERY_ORDER.getCode()) {
                    return message;
                } else {
                    message = "当前订单状态不能更新备注";
                }
            } else if (type == MessageConstant.UPDATE_TIP) {
                // 0 3 5 10
                if (status < DwdStatusEnum.DELIVERY_ORDER.getCode()) {
                    return message;
                } else {
                    message = "当前订单状态不能追加小费";
                }
            }
        } else {
            return message = "查询不到订单信息";
        }
        return message;
    }
}
