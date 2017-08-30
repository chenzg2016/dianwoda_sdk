package com.raycloud.java.dwd.api.service.impl;

import com.alibaba.fastjson.JSON;
import com.raycloud.java.dwd.api.base.Config;
import com.raycloud.java.dwd.api.constants.DwdUrlConstant;
import com.raycloud.java.dwd.api.constants.MessageConstant;
import com.raycloud.java.dwd.api.model.BatchSaveStoreModel;
import com.raycloud.java.dwd.api.model.ShopsModel;
import com.raycloud.java.dwd.api.model.response.ResponseModel;
import com.raycloud.java.dwd.api.service.BatchSaveStoreService;
import com.raycloud.java.dwd.api.service.back.BackModel;
import com.raycloud.java.dwd.util.StringUtils;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by:  intelliJ IDEA
 *
 * @Author albert
 * @Description:批量创建配送站点
 * @Date:2017/8/23 下午7:26
 * @package:com.raycloud.java.dwd.api.service.impl
 * @Modified By:
 */
public class BatchSaveStoreServiceImpl extends AbstractBaseService implements BatchSaveStoreService {

    private Logger logger = Logger.getLogger(BatchSaveStoreServiceImpl.class);

    public BatchSaveStoreServiceImpl(Config config) {
        super(config);
    }

    @Override
    public BackModel createStore(BatchSaveStoreModel batchSaveStoreModel) {
        String requestPath = DwdUrlConstant.BATCH_SAVE_STORE;
        ResponseModel responseModel = null;
        try {
            //校验shops是否正常
            List<ShopsModel> shopsModels = new ArrayList<ShopsModel>();
            shopsModels = JSON.parseArray(batchSaveStoreModel.getShops(),ShopsModel.class);
            //校验json中单个shop是否正常
            String message = checkListModel(shopsModels);
            if (StringUtils.notEmpty(message)){
                return createBackModel(MessageConstant.SYSTEM_ERROR,false,message,null);
            }
            String requestParam = requestParam(batchSaveStoreModel);
            String result = actionRequest(requestParam, requestPath);
            responseModel = new ResponseModel();
            responseModel = JSON.parseObject(result, ResponseModel.class);
            if (responseModel.isSuccess()) {
                return createBackModel(responseModel.getErrorCode(), true,
                        "创建站点完成", null);
            } else {
                return createBackModel(responseModel.getErrorCode(), false,
                        "创建站点失败" + responseModel.getMessage(), null);
            }
        } catch (Exception e) {
            logger.error("创建站点失败",e);
            return createBackModel(MessageConstant.SYSTEM_ERROR, false,
                    "创建站点失败" + e.getMessage(), null);
        }
    }
}
