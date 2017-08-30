package com.raycloud.java.dwd.util;

import org.apache.log4j.Logger;

import java.security.MessageDigest;
import java.util.*;

/**
 * Created by:  intelliJ IDEA
 *
 * @Author albert
 * @Description:签名计算
 * @Date:2017/8/22 上午10:31
 * @package:com.raycloud.java.dwd.util
 * @Modified By:
 */
public class SignatureUtils {

    private SignatureUtils(){

    }
    private static Logger logger = Logger.getLogger(SignatureUtils.class);

    /**
     * 签名生成
     *
     * @param paramMap  签名校验字段map
     * @param appSecret 运用授权密钥
     * @return
     */
    public static String signatureGenerate(Map<String, Object> paramMap, String appSecret) throws Exception {
        StringBuffer sbf = new StringBuffer();
        String stringB = null;
        //1.1、对paramMap进行字典排序
        Collection<String> keySet = paramMap.keySet();
        List<String> list = new ArrayList<String>(keySet);
        Collections.sort(list);
        //1.2、拼接字符串按key value的形式:keyvalue 得到字符串A
        for (String key : list) {
            sbf.append(key).append(paramMap.get(key));
        }
        //2、拼接secret+A+secret得到字符串B
        stringB = appSecret + sbf.toString() + appSecret;
        //3、将B进行SHA-1加密后进行16进制转换在转成大写
       return encrypt(stringB);
    }

    /**
     * 进行sha-1加密并转换成16进制字符串
     * @param arg
     * @return
     * @throws Exception
     */
    private static String encrypt(String arg) throws Exception {
        //变量定义
        String result = null;
        //1对arg进行sha-1加密
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
        messageDigest.update(arg.getBytes("UTf-8"));
        //加密后得到byte数组
        byte[] shaResult = messageDigest.digest();
        //转换成16进制
        result = bytesToHex(shaResult);
        //转换成大写
        result = result.toUpperCase();
        return result;
    }

    /**
     * bytes转16进制
     * @param bytes
     * @return
     */
    private static String bytesToHex(byte[] bytes) {
        final String HEX = "0123456789abcdef";
        StringBuilder sb = new StringBuilder(bytes.length * 2);
        for (byte b : bytes) {
            // 取出这个字节的高4位，然后与0x0f与运算，得到一个0-15之间的数据，通过HEX.charAt(0-15)即为16进制数
            sb.append(HEX.charAt((b >> 4) & 0x0f));
            // 取出这个字节的低位，与0x0f与运算，得到一个0-15之间的数据，通过HEX.charAt(0-15)即为16进制数
            sb.append(HEX.charAt(b & 0x0f));
        }
        return sb.toString();
    }

    /**
     * 签名校验
     * @param paramMap
     * @param appSecret
     * @param oldSig
     * @return
     */
    public static boolean checkSig(Map<String, Object> paramMap, String appSecret,String oldSig) throws Exception{
        logger.debug("回调签名校验原始签名："+oldSig);
        if (StringUtils.isEmpty(oldSig)){
            return false;
        }
        String sig = signatureGenerate(paramMap,appSecret);
        logger.debug("回调签名校验参数签名："+sig);

        return oldSig.equals(sig);
    }

}
