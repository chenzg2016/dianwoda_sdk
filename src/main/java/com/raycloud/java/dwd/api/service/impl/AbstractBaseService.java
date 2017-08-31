package com.raycloud.java.dwd.api.service.impl;

import com.raycloud.java.dwd.api.base.Config;
import com.raycloud.java.dwd.util.ParamUtils;
import com.raycloud.java.dwd.api.constants.SystemParamConfig;
import com.raycloud.java.dwd.api.model.response.GetComplainResponse;
import com.raycloud.java.dwd.api.model.response.GetOrderResponse;
import com.raycloud.java.dwd.api.model.response.GetRiderPositionResponse;
import com.raycloud.java.dwd.api.model.response.SendOrderResultModel;
import com.raycloud.java.dwd.api.web.impl.WebUtilProxy;
import com.raycloud.java.dwd.api.service.back.BackModel;
import com.raycloud.java.dwd.util.SignatureUtils;
import com.raycloud.java.dwd.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.List;
import java.util.Map;


/**
 * Created by:  intelliJ IDEA
 *
 * @Author albert
 * @Description: 参数
 * @Date:2017/8/22 下午5:00
 * @package:com.raycloud.java.dwd.api.service.impl
 * @Modified By:
 */
public abstract class AbstractBaseService {

    Logger logger = LoggerFactory.getLogger(AbstractBaseService.class);

    private Config config;
    private WebUtilProxy webUtilProxy;


    public AbstractBaseService(Config config) {
        this.config = config;
        this.webUtilProxy = new WebUtilProxy();
    }

    /**
     * 请求参数封装
     * @param object
     * @return
     * @throws Exception
     */
    public String requestParam(Object object)throws Exception{
        try{
            //1、校验必填参数
            String message = ParamUtils.checkParamValue(object);
            //2、判断校验通过
            if (StringUtils.isEmpty(message)){
                StringBuffer paramBuffer = new StringBuffer();
                //3、sig计算
               Map<String,Object> paramMapSig = ParamUtils.paramMapSig(object);
               String sig = SignatureUtils.signatureGenerate(paramMapSig,config.getAppSecret());
               //4、获取系统参数
               String systemParam = SystemParamConfig.getSystemParamSetting(config.getAppKey());
               //5、应用级参数
               String applicationParam = ParamUtils.paramContact(object);
               //6、参数拼接
                paramBuffer.append(systemParam).append(sig).append("&");
                paramBuffer.append(applicationParam);

                return paramBuffer.toString();
            }else{
                throw new Exception(message);
            }
        }catch (IllegalAccessException ie){
            logger.error("点我达checkParamValue校验失败{}",ie);
            throw new Exception("获取参数注解时失败了错误信息",ie);
        }
    }

    /**
     * 配送站点、投诉校验
     * @param objects list
     * @return
     * @throws Exception
     */
    public String checkListModel(Object objects)throws Exception{
        try{
           String message = ParamUtils.checkParamValues(objects);
           return message;
        }catch (IllegalAccessException ie){
            logger.error("点我达checkParamValues校验失败{}",ie);
            throw new Exception("获取参数注解时失败了"+ie);
        }
    }




    /**
     * 执行请求
     * @param param
     * @param action
     * @return String
     * @throws Exception
     */
    public String actionRequest(String param, String action) throws Exception {
        return webUtilProxy.postMethod(config.getBaseUrl() + action, param);
    }

    /**
     * 构造service返回
     * @param errorCode
     * @param success
     * @param message
     * @param object
     * @return
     */
    public BackModel createBackModel(String errorCode,boolean success,String message,Object object){
        BackModel backModel = new BackModel();
        backModel.setMessage(message);
        backModel.setSuccess(success);
        backModel.setErrorCode(errorCode);
        if (null != object){
            if (object instanceof SendOrderResultModel){
                backModel.setSendOrderResultModel((SendOrderResultModel)object);
            }else if (object instanceof GetOrderResponse){
                backModel.setGetOrderResponse((GetOrderResponse)object);
            }else if (object instanceof GetRiderPositionResponse){
                backModel.setGetRiderPositionResponse((GetRiderPositionResponse)object);
            }else if (object instanceof List){
                backModel.setGetRiderPositionResponses((List<GetRiderPositionResponse>) object);
            }else if (object instanceof GetComplainResponse){
                backModel.setGetComplainResponse((GetComplainResponse)object);
            }
        }

        return backModel;
    }

}
