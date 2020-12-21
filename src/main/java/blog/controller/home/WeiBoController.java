package blog.controller.home;

import blog.service.WeiBoConstants;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.net.util.URLUtil;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
public class WeiBoController {



    @RequestMapping("/weibo")
    String weibo() {

        String app_key = WeiBoConstants.getApp_key();
        System.out.println(app_key);
        String AuthPath = WeiBoConstants.getCallback();
        String url = WeiBoConstants.AUTH_URL.replace("CLIENT_ID",app_key).replace("CALLBACK",AuthPath);

        return "redirect:" + url;

    }


    @RequestMapping("/weiboLogin")
    String weiboLogin(HttpServletRequest request) throws IOException {

        String code = request.getParameter("code");
        String params = "client_id=" + WeiBoConstants.getApp_key()
                + "&client_secret=" + WeiBoConstants.getApp_secret()
                + "&grant_type=authorization_code"
                + "&redirect_uri=" + WeiBoConstants.getCallback()
                + "&code=" + code;
// 用code换取accessToken
        String url ="https://api.weibo.com/oauth2/access_token";
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("Content-Type","application/json;charset=UTF-8");
        //建立HttpPost对象
        List<NameValuePair> params=new ArrayList<NameValuePair>();
        //建立一个NameValuePair数组，用于存储欲传送的参数
        params.add(new BasicNameValuePair("pwd","2544"));
        //添加参数
        httppost.setEntity(new UrlEncodedFormEntity(params,HTTP.UTF_8));
        //设置编码
        HttpResponse response=new DefaultHttpClient().execute(httppost);
        //发送Post,并返回一个HttpResponse对象
        //Header header = response.getFirstHeader("Content-Length");
        //String Length=header.getValue();
        // 上面两行可以得到指定的Header
        if(response.getStatusLine().getStatusCode()==200){//如果状态码为200,就是正常返回
            String result=EntityUtils.toString(response.getEntity());
            //得到返回的字符串
            System.out.println(result);
            //打印输出
            //如果是下载文件,可以用response.getEntity().getContent()返回InputStream
        }
    }
}
