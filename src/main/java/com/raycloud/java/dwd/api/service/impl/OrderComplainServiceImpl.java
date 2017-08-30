package com.raycloud.java.dwd.api.service.impl;

import com.alibaba.fastjson.JSON;
import com.raycloud.java.dwd.api.base.Config;
import com.raycloud.java.dwd.api.constants.DwdUrlConstant;
import com.raycloud.java.dwd.api.constants.MessageConstant;
import com.raycloud.java.dwd.api.model.ComplainContent;
import com.raycloud.java.dwd.api.model.GetComplainModel;
import com.raycloud.java.dwd.api.model.OrderComplainModel;
import com.raycloud.java.dwd.api.model.response.GetComplainResponse;
import com.raycloud.java.dwd.api.model.response.ResponseModel;
import com.raycloud.java.dwd.api.service.OrderComplainService;
import com.raycloud.java.dwd.api.service.back.BackModel;
import com.raycloud.java.dwd.util.StringUtils;
import org.apache.log4j.Logger;

import java.util.List;


/**
 * Created by:  intelliJ IDEA
 *
 * @Author albert
 * @Description:
 * @Date:2017/8/24 下午1:34
 * @package:com.raycloud.java.dwd.api.service.impl
 * @Modified By:
 */
public class OrderComplainServiceImpl extends AbstractBaseService implements OrderComplainService {

    private Logger logger = Logger.getLogger(OrderComplainServiceImpl.class);

    public OrderComplainServiceImpl(Config config) {
        super(config);
    }

    @Override
    public BackModel orderComplain(OrderComplainModel orderComplainModel) {
        String requestPath = DwdUrlConstant.ORDER_COMPLAIN;
        ResponseModel responseModel = null;
        try {
            //校验complain_content
            if (StringUtils.isEmpty(orderComplainModel.getComplainContent())){
                return createBackModel(MessageConstant.SYSTEM_ERROR, false,
                        "订单投诉失败:投诉内容不能为空"  , null);
            }
            List<ComplainContent> contents = JSON.parseArray(orderComplainModel.getComplainContent(),ComplainContent.class);
            String message = checkListModel(contents);
            if (StringUtils.notEmpty(message)){
                return createBackModel(MessageConstant.SYSTEM_ERROR, false,
                        "订单投诉失败:" + message, null);
            }
            String requestParam = requestParam(orderComplainModel);
            String result = actionRequest(requestParam, requestPath);
            responseModel = new ResponseModel();
            responseModel = JSON.parseObject(result, ResponseModel.class);
            if (responseModel.isSuccess()) {
                return createBackModel(responseModel.getErrorCode(), true,
                        "操作成功", null);
            } else {
                return createBackModel(responseModel.getErrorCode(), false,
                        "订单投诉失败" + responseModel.getMessage(), null);
            }
        } catch (Exception e) {
            logger.error("订单投诉失败",e);
            return createBackModel(MessageConstant.SYSTEM_ERROR, false,
                    "订单投诉失败" + e.getMessage(), null);
        }

    }

    @Override
    public BackModel searComplainResult(GetComplainModel getComplainModel) {
        String requestPath = DwdUrlConstant.ORDER_GET_COMPLAIN;
        ResponseModel responseModel = null;
        try {
            String requestParam = requestParam(getComplainModel);
            String result = actionRequest(requestParam, requestPath);
            responseModel = new ResponseModel();
            responseModel = JSON.parseObject(result, ResponseModel.class);
            if (responseModel.isSuccess()) {

                GetComplainResponse getComplainResponse = JSON.parseObject(responseModel.getResult(),GetComplainResponse.class);

                return createBackModel(responseModel.getErrorCode(), true,
                        "操作成功", getComplainResponse);
            } else {
                return createBackModel(responseModel.getErrorCode(), false,
                        "订单投诉失败" + responseModel.getMessage(), null);
            }
        } catch (Exception e) {
            logger.error("订单投诉失败",e);
            return createBackModel(MessageConstant.SYSTEM_ERROR, false,
                    "订单投诉失败" + e.getMessage(), null);
        }
    }
}
