package com.raycloud.java.dwd.api;

import com.raycloud.java.dwd.api.base.Config;
import com.raycloud.java.dwd.api.model.GetComplainModel;
import com.raycloud.java.dwd.api.model.response.GetRiderPositionResponse;
import com.raycloud.java.dwd.api.service.back.BackModel;
import com.raycloud.java.dwd.api.service.impl.AbstractBaseService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by:  intelliJ IDEA
 *
 * @Author albert
 * @Description:
 * @Date:2017/8/23 上午10:57
 * @package:com.raycloud.java.dwd.api
 * @Modified By:
 */
public class ServiceTest extends AbstractBaseService {
    public ServiceTest(Config config) {
        super(config);
    }


    public static void main(String[] args) throws Exception{
        Config config = new Config("absbbbsss","adcppplkey",false,"localhost");
        ServiceTest serviceTest = new ServiceTest(config);

        GetComplainModel getComplainModel = new GetComplainModel();
        getComplainModel.setComplainType("1");
        getComplainModel.setOrderComplainOriginalId("02");
        getComplainModel.setOrderOriginalId("12345666");

        List<GetRiderPositionResponse> getRiderPositionResponses = new ArrayList<GetRiderPositionResponse>();
        GetRiderPositionResponse getRiderPositionResponse = new GetRiderPositionResponse();
        getRiderPositionResponse.setOrder_original_id("test1");
        getRiderPositionResponse.setRider_code("test1");
        getRiderPositionResponse.setRider_lat(312222222f);
        getRiderPositionResponse.setRider_lng(120333333f);
        getRiderPositionResponse.setRider_mobile("1876872222");
        getRiderPositionResponse.setTime_position_update(System.currentTimeMillis());

        getRiderPositionResponses.add(getRiderPositionResponse);
        getRiderPositionResponse = new GetRiderPositionResponse();
        getRiderPositionResponse.setOrder_original_id("test2");
        getRiderPositionResponse.setRider_code("test2");
        getRiderPositionResponse.setRider_lat(312222222f);
        getRiderPositionResponse.setRider_lng(120333333f);
        getRiderPositionResponse.setRider_mobile("1876872223");
        getRiderPositionResponse.setTime_position_update(System.currentTimeMillis());
        getRiderPositionResponses.add(getRiderPositionResponse);

       BackModel backModel = serviceTest.createBackModel("0",true,"成功",getRiderPositionResponses);

        System.out.println(backModel.getGetRiderPositionResponses().size());

      String param =  serviceTest.requestParam(getComplainModel);

        System.out.println(param);

    }
}
