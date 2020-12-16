package blog.service;

public class QQAuth {


    public static String  getOpenid(String access_token) throws Exception {
        String url = QQConstants.OPENID_URL + access_token;
        String responseStr = HttpClientUtils.doGet(url);

        assert responseStr != null;

        return HttpClientUtils.parseResponseEntity(responseStr).get("openid");
    }

}
