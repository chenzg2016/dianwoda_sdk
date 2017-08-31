package com.raycloud.java.dwd.api.service.impl;

import com.alibaba.fastjson.JSON;
import com.raycloud.java.dwd.api.base.Config;
import com.raycloud.java.dwd.api.constants.DwdUrlConstant;
import com.raycloud.java.dwd.api.constants.MessageConstant;
import com.raycloud.java.dwd.api.model.BatchGetRiderPositionModel;
import com.raycloud.java.dwd.api.model.GetRiderPositionModel;
import com.raycloud.java.dwd.api.model.response.GetRiderPositionResponse;
import com.raycloud.java.dwd.api.model.response.ResponseModel;
import com.raycloud.java.dwd.api.service.RiderPositionService;
import com.raycloud.java.dwd.api.service.back.BackModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by:  intelliJ IDEA
 *
 * @Author albert
 * @Description:获取配送员位置实现
 * @Date:2017/8/23 下午5:42
 * @package:com.raycloud.java.dwd.api.service.impl
 * @Modified By:
 */
public class RiderPositionServiceImpl extends AbstractBaseService implements RiderPositionService {

    private Logger logger = LoggerFactory.getLogger(RiderPositionServiceImpl.class);

    public RiderPositionServiceImpl(Config config) {
        super(config);
    }

    @Override
    public BackModel getRiderPosition(GetRiderPositionModel getRiderPositionModel) {
        String requestPath = DwdUrlConstant.ORDER_RIDER_POSITION;
        ResponseModel responseModel = null;
        try {
            String requestParam = requestParam(getRiderPositionModel);
            String result = actionRequest(requestParam, requestPath);
            responseModel = new ResponseModel();
            responseModel = JSON.parseObject(result, ResponseModel.class);
            if (responseModel.isSuccess()) {
                GetRiderPositionResponse getRiderPositionResponse = new GetRiderPositionResponse();
                getRiderPositionResponse = JSON.parseObject(responseModel.getResult(),GetRiderPositionResponse.class);
                return createBackModel(responseModel.getErrorCode(), true,
                        "查询完成", getRiderPositionResponse);
            } else {
                return createBackModel(responseModel.getErrorCode(), false,
                        "查询失败" + responseModel.getMessage(), null);
            }
        } catch (Exception e) {
            logger.error("查询失败",e);
            return createBackModel(MessageConstant.SYSTEM_ERROR, false,
                    "查询失败" + e.getMessage(), null);
        }

    }

    @Override
    public BackModel getBatchRiderPosition(BatchGetRiderPositionModel batchGetRiderPositionModel) {
        String requestPath = DwdUrlConstant.ORDER_BATCH_RIDER_POSITION;
        ResponseModel responseModel = null;
        try {
            String[] size = batchGetRiderPositionModel.getOrderOriginalIds().split(",");
            if (size.length > 20){
                return createBackModel(MessageConstant.SYSTEM_ERROR, false,
                        "查询失败，查询个数超限制个数20",null);
            }else{
                String requestParam = requestParam(batchGetRiderPositionModel);
                String result = actionRequest(requestParam, requestPath);
                responseModel = new ResponseModel();
                responseModel = JSON.parseObject(result, ResponseModel.class);
                if (responseModel.isSuccess()) {
                    List<GetRiderPositionResponse> getRiderPositionResponses = new ArrayList<GetRiderPositionResponse>();
                    getRiderPositionResponses = JSON.parseArray(responseModel.getResult(),GetRiderPositionResponse.class);
                    return createBackModel(responseModel.getErrorCode(), true,
                            "查询完成", getRiderPositionResponses);
                } else {
                    return createBackModel(responseModel.getErrorCode(), false,
                            "查询失败" + responseModel.getMessage(), null);
                }
            }
        } catch (Exception e) {
            logger.error("批量查询失败",e);
            return createBackModel(MessageConstant.SYSTEM_ERROR, false,
                    "查询失败" + e.getMessage(), null);
        }
    }
}
