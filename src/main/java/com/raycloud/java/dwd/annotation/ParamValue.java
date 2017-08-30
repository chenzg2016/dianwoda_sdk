package com.raycloud.java.dwd.annotation;

import java.lang.annotation.*;

/**
 * Created by:  intelliJ IDEA
 *
 * @Author albert
 * @Description:用于获取接口的参数模型判断是否为空
 * @Date:2017/8/21 下午5:00
 * @package:com.raycloud.java.dwd.annotation
 * @Modified By:
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ParamValue {
    /**
     * 注解字段名称
     */
    public String filedName();
    /**
     * 字段是否可以为空
     */
    public boolean isNotNull() default false;

    /**
     *字段描述
     */
    public String filedDesc();

}
