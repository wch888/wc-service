package com.wc.user.service;

import com.cloopen.rest.sdk.CCPRestSDK;
import com.wc.common.util.BaseConfig;
import org.apache.commons.lang.math.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Set;

/**
 * Created by admin on 2015-09-07.
 */
public class SmsService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private static String accountSid= BaseConfig.getValue("account.sid");
    private static String token= BaseConfig.getValue("account.token");
    private static String appId= BaseConfig.getValue("app.id");
    private static String restUrl= BaseConfig.getValue("rest.url");
    private static String restPort= BaseConfig.getValue("rest.port");
    private static String templateId = BaseConfig.getValue("templateId");

    public boolean send(String phone, String code){
        HashMap<String, Object> result = null;
        CCPRestSDK restAPI = new CCPRestSDK();
        System.out.println(accountSid);
        System.out.println(token);
        restAPI.init(restUrl, restPort);// 初始化服务器地址和端口，格式如下，服务器地址不需要写https://
        restAPI.setAccount(accountSid, token);// 初始化主帐号和主帐号TOKEN
        restAPI.setAppId(appId);// 初始化应用ID
//        34066
        result = restAPI.sendTemplateSMS(phone, templateId, new String[]{code, "3"});

        logger.info("SDKTestSendTemplateSMS result=" + result);
        if("000000".equals(result.get("statusCode"))){
            //正常返回输出data包体信息（map）
            HashMap<String,Object> data = (HashMap<String, Object>) result.get("data");
            Set<String> keySet = data.keySet();
            for(String key:keySet){
                Object object = data.get(key);
                System.out.println(key +" = "+object);
            }
            return true;
        }else{
            //异常返回输出错误码和错误信息
            logger.info(("错误码=" + result.get("statusCode") + " 错误信息= " + result.get("statusMsg")));
            return true;
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            int tmp = RandomUtils.nextInt(999999);
            int result = tmp % (999999 - 100000 + 1) + 100000;
            System.out.println(result);
        }

//        SmsService service = new SmsService();
//        service.send("18577103004", "asdf");
    }
}
