package blog.controller.home;


import blog.mapper.UserMapper;
import blog.model.UserModel;
import blog.service.QQAuth;
import blog.service.QQConstants;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class QQController {

    @Autowired
    QQConstants qqConstants;

    @Autowired
    UserMapper userMapper;

    @RequestMapping("/QQ")
    String QQ(){
        System.out.println(QQConstants.getApp_id());

        String qqAppId = "101770145";
        String qqAuthPath = "http://127.0.0.1:8088/QQLogin";
        String state = "fjdslfjsdlkfd";
        String url = "https://graph.qq.com/oauth2.0/authorize?response_type=code&client_id="+qqAppId+"&redirect_uri="+qqAuthPath+"&state=" + state;

        return "redirect:" + url;
    }



    @RequestMapping("/QQLogin")
    String  QQLogin(HttpServletRequest request) throws Exception {

        String code = request.getParameter("code");
        //System.out.println("code:"+code);
        // 获取token
        String access_token = QQAuth.getToken(code);
        //System.out.println("token:"+access_token);
        // 获取用户openid
        String openid  = QQAuth.getOpenid(access_token);
        //System.out.println("openid:"+openid);

        // 获取用户是否已经存在， 存在就不在获取用户信息

        // 获取用户信息
        JSONObject userInfo = QQAuth.getUserInfo(access_token,openid);
        //System.out.println("用户信息:"+userInfo);
        assert openid != null;
        List<UserModel> userModels = userMapper.OneOpenid(openid);

        // 是否存在
        if (CollectionUtils.isEmpty(userModels)){

            // 保存用户信息
            UserModel userModel = new UserModel();
            userModel.setEmail("");
            userModel.setName(userInfo.getString("nickname"));
            userModel.setAvatarUrl(userInfo.getString("figureurl_qq"));
            userModel.setType(1);
            userModel.setOpenid(openid);
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            String date = df.format(new Date());
            userModel.setCreatedAt(date);
            userModel.setUpdatedAt(date);

            userMapper.insert(userModel);
        }

        return "redirect:/";

    }

}
