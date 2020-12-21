package blog.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Objects;

public class QQAuth {


    public static String  getOpenid(String access_token) throws Exception {

        // 请求地址
        String url = QQConstants.OPENID_URL + access_token;

        String responseStr = Objects.requireNonNull(HttpClientUtils.doGet(url))
                .replace("callback(", "")
                .replace(");", "");

        JSONObject jsonObject= JSON.parseObject(responseStr);
        if(jsonObject!=null&&jsonObject.getString("openid")!=null){ //如果返回不为空
            return jsonObject.getString("openid");
        }
        return null;
    }

    public static JSONObject getUserInfo(String access_token,String openid) throws Exception {
        String url = QQConstants.USER_INFO_URL
                .replace("APP_ID",QQConstants.getApp_id())
                .replace("ACCESS_TOKEN",access_token)
                .replace("OPENID",openid);

        String responseStr = HttpClientUtils.doGet(url);
        return JSONObject.parseObject(responseStr);
    }

    public static String getToken(String code) throws IOException {

        String url = "https://graph.qq.com/oauth2.0/token?grant_type=authorization_code"+
                "&client_id=" + QQConstants.getApp_id() +
                "&client_secret=" + QQConstants.getApp_key() +
                "&code=" + code +
                "&redirect_uri=" + QQConstants.getCallback();
        return getAccessToken(url);
    }

    private static String getAccessToken(String url) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        String token = null;

        HttpGet httpGet = new HttpGet(url);
        HttpResponse response = client.execute(httpGet);
        HttpEntity entity = response.getEntity();

        if(entity != null){
            String result = EntityUtils.toString(entity,"UTF-8");
            if(result.indexOf("access_token") >= 0){
                String[] array = result.split("&");
                for (String str : array){
                    if(str.indexOf("access_token") >= 0){
                        token = str.substring(str.indexOf("=") + 1);
                        break;
                    }
                }
            }
        }

        httpGet.releaseConnection();
        return token;
    }
}
