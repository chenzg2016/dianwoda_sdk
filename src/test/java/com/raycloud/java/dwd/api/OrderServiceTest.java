package com.raycloud.java.dwd.api;

import com.alibaba.fastjson.JSON;
import com.raycloud.java.dwd.api.base.Config;
import com.raycloud.java.dwd.api.model.*;
import com.raycloud.java.dwd.api.model.response.OrderOptionModel;
import com.raycloud.java.dwd.api.service.BatchSaveStoreService;
import com.raycloud.java.dwd.api.service.OrderComplainService;
import com.raycloud.java.dwd.api.service.OrderService;
import com.raycloud.java.dwd.api.service.RiderPositionService;
import com.raycloud.java.dwd.api.service.back.BackModel;
import com.raycloud.java.dwd.api.service.impl.BatchSaveStoreServiceImpl;
import com.raycloud.java.dwd.api.service.impl.OrderComplainServiceImpl;
import com.raycloud.java.dwd.api.service.impl.OrderServiceImpl;
import com.raycloud.java.dwd.api.service.impl.RiderPositionServiceImpl;
import com.raycloud.java.dwd.callback.OrderCallbackService;
import com.raycloud.java.dwd.callback.impl.OrderCallbackServiceImpl;
import com.raycloud.java.dwd.util.StringUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by:  intelliJ IDEA
 *
 * @Author albert
 * @Description:
 * @Date:2017/8/24 下午4:01
 * @package:com.raycloud.java.dwd.api
 * @Modified By:
 */
public class OrderServiceTest {
    private Config config;

    private static final String appkey = "10095";
    private static final String appsecret = "4cb7864f25319e4e528829729f4e84a1";
    private static final String callback = "http://39.181.46.233/SPOS/dianwoda/getDwdPush.do";

    OrderService orderService;
    OrderComplainService orderComplainService;
    BatchSaveStoreService batchSaveStoreService;
    OrderCallbackService orderCallbackService;
    RiderPositionService riderPositionService;

