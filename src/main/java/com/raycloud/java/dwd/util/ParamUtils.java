package com.raycloud.java.dwd.util;

import com.raycloud.java.dwd.annotation.ParamValue;
import com.raycloud.java.dwd.util.StringUtils;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by:  intelliJ IDEA
 *
 * @Author albert
 * @Description: 请求参数校验和封装
 * @Date:2017/8/22 下午2:52
 * @package:com.raycloud.java.dwd.api.base
 * @Modified By:
 */
public class ParamUtils {

    private ParamUtils(){

    }

    /**
     * 参数校验
     *
     * @param object
     * @return
     * @throws IllegalAccessException
     */
    public static String checkParamValue(Object object) throws IllegalAccessException {
        StringBuffer messageBuff = new StringBuffer();
        //1、获取类字段
        List<Field> fields = Arrays.asList(object.getClass().getDeclaredFields());
        //2、判断是否使用ParamValue注解
        for (Field field : fields) {
            if (field.isAnnotationPresent(ParamValue.class)) {
                ParamValue paramValue = field.getAnnotation(ParamValue.class);
                //是否必填
                if (paramValue.isNotNull()) {
                    field.setAccessible(true);
                    Object val = field.get(object);
                    if ("".equals(val) || null == val) {
                        messageBuff.append(paramValue.filedDesc() + "必填\n");
                    }
                }
            }
        }
        return messageBuff.toString();
    }


    /**
     * 校验List<object>
     * @param objects
     * @return
     * @throws IllegalAccessException
     */
    public static String checkParamValues(Object objects) throws IllegalAccessException {
        int count = 1;
        StringBuffer messageBuff = new StringBuffer();
        List<Object> checkObjects= (List)objects;
        for (Object object : checkObjects) {
            String message = checkParamValue(object);
            if (StringUtils.notEmpty(message)){
                message = "第"+count+"个数组信息："+message;
            }
            messageBuff.append(message);
            count++;
        }

        return messageBuff.toString();
}


    /**
     * 运用（请求接口）参数拼接
     *
     * @param object
     * @return
     */
    public static String paramContact(Object object) throws IllegalAccessException {
        StringBuffer paramBuff = new StringBuffer();
        String result = null;
        //1、获取类字段
        List<Field> fields = Arrays.asList(object.getClass().getDeclaredFields());
        //2、判断是否使用ParamValue注解
        for (Field field : fields) {
            if (field.isAnnotationPresent(ParamValue.class)) {
                ParamValue paramValue = field.getAnnotation(ParamValue.class);
                field.setAccessible(true);
                Object val = field.get(object);
                if (null != val || "".equals(val))
                    paramBuff.append(paramValue.filedName()).append("=").append(val).append("&");
            }
        }
        result = paramBuff.toString();
        //3、去除最后一个end
        result = result.substring(0, result.lastIndexOf("&"));

        return result;
    }

    /**
     * @param object
     * @return
     * @throws IllegalAccessException
     */
    public static Map<String, Object> paramMapSig(Object object) throws IllegalAccessException {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        //1、获取类字段
        List<Field> fields = Arrays.asList(object.getClass().getDeclaredFields());
        //2、判断是否使用ParamValue注解
        for (Field field : fields) {
            if (field.isAnnotationPresent(ParamValue.class)) {
                ParamValue paramValue = field.getAnnotation(ParamValue.class);
                field.setAccessible(true);
                Object val = field.get(object);
                if (null != val || "".equals(val))
                    paramMap.put(paramValue.filedName(), val);
            }
        }
        return paramMap;
    }

}
