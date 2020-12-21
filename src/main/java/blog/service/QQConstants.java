package blog.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class QQConstants {



    private static String app_id;


    private static String app_key;


    private static String callback;


    static final String OPENID_URL = "https://graph.qq.com/oauth2.0/me?access_token=";

    static final String USER_INFO_URL = "https://graph.qq.com/user/get_user_info?access_token=ACCESS_TOKEN&oauth_consumer_key=APP_ID&openid=OPENID";

    public static String getApp_id() {
        return app_id;
    }


    @Value("${yunxiu.qq.app_id}")
    public void setApp_id(String app_id) {
        QQConstants.app_id = app_id;
    }

    static String getApp_key() {
        return app_key;
    }

    @Value("${yunxiu.qq.app_key}")
    public void setApp_key(String app_key) {
        QQConstants.app_key = app_key;
    }

    static String getCallback() {
        return callback;
    }

    @Value("${yunxiu.qq.callback}")
    public void setCallback(String callback) {
        QQConstants.callback = callback;
    }


    @Override
    public String toString() {
        return "QQConstants{" +
                "app_id='" + app_id + '\'' +
                ", app_key='" + app_key + '\'' +
                ", callback='" + callback + '\'' +
                '}';
    }
}
