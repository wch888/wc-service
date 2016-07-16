package com.jpush;

import cn.jpush.api.JPushClient;
import cn.jpush.api.common.ClientConfig;
import cn.jpush.api.common.resp.APIConnectionException;
import cn.jpush.api.common.resp.APIRequestException;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;
import com.wc.common.util.BaseConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;


public class JPushService {

    private static final Logger logger = LoggerFactory.getLogger(JPushService.class);
    public static final String JPUSH_APPKEY = BaseConfig.getValue("jpush.appkey");
    public static final String JPUSH_SECRET = BaseConfig.getValue("jpush.secret");
    public static final String ALERT = "alert";
    public static JPushService service = new JPushService();
    public static JPushClient jpushClient;

    public static Options options = Options.newBuilder()
            .setApnsProduction(true)
            .build();

    public static JPushService getInstance() {
        return service;
    }

    private JPushService() {
        jpushClient = new JPushClient(JPUSH_SECRET, JPUSH_APPKEY, null, ClientConfig.getInstance());
    }

    public boolean sendNotification_android(String title, Map map) {

        try {

            PushPayload payload = PushPayload.newBuilder()
                    .setAudience(Audience.all())
                    .setPlatform(Platform.android())
                    .setOptions(options)
                    .setNotification(Notification.newBuilder()
                            .setAlert(title)
                            .addPlatformNotification(AndroidNotification.newBuilder()
                                    .addExtras(map)
                                    .build()).build())
                    .build();
            PushResult result = jpushClient.sendPush(payload);
            return result.isResultOK();
        } catch (APIConnectionException e) {
            logger.error("",e);
        } catch (APIRequestException e) {
            logger.error("",e);
        }
        return false;
    }

    public boolean sendNotification_ios(String title, Map map) {
        try {

            IosNotification ios = IosNotification.newBuilder().addExtras(map).build();

            PushPayload payload = PushPayload.newBuilder()
                    .setAudience(Audience.all())
                    .setPlatform(Platform.ios())
                    .setOptions(options)
                    .setNotification(
                            Notification.newBuilder()
                                    .setAlert(title)
                                    .addPlatformNotification(ios).build()
                    )
                    .build();
            PushResult result = jpushClient.sendPush(payload);
            return result.isResultOK();
        } catch (APIConnectionException e) {
            logger.error("",e);
        } catch (APIRequestException e) {
            logger.error("",e);
        }
        return false;
    }

    public boolean sendNotification(String title, Map map) {

        try {
            sendNotification_ios(title, map);
            sendNotification_android(title, map);
        } catch (Exception e) {
            logger.error("", e);
        }
        return false;
    }

    public boolean sendNotificationAudience(String pushId, String title, Map map) {

        try {
            sendNotification_ios_Audience(pushId, title, map);
            sendNotification_android_Audience(pushId, title, map);
        } catch (Exception e) {
            logger.error("", e);
        }
        return false;

    }

    public boolean sendNotification_android_Audience(String pushId, String title, Map map) {

        try {

            PushPayload payload = PushPayload.newBuilder()
                    .setAudience(Audience.alias(pushId))
                    .setPlatform(Platform.android())
                    .setOptions(options)
                    .setNotification(Notification.newBuilder()
                            .setAlert(title)
                            .addPlatformNotification(AndroidNotification.newBuilder()
                                    .addExtras(map)
                                    .build()).build())
                    .build();
            PushResult result = jpushClient.sendPush(payload);
            return result.isResultOK();
        } catch (APIConnectionException e) {
            logger.error("", e);
        } catch (APIRequestException e) {
            logger.error("", e);
        }
        return false;
    }

    public boolean sendNotification_ios_Audience(String pushId, String title, Map map) {
        try {

            IosNotification ios = IosNotification.newBuilder().addExtras(map).build();

            PushPayload payload = PushPayload.newBuilder()
                    .setPlatform(Platform.ios())
                    .setAudience(Audience.alias(pushId))
                    .setOptions(options)
                    .setNotification(
                            Notification.newBuilder()
                                    .setAlert(title)
                                    .addPlatformNotification(ios).build()
                    )
                    .build();
            PushResult result = jpushClient.sendPush(payload);
            return result.isResultOK();
        } catch (APIConnectionException e) {
            logger.error("", e);
        } catch (APIRequestException e) {
            logger.error("", e);
        }
        return false;
    }

    private PushPayload buildPushObject_all_alias_alert(String alias) {
        return PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.alias(alias))
                .setNotification(Notification.alert(ALERT))
                .build();
    }

    private PushPayload buildPushObject_all_alert(String content, Map<String, String> map) {
        return PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.all())
                .setOptions(options)
                .setMessage(Message.newBuilder()
                        .setMsgContent(content)
                        .addExtras(map)
                        .build())
                .build();
    }


    private static PushPayload buildPushObject_android_tag_alertWithTitle(String alias, String title) {
        return PushPayload.newBuilder()
                .setPlatform(Platform.android())
                .setAudience(Audience.alias(alias))
                .setNotification(Notification.android(ALERT, title, null))
                .build();
    }

    private static PushPayload buildPushObject_android_tag_alertWithTitleContent(String alias, String content, Map<String, String> map) {
        return PushPayload.newBuilder()
                .setPlatform(Platform.android_ios())
                .setAudience(Audience.alias(alias))
                .setMessage(Message.newBuilder()
                        .setMsgContent(content)
                        .addExtras(map)
                        .build())
                .build();
    }

//    public boolean sendToAll(String content, Map<String, String> map) {
//        try {
//            PushPayload payload = PushPayload.newBuilder()
//                    .setAudience(Audience.all())
//                    .setPlatform(Platform.all())
//                    .setOptions(options)
//                    .setMessage(Message.newBuilder().addExtras(map)
//                            .setMsgContent(content).build())
//                    .build();
//            PushResult result = jpushClient.sendPush(payload);
//            logger.info("",result);
//            return result.isResultOK();
//        } catch (APIRequestException e) {
//            logger.error("Should not fail", e);
//        } catch (APIConnectionException e) {
//            logger.error("Should not fail", e);
//        }
//        return false;
//    }

    public boolean send(String alias) {
        try {
            PushResult result = jpushClient.sendPushValidate(buildPushObject_all_alias_alert(alias));
            return result.isResultOK();
        } catch (APIRequestException e) {
            logger.error("Should not fail", e);
        } catch (APIConnectionException e) {
            logger.error("Should not fail", e);
        }
        return false;
    }

    public boolean send(String alias, String content, Map<String, String> map) {
        try {
            PushResult result = jpushClient.sendPushValidate(buildPushObject_android_tag_alertWithTitleContent(alias, content, map));
            return result.isResultOK();
        } catch (APIRequestException e) {
            logger.error("Should not fail", e);
        } catch (APIConnectionException e) {
            logger.error("Should not fail", e);
        }
        return false;
    }

    public static void main(String[] args) {

//        Map<String, String> map = new HashMap<String, String>();
//        map.put("type", "news");
//        map.put("id", "11");
//        try {
//            JPushService.getInstance().sendToAll("asdfas111df",map);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        Map<String, String> map = new HashMap<String, String>();
        map.put("type", "news");
        map.put("id", "11");
        JPushService.getInstance().sendNotification("标题", map);
    }
}
