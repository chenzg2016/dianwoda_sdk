package com.raycloud.java.dwd.api;

import com.alibaba.fastjson.JSON;
import com.raycloud.java.dwd.util.ParamUtils;
import com.raycloud.java.dwd.api.model.callback.OrderCallback;
import com.raycloud.java.dwd.util.SignatureUtils;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import org.apache.http.HttpStatus;

import java.io.*;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by:  intelliJ IDEA
 *
 * @Author albert
 * @Description:
 * @Date:2017/8/29 上午9:45
 * @package:com.raycloud.java.dwd.api
 * @Modified By:
 */
public class CallbackServer {

    private  final String appSecret = "4cb7864f25319e4e528829729f4e84a1";


//    @Test
    public void callbackServer()throws Exception{
        InetSocketAddress inetSocketAddress = new InetSocketAddress(8066);

        HttpServer server =  HttpServer.create(inetSocketAddress,10);

        server.createContext("/callback",new ServerHandler());
        server.setExecutor(null);
        server.start();

    }


    private class ServerHandler implements HttpHandler{

        @Override
        public void handle(HttpExchange httpExchange) throws IOException {
            //针对请求的处理部分
            //返回请求响应时，遵循HTTP协议
            String responseString = "{" + "\"success\":" + true+"}";
            //HttpRequest request = new HttpRe
            InputStream inputStream = httpExchange.getRequestBody();
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
            String line = null;
            StringBuffer body = new StringBuffer();
            while ((line = in.readLine()) != null) {
                body.append(line);
            }
            line = body.toString();

            OrderCallback orderCallback = JSON.parseObject(line,OrderCallback.class);
            Map<String,Object> param = new HashMap<String, Object>();
            try{
                Map<String,Object> map = ParamUtils.paramMapSig(orderCallback);
                boolean isCheck = SignatureUtils.checkSig(map,appSecret,orderCallback.getSig());
                if (isCheck){
                    System.out.println("数据校验正常");
                }else{
                    System.out.println("数据校验失败");
                }
            }catch (IllegalAccessException ie){
                ie.printStackTrace();
            }catch (Exception e){
                e.printStackTrace();
            }



            System.out.println(orderCallback.toString());

            //设置响应头
            httpExchange.sendResponseHeaders(HttpStatus.SC_OK, responseString.length());
            OutputStream os = httpExchange.getResponseBody();
            os.write(responseString.getBytes());
            os.close();
        }
    }

    public static void main(String[] args) {
        CallbackServer callbackServer = new CallbackServer();
        try {
            callbackServer.callbackServer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
