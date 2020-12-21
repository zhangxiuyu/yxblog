package blog.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class WeiBoConstants {



    private static String app_secret;


    private static String app_key;


    private static String callback;

    public static final String AUTH_URL = "https://api.weibo.com/oauth2/authorize?client_id=CLIENT_ID&response_type=code&redirect_uri=CALLBACK";
    public static final String TOKEN_URL = "https://api.weibo.com/oauth2/access_token?client_id=CLIENT_ID&client_secret=SECRET&grant_type=authorization_code&redirect_uri=CALLBACK&code=CODE";

    public static String getApp_key() {
        return app_key;
    }

    @Value("${yunxiu.weibo.app_key}")
    public  void setApp_key(String app_key) {
        WeiBoConstants.app_key = app_key;
    }

    public static String getApp_secret() {
        return app_secret;
    }

    @Value("${yunxiu.weibo.app_secret}")
    public  void setApp_secret(String app_secret) {
        WeiBoConstants.app_secret = app_secret;
    }


    public static String getCallback() {
        return callback;
    }

    @Value("${yunxiu.weibo.callback}")
    public  void setCallback(String callback) {
        WeiBoConstants.callback = callback;
    }
}