    @Before
    public void setConfig() {
        this.config = new Config(appsecret, appkey, true, callback);
        this.orderService = new OrderServiceImpl(config);
        this.orderComplainService = new OrderComplainServiceImpl(config);
        this.batchSaveStoreService = new BatchSaveStoreServiceImpl(config);
        this.orderCallbackService = new OrderCallbackServiceImpl(config);
        this.riderPositionService = new RiderPositionServiceImpl(config);
    }

//    @Test
    public void testSendOrder() {
        OrderSendModel orderSendModel = new OrderSendModel();

        orderSendModel.setCallback(config.getCallback());
        orderSendModel.setOrderOriginalId("20170829003");
        orderSendModel.setOrderCreateTime(System.currentTimeMillis());
        orderSendModel.setOrderRemark("请先拨打电话");
        orderSendModel.setOrderPrice(6000);
        orderSendModel.setOrderIsReserve(0);
        orderSendModel.setSellerId("01");
        orderSendModel.setCargoType("00");
        orderSendModel.setCargoWeight(0);
        orderSendModel.setCargoNum(1);
        orderSendModel.setCityCode("330100");
        orderSendModel.setSellerId("123456");
        orderSendModel.setSellerName("光云水果店");
        orderSendModel.setSellerMobile("13766688835");
        orderSendModel.setSellerAddress("滨江区江南道大道恒兴大厦1203");
        orderSendModel.setSellerLat(120.201663);
        orderSendModel.setSellerLng(30.201874);
        orderSendModel.setConsigneeName("收货人");
        orderSendModel.setConsigneeMobile("18768144438");
        orderSendModel.setConsigneeAddress("滨江区滨兴东苑10幢2单元101");
        orderSendModel.setConsigneeLat(120.200794);
        orderSendModel.setConsigneeLng(30.194447);
        orderSendModel.setMoneyRiderNeedpaid(0);
        orderSendModel.setMoneyRiderPrepaid(0);
        orderSendModel.setMoneyRiderCharge(0);
        orderSendModel.setTimeReadyForDeliver(1503576000000L);
        orderSendModel.setTimeWaitingAtSeller(600);
        orderSendModel.setTimeExpectedArrival(1503577800000L);
        orderSendModel.setTimeExpectedArrivalEnd(1503585030000L);
        orderSendModel.setDeliveryFeeFromSeller(600);

        List<OrderItemsModel> list = new ArrayList<OrderItemsModel>();
        OrderItemsModel orderItemsModel = new OrderItemsModel();
        orderItemsModel.setDiscount_price(10000L);
        orderItemsModel.setItem_name("香辣鸡腿堡");
        orderItemsModel.setUnit_price(10000L);
        orderItemsModel.setProduction_time(0L);
        orderItemsModel.setUnit("份");
        orderItemsModel.setQuantity(2);
        list.add(orderItemsModel);
        String items = JSON.toJSONString(list);

        orderSendModel.setItems(items);


/********--------------------------返回定义-----------------------------------***************/
        BackModel backModel = new BackModel();
/********--------------------------发送订单-----------------------------------***************/
        backModel = orderService.orderSend(orderSendModel);
/********--------------------------获取订单-----------------------------------***************/
//       GetOrderModel getOrderModel =new GetOrderModel();
//        getOrderModel.setOrderOriginalId("20170824010");
//        backModel = orderService.getOrderInfo(getOrderModel);

/********--------------------------订单取消-----------------------------------***************/
//        CancelOrderModel cancelOrderModel = new CancelOrderModel();
//        cancelOrderModel.setCancleReason("测试取消原因");
//        cancelOrderModel.setOrderOriginalId("20170828005");
//        backModel = orderService.cancelOrder(cancelOrderModel);
/********--------------------------订单备注修改-----------------------------------***************/
//        UpdateRemarkModel updateRemarkModel =new UpdateRemarkModel();
//        updateRemarkModel.setOrderInfoContent("修改备注");
//        updateRemarkModel.setOrderOriginalId("20170824005");
//        backModel = orderService.updateOrderRemark(updateRemarkModel);
/********--------------------------订单投诉-----------------------------------***************/
//        OrderComplainModel orderComplainModel = new OrderComplainModel();
//        orderComplainModel.setComplainSource(2);
//        orderComplainModel.setOrderOriginalId("20170824005");
//        orderComplainModel.setComplainTime(System.currentTimeMillis());
//        List<ComplainContent> listContent = new ArrayList<ComplainContent>();
//        ComplainContent complainContent = new ComplainContent();
//        complainContent.setCode("020489");
//        complainContent.setReason("测试");
//        complainContent.setOrder_complain_original_id("");
//        listContent.add(complainContent);
//        orderComplainModel.setComplainContent(JSON.toJSONString(listContent));
//        backModel = orderComplainService.orderComplain(orderComplainModel);
/********--------------------------查询订单投诉-----------------------------------***************/
//        GetComplainModel getComplainModel = new GetComplainModel();
//        getComplainModel.setOrderOriginalId("20170824005");
//        getComplainModel.setComplainType("020489");
//        getComplainModel.setOrderComplainOriginalId("");
//        backModel = orderComplainService.searComplainResult(getComplainModel);
/********--------------------------创建配送站点-----------------------------------***************/
//        BatchSaveStoreModel batchSaveStoreModel = new BatchSaveStoreModel();
//        List<ShopsModel> shopsModels = new ArrayList<ShopsModel>();
//        ShopsModel shopsModel = new ShopsModel();
//        shopsModel.setAddr("杭州市滨江区江南大道恒鑫大厦1203");
//        shopsModel.setCity_code("330100");
//        shopsModel.setExternal_shopid("135");
//        shopsModel.setShop_title("隔壁老王水果店");
//        shopsModel.setMobile("13576557777");
//        shopsModel.setLng(12020162L);
//        shopsModel.setLat(30201911L);
//        shopsModels.add(shopsModel);
//         shopsModel = new ShopsModel();
//        shopsModel.setAddr("杭州市滨江区滨兴东苑1-103");
//        shopsModel.setCity_code("330100");
//        shopsModel.setExternal_shopid("136");
//        shopsModel.setShop_title("老百姓水果店");
//        shopsModel.setMobile("13576557788");
//        shopsModel.setLng(120200316L);
//        shopsModel.setLat(3019491L);
//        shopsModels.add(shopsModel);
//
//        batchSaveStoreModel.setShops(JSON.toJSONString(shopsModels));
//        backModel = batchSaveStoreService.createStore(batchSaveStoreModel);

/********--------------------------小费接口-----------------------------------***************/
//        OrderTipModel orderTipModel = new OrderTipModel();
//        orderTipModel.setOrderOriginalId("20170828005");
//        orderTipModel.setTip(800L);
//        backModel = orderService.updateOrderTip(orderTipModel);

/********--------------------------获取配送员位置接口-----------------------------------***************/
//        GetRiderPositionModel getRiderPositionModel = new GetRiderPositionModel();
//        getRiderPositionModel.setOrderOriginalId("20170828007");
//        getRiderPositionModel.setRiderCode("1");
//        backModel = riderPositionService.getRiderPosition(getRiderPositionModel);
/********--------------------------批量获取配送员位置接口-----------------------------------***************/
//        BatchGetRiderPositionModel batchGetRiderPositionModel = new BatchGetRiderPositionModel();
//        batchGetRiderPositionModel.setCityCode("330100");
//        batchGetRiderPositionModel.setOrderOriginalIds("20170828006,20170828007");
//
//        backModel = riderPositionService.getBatchRiderPosition(batchGetRiderPositionModel);
/********--------------------------批量获取配送员位置接口-----------------------------------***************/

        System.out.println(backModel.toString());

    }

    @Test
    public void testCallback() {

        BackModel backModel = new BackModel();
        OrderOptionModel optionModel = new OrderOptionModel();
        optionModel.setOrderOriginalId("20170829003");
/********--------------------------测试接受订单-----------------------------------***************/
        backModel = orderCallbackService.acceptOrder(optionModel);

/********--------------------------测试完成到店-----------------------------------***************/
//        backModel = orderCallbackService.arrivedShop(optionModel);
//        System.out.println(backModel.toString());

/********--------------------------测试完成取货-----------------------------------***************/
//        backModel = orderCallbackService.finishPackage(optionModel);
//        System.out.println(backModel.toString());
/********--------------------------测试完成配送-----------------------------------***************/
//        backModel = orderCallbackService.finishDelivery(optionModel);
//        System.out.println(backModel.toString());
/********--------------------------获取订单-----------------------------------***************/
        GetOrderModel getOrderModel =new GetOrderModel();
        getOrderModel.setOrderOriginalId("20170829002");
//        backModel = orderService.getOrderInfo(getOrderModel);

        System.out.println(backModel.toString());

    }




}
