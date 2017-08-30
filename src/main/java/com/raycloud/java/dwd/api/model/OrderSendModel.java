package com.raycloud.java.dwd.api.model;

import com.raycloud.java.dwd.annotation.ParamValue;
import lombok.Data;

/**
 * Created by:  intelliJ IDEA
 *
 * @Author albert
 * @Description:点我达订单model
 * @Date:2017/8/21 下午1:46
 * @package:com.raycloud.java.dwd.api.model
 * @Modified By:
 */
@Data
public class OrderSendModel {
    @ParamValue(filedName = "order_original_id",isNotNull = true,filedDesc = "渠道订单编号")
    private String orderOriginalId;
    @ParamValue(filedName = "order_create_time",isNotNull = true ,filedDesc = "渠道订单创建时间戳" )
    private Long orderCreateTime;
    @ParamValue(filedName = "order_remark",isNotNull = true,filedDesc = "订单备注")
    private String orderRemark;
    @ParamValue(filedName = "order_price",isNotNull = true,filedDesc = "订单金额(分)")
    private Integer orderPrice;
    @ParamValue(filedName = "order_is_reserve",filedDesc = "是否是预约单(1:是，0:否)")
    private Integer orderIsReserve;
    @ParamValue(filedName = "serial_id",filedDesc = "订单流水号")
    private String serialId;
    @ParamValue(filedName = "cargo_type",filedDesc = "订单商品类型")
    private String cargoType;
    @ParamValue(filedName = "cargo_weight",isNotNull = true,filedDesc = "订单商品重量，单位：克")
    private Integer cargoWeight;
    @ParamValue(filedName = "cargo_num",isNotNull = true,filedDesc = "商品份数，默认传1")
    private Integer cargoNum;
    @ParamValue(filedName = "city_code",isNotNull = true,filedDesc = "行政区划代码")
    private String cityCode;
    @ParamValue(filedName = "seller_id",isNotNull = true,filedDesc = "商家编号")
    private String sellerId;
    @ParamValue(filedName = "seller_name",isNotNull = true,filedDesc = "商家店铺名称")
    private String sellerName;
    @ParamValue(filedName = "seller_mobile",isNotNull = true,filedDesc = "商家联系方式")
    private String sellerMobile;
    @ParamValue(filedName = "seller_address",isNotNull = true,filedDesc = "商家文字地址")
    private String sellerAddress;
    @ParamValue(filedName = "seller_lat",isNotNull = true,filedDesc = "商家纬度坐标(高德地图)")
    private Double sellerLat;
    @ParamValue(filedName = "seller_lng",isNotNull = true,filedDesc = "商家经度坐标(高德地图)")
    private Double sellerLng;
    @ParamValue(filedName = "consignee_name",isNotNull = true,filedDesc = "收货人姓名")
    private String consigneeName;
    @ParamValue(filedName = "consignee_mobile",isNotNull = true,filedDesc = "收货人手机号码")
    private String consigneeMobile;
    @ParamValue(filedName = "consignee_address",isNotNull = true,filedDesc = "收货人地址")
    private String consigneeAddress;
    @ParamValue(filedName = "consignee_lat",isNotNull = true,filedDesc = "收货人纬度坐标")
    private Double consigneeLat;
    @ParamValue(filedName = "consignee_lng",isNotNull = true,filedDesc = "收货人经度坐标")
    private Double consigneeLng;
    @ParamValue(filedName = "money_rider_needpaid",isNotNull = true,filedDesc = "配送员到店是否需要垫付订单金额1：是 0：否")
    private Integer moneyRiderNeedpaid;
    @ParamValue(filedName = "money_rider_prepaid",isNotNull = true,filedDesc = "配送员到店后先行垫付的金额(分),若无，传0")
    private Integer moneyRiderPrepaid;
    @ParamValue(filedName = "money_rider_charge",isNotNull =true ,filedDesc = "配送员送达到客户时，向客户收取的费用（分）")
    private Integer moneyRiderCharge;
    @ParamValue(filedName = "time_ready_for_deliver",filedDesc = "配送员应到店时间")
    private Long timeReadyForDeliver;
    @ParamValue(filedName = "time_waiting_at_seller",isNotNull = true,filedDesc = "商品必须到店才开始准备或是排队购买的情况下，在商家处等待所需时间（秒）")
    private Integer timeWaitingAtSeller;
    @ParamValue(filedName = "time_expected_arrival",filedDesc = "用户选择的期望送达时间戳")
    private Long timeExpectedArrival;
    @ParamValue(filedName = "time_expected_arrival_end",filedDesc = "用户选择的期望最晚送达时间戳")
    private Long timeExpectedArrivalEnd;
    @ParamValue(filedName = "delivery_fee_from_seller",isNotNull = true,filedDesc = "渠道支付配送费（分）")
    private Integer deliveryFeeFromSeller;
    @ParamValue(filedName = "items",filedDesc = "商品信息")
    private String items;
    @ParamValue(filedName = "callback",isNotNull = true,filedDesc = "回调url（url不能带参数）")
    private String callback;

}
