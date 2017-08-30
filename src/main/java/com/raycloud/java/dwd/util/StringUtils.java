package com.raycloud.java.dwd.util;

/**
 * Created by:  intelliJ IDEA
 *
 * @Author albert
 * @Description:
 * @Date:2017/8/23 上午9:24
 * @package:com.raycloud.java.dwd.util
 * @Modified By:
 */
public class StringUtils {

    /**
     * 私有化构造函数防止new
     */
    private StringUtils() {
    }

    /**
     * 判断arg不能为空
     * if arg=="" or arg ==null return false else return true
     * @param arg
     * @return boolean
     */
    public static boolean notEmpty(String arg){
        if (null == arg||"".equals(arg)){
            return false;
        }
        return true;
    }

    /**
     * if arg=="" or arg ==null return true else return false
     * @param arg
     * @return
     */
    public static boolean isEmpty(String arg){
        if (null == arg||"".equals(arg)){
            return true;
        }
        return false;
    }

}
