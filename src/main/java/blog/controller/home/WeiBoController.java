package blog.controller.home;

import blog.mapper.UserMapper;
import blog.model.UserModel;
import blog.service.WeiBoAuth;
import blog.service.WeiBoConstants;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Controller
public class WeiBoController {

    @Autowired
    UserMapper userMapper;

    @RequestMapping("/weibo")
    String weibo() {

        String app_key = WeiBoConstants.getApp_key();

        String AuthPath = WeiBoConstants.getCallback();
        String url = WeiBoConstants.AUTH_URL.replace("CLIENT_ID",app_key).replace("CALLBACK",AuthPath);

        return "redirect:" + url;

    }


    @RequestMapping("/weiboLogin")
    String weiboLogin(HttpServletRequest request,
                      Map<String, String> params) throws IOException {

        String code = request.getParameter("code");

        JSONObject jsonres = WeiBoAuth.getToken(code);

        if (jsonres != null) {
            String token = jsonres.getString("access_token");
            String openid = jsonres.getString("uid");
            List<UserModel> userModels = userMapper.OneOpenid(openid);

            if (CollectionUtils.isEmpty(userModels)) {
                JSONObject userInfo = WeiBoAuth.getUserInfo(token, openid);

                UserModel userModel = new UserModel();
                userModel.setEmail("");
                assert userInfo != null;
                userModel.setName(userInfo.getString("name"));
                userModel.setAvatarUrl(userInfo.getString("avatar_hd"));
                userModel.setType(3);
                userModel.setOpenid(openid);
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
                String date = df.format(new Date());
                userModel.setCreatedAt(date);
                userModel.setUpdatedAt(date);

                userMapper.insert(userModel);
            }
        }
        return "redirect:/";
    }
}
