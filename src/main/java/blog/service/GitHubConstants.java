package blog.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;


@Configuration
public class GitHubConstants {


    private static String client_id;


    private static String client_secret;


    private static String callback;


    public static String getClient_id() {
        return client_id;
    }

    public static String getClient_secret() {
        return client_secret;
    }

    public static String getCallback() {
        return callback;
    }

    @Value("${yunxiu.github.client_id}")
    public  void setClient_id(String client_id) {
        GitHubConstants.client_id = client_id;
    }

    @Value("${yunxiu.github.client_secret}")
    public  void setClient_secret(String client_secret) {
        GitHubConstants.client_secret = client_secret;
    }

    @Value("${yunxiu.github.callback}")
    public  void setCallback(String callback) {
        GitHubConstants.callback = callback;
    }

    //获取code的url
    public static final String CODE_URL = "https://github.com/login/oauth/authorize?client_id=CLIENT_ID&state=STATE&redirect_uri=CALLBACK";
    //获取token的url
    public static final String TOKEN_URL = "https://github.com/login/oauth/access_token?client_id=CLIENT_ID&client_secret=CLIENT_SECRET&code=CODE&redirect_uri=CALLBACK";
    //获取用户信息的url
    public static final String USER_INFO_URL = "https://api.github.com/user?access_token=TOKEN";
}
