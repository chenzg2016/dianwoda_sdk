package com.raycloud.java.dwd.api.service;

import com.raycloud.java.dwd.api.model.BatchSaveStoreModel;
import com.raycloud.java.dwd.api.service.back.BackModel;

/**
 * Created by:  intelliJ IDEA
 *
 * @Author albert
 * @Description:
 * @Date:2017/8/23 下午7:14
 * @package:com.raycloud.java.dwd.api.service
 * @Modified By:
 */
public interface BatchSaveStoreService {

    BackModel createStore(BatchSaveStoreModel batchSaveStoreModel);

}
