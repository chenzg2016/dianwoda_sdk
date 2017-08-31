package com.raycloud.java.dwd.callback.impl;

import com.alibaba.fastjson.JSON;
import com.raycloud.java.dwd.api.base.Config;
import com.raycloud.java.dwd.api.constants.DwdUrlConstant;
import com.raycloud.java.dwd.api.constants.MessageConstant;
import com.raycloud.java.dwd.api.model.response.OrderOptionModel;
import com.raycloud.java.dwd.api.model.response.ResponseModel;
import com.raycloud.java.dwd.api.service.back.BackModel;
import com.raycloud.java.dwd.api.service.impl.AbstractBaseService;
import com.raycloud.java.dwd.callback.OrderCallbackService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by:  intelliJ IDEA
 *
 * @Author albert
 * @Description:测试环境模拟操作
 * @Date:2017/8/24 上午10:52
 * @package:com.raycloud.java.dwd.callback.impl
 * @Modified By:
 */
public class OrderCallbackServiceImpl extends AbstractBaseService implements OrderCallbackService {

    private Logger logger = LoggerFactory.getLogger(OrderCallbackServiceImpl.class);

    public OrderCallbackServiceImpl(Config config) {
        super(config);
    }

    @Override
    public BackModel acceptOrder(OrderOptionModel orderOptionModel) {
        String requestPath = DwdUrlConstant.ORDER_ACCEPTED_TEST;
        ResponseModel responseModel = null;
        try {
            String requestParam = requestParam(orderOptionModel);
            String result = actionRequest(requestParam, requestPath);
            responseModel = new ResponseModel();
            responseModel = JSON.parseObject(result, ResponseModel.class);
            if (responseModel.isSuccess()) {
                return createBackModel(responseModel.getErrorCode(), true,
                        "操作成功", null);
            } else {
                return createBackModel(responseModel.getErrorCode(), false,
                        "模拟接受订单失败" + responseModel.getMessage(), null);
            }
        } catch (Exception e) {
            logger.error("模拟接受订单失败",e);
            return createBackModel(MessageConstant.SYSTEM_ERROR, false,
                    "模拟接受订单失败" + e.getMessage(), null);
        }

    }

    @Override
    public BackModel arrivedShop(OrderOptionModel orderOptionModel) {
        String requestPath = DwdUrlConstant.ORDER_ARRIVE_TEST;
        ResponseModel responseModel = null;
        try {
            String requestParam = requestParam(orderOptionModel);
            String result = actionRequest(requestParam, requestPath);
            responseModel = new ResponseModel();
            responseModel = JSON.parseObject(result, ResponseModel.class);
            if (responseModel.isSuccess()) {
                return createBackModel(responseModel.getErrorCode(), true,
                        "操作成功", null);
            } else {
                return createBackModel(responseModel.getErrorCode(), false,
                        "模拟到店失败" + responseModel.getMessage(), null);
            }
        } catch (Exception e) {
            logger.error("模拟到店失败",e);
            return createBackModel(MessageConstant.SYSTEM_ERROR, false,
                    "模拟到店失败" + e.getMessage(), null);
        }
    }

    @Override
    public BackModel finishPackage(OrderOptionModel orderOptionModel) {
        String requestPath = DwdUrlConstant.ORDER_FETCH_TEST;
        ResponseModel responseModel = null;
        try {
            String requestParam = requestParam(orderOptionModel);
            String result = actionRequest(requestParam, requestPath);
            responseModel = new ResponseModel();
            responseModel = JSON.parseObject(result, ResponseModel.class);
            if (responseModel.isSuccess()) {
                return createBackModel(responseModel.getErrorCode(), true,
                        "操作成功", null);
            } else {
                return createBackModel(responseModel.getErrorCode(), false,
                        "模拟完成取货失败" + responseModel.getMessage(), null);
            }
        } catch (Exception e) {
            logger.error("模拟完成取货失败",e);
            return createBackModel(MessageConstant.SYSTEM_ERROR, false,
                    "模拟完成取货失败" + e.getMessage(), null);
        }
    }

    @Override
    public BackModel finishDelivery(OrderOptionModel orderOptionModel) {
        String requestPath = DwdUrlConstant.ORDER_FINISH_TEST;
        ResponseModel responseModel = null;
        try {
            String requestParam = requestParam(orderOptionModel);
            String result = actionRequest(requestParam, requestPath);
            responseModel = new ResponseModel();
            responseModel = JSON.parseObject(result, ResponseModel.class);
            if (responseModel.isSuccess()) {
                return createBackModel(responseModel.getErrorCode(), true,
                        "操作成功", null);
            } else {
                return createBackModel(responseModel.getErrorCode(), false,
                        "模拟配送完成失败" + responseModel.getMessage(), null);
            }
        } catch (Exception e) {
            logger.error("模拟配送完成失败",e);
            return createBackModel(MessageConstant.SYSTEM_ERROR, false,
                    "模拟配送完成失败" + e.getMessage(), null);
        }
    }
}
