package com.raycloud.java.dwd.api;

import com.raycloud.java.dwd.util.ParamUtils;
import com.raycloud.java.dwd.api.model.GetComplainModel;
import com.raycloud.java.dwd.util.SignatureUtils;
import com.raycloud.java.dwd.util.StringUtils;

import java.util.Map;

/**
 * Created by:  intelliJ IDEA
 *
 * @Author albert
 * @Description:
 * @Date:2017/8/22 下午4:04
 * @package:com.raycloud.java.dwd.api
 * @Modified By:
 */
public class ParamServiceTest {

    public static void main(String[] args)throws Exception {
        GetComplainModel getComplainModel = new GetComplainModel();
        //getComplainModel.setComplainType("1");
        getComplainModel.setOrderComplainOriginalId("02");
        getComplainModel.setOrderOriginalId("12345666");

        String message = ParamUtils.checkParamValue(getComplainModel);
        if (StringUtils.isEmpty(message)){
            String result = ParamUtils.paramContact(getComplainModel);
            Map<String,Object> param = ParamUtils.paramMapSig(getComplainModel);
            for (String key:param.keySet()){
                System.out.println(key +"="+ param.get(key));
            }
            String sig = SignatureUtils.signatureGenerate(param,"asdddddmmnvbff");
            System.out.println(sig);
            System.out.println(result);
        }
        System.out.println(message);

        System.out.println(System.currentTimeMillis());

        String arg = null;

        System.out.println(StringUtils.isEmpty(arg));




    }
}
