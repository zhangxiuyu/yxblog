package blog.service;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class WeiBoAuth {



    public static JSONObject getToken(String code) throws IOException {

        String url ="https://api.weibo.com/oauth2/access_token";

        CloseableHttpClient client = HttpClients.createDefault();
        //第一个参数
        String stringBuilder = url + "?client_id=" +
                WeiBoConstants.getApp_key() +
                //第二个参数
                "&client_secret=" +
                WeiBoConstants.getApp_secret() +
                //第三个参数
                "&grant_type=" +
                "authorization_code" +
                //第四个参数
                "&code=" +
                code +
                //第五个参数
                "&redirect_uri=" +
                WeiBoConstants.getCallback();

        HttpPost httpPost = new HttpPost(stringBuilder);
        httpPost.addHeader("Authorization","code " + code);

//        发送请求返回响应的信息
        CloseableHttpResponse response = client.execute(httpPost);
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            String result = EntityUtils.toString(entity, "UTF-8");

            // String token = jsonres.getString("access_token");
            // String openid = jsonres.getString("uid");
            return JSONObject.parseObject(result);
        }
        return null;
    }

    public static JSONObject getUserInfo(String access_token, String uid) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        String url = "https://api.weibo.com/2/users/show.json";
        //第一个参数
        String stringBuilder = url + "?access_token=" +
                access_token +
                //第二个参数
                "&uid=" +
                uid;
        HttpGet httpGet = new HttpGet(stringBuilder);
        //发送请求返回响应的信息
        CloseableHttpResponse response = client.execute(httpGet);
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            String result = EntityUtils.toString(entity, "UTF-8");
            return JSONObject.parseObject(result);
        }
        return null;
    }
}
