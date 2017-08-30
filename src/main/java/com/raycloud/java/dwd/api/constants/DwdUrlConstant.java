package com.raycloud.java.dwd.api.constants;

/**
 * Created by:  intelliJ IDEA
 *
 * @Author albert
 * @Description:点我达请求地址链接
 * @Date:2017/8/21 下午4:17
 * @package:com.raycloud.java.dwd.api.constants
 * @Modified By:
 */
public class DwdUrlConstant {
    /**
     * 沙箱地址
     */
    public static final String BASIC_IP_SANDBOX ="http://60.191.68.46:43580"; //"http://60.191.68.46:19080";
    /**
     * 正式地址
     */
    public static final String BASIC_IP = "http://api.dianwoda.com";
    /**
     * 派发订单接口
     */
    public static final String ORDER_SEND = "/api/v3/order-send.json";
    /**
     * 获取订单信息
     */
    public static final String ORDER_GET = "/api/v3/order-get.json";
    /**
     * 取消订单
     */
    public static final String ORDER_CANCEL = "/api/v3/order-cancel.json";
    /**
     * 修改订单备注信息
     */
    public static final String ORDER_UPDATE_REMARK = "/api/v3/order-update-remark.json";
    /**
     * 获取配送员位置信息
     */
    public static final String ORDER_RIDER_POSITION = "/api/v3/order-rider-position.json";
    /**
     * 批量获取配送员位置信息
     */
    public static final String ORDER_BATCH_RIDER_POSITION = "/api/v3/batch-order-rider-position.json";
    /**
     * 订单投诉
     */
    public static final String ORDER_COMPLAIN = "/api/v3/order-complain.json";
    /**
     * 查询投诉结果
     */
    public static final String ORDER_GET_COMPLAIN = "/api/v3/order-get-complain.json";
    /**
     * 创建配送站点
     */
    public static final String BATCH_SAVE_STORE = "/api/v3/batchsave-store.json";
    /**
     * 小费
     */
    public static final String ORDER_TIP = "/api/v3/order-tip.json";
    /**
     * 接受订单（测试接口仅测试环境有效）
     */
    public static final String ORDER_ACCEPTED_TEST = "/api/v3/order-accepted-test.json";
    /**
     * 完成到店（测试接口仅测试环境有效）
     */
    public static final String ORDER_ARRIVE_TEST = "/api/v3/order-arrive-test.json";
    /**
     * 完成取货（测试接口仅测试环境有效）
     */
    public static final String ORDER_FETCH_TEST = "/api/v3/order-fetch-test.json";
    /**
     * 配送完成（测试接口仅测试环境有效）
     */
    public static final String ORDER_FINISH_TEST = "/api/v3/order-finish-test.json";

}
