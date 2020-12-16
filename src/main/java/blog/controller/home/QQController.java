package blog.controller.home;


import blog.service.QQAuth;
import blog.service.QQConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class QQController {

    @Autowired
    QQConstants qqConstants;

    @RequestMapping("/QQ")
    String QQ(){
        System.out.println(qqConstants.getApp_id());

        String qqAppId = "101770145";
        String qqAuthPath = "http://127.0.0.1:8088/QQLogin";
        String state = "fjdslfjsdlkfd";
        String url = "https://graph.qq.com/oauth2.0/authorize?response_type=token&client_id="+qqAppId+"&redirect_uri="+qqAuthPath+"&state=" + state;

        return "redirect:" + url;
    }



    @RequestMapping("/QQLogin")
    String  QQLogin(HttpServletRequest request) throws Exception {

        String access_token = request.getParameter("access_token");
        String state = request.getParameter("state");
        String expires_in = request.getParameter("expires_in");

        // 获取openid
        String Openid  = QQAuth.getOpenid(access_token);
        System.out.println(Openid);

        return "redirect:/";

//        String openid = QQAuth.getUserInfo(url);
    }

}
