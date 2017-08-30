package com.raycloud.java.dwd.api.enums;

/**
 * Created by:  intelliJ IDEA
 *
 * @Author albert
 * @Description:
 * @Date:2017/8/24 下午2:57
 * @package:com.raycloud.java.dwd.api.enums
 * @Modified By:
 */
public enum  DwdStatusEnum {

    ACCESS_ORDER(0,"派单中","渠道已下单系统派单中"),
    TURN_ORDER(3,"转单","骑手已转单"),
    TAKE_ORDER(5,"取餐中","骑手已接单"),
    ARRIVE_SHOP(10,"已到店","骑手已到店，等待商家出餐"),
    DELIVERY_ORDER(15,"配送中","骑手已离店，配送途中"),
    FINISH_ORDER(100,"已完成","骑手已妥投"),
    EXCEPTION_ORDER(98,"异常","订单出现异常，骑手无法完成"),
    CANCEL_ORDER(99,"已取消","订单已取消");


    private Integer code;
    private String desc;
    private String remark;

    DwdStatusEnum(Integer code, String desc,String remark) {
        this.code = code;
        this.desc = desc;
        this.remark =remark;
    }

    public Integer getCode(){
        return code;
    }
}
