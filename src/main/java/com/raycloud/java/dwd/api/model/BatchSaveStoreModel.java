package com.raycloud.java.dwd.api.model;

import com.raycloud.java.dwd.annotation.ParamValue;
import lombok.Data;

/**
 * Created by:  intelliJ IDEA
 *
 * @Author albert
 * @Description:创建配送站点
 * @Date:2017/8/22 上午9:52
 * @package:com.raycloud.java.dwd.api.model
 * @Modified By:
 */
@Data
public class BatchSaveStoreModel {
    @ParamValue(filedName = "shops",isNotNull = true,filedDesc = "shops json数组")
    private String shops;
}
