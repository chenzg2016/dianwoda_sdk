package com.raycloud.java.dwd.api;

import com.raycloud.java.dwd.api.web.WebUtilService;
import com.raycloud.java.dwd.api.web.impl.WebUtilProxy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by:  intelliJ IDEA
 *
 * @Author albert
 * @Description:
 * @Date:2017/8/21 下午3:02
 * @package:com.raycloud.java.dwd.api
 * @Modified By:
 */
public class TestRequest {

    public static void main(String[] args)throws Exception {
        WebUtilService httpRequest = new WebUtilProxy();

        Map<String,Object> paramMap = new HashMap<String, Object>();
        paramMap.put("a1","测试1");
        paramMap.put("a2","测试1");
        paramMap.put("a3","测试3");
        paramMap.put("a4","测试2");

        String apm = "a1=测试1&a2=测试2";

        String url = "http://www.baidu.com";

        String result = (String) httpRequest.postMethod(url,apm);
        System.out.println(result);




    }

}
