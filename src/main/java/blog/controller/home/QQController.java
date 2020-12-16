package blog.controller.home;


import blog.service.QQConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class QQController {

    @Autowired
    QQConstants qqConstants;

    @RequestMapping("QQ")
    String QQ()
    {
        System.out.println(qqConstants.getApp_id());

        String qqAppId = "101770145";
        String qqAuthPath = "http://127.0.0.1:8088/QQLogin";
        String state = "fjdslfjsdlkfd";
        String url = "https://graph.qq.com/oauth2.0/authorize?response_type=token&client_id="+qqAppId+"&redirect_uri="+qqAuthPath+"&state=" + state;

        return "redirect:" + url;
    }



    @RequestMapping("QQLogin")
    void  QQLogin(HttpServletRequest request, HttpServletResponse response) throws Exception{

        // QQ登录有点特殊，参数放在#后面，后台无法获取#后面的参数，只能用JS做中间转换
        String html =   "<!DOCTYPE html>" +
                "<html lang=\"zh-cn\">" +
                "<head>" +
                "	<title>QQ登录重定向页</title>" +
                "	<meta charset=\"utf-8\"/>" +
                "</head>" +
                "<body>" +
                "	<script type=\"text/javascript\">" +
                "	location.href = location.href.replace('#', '&').replace('auth_qq', 'auth_qq_redirect');" +
                "	</script>" +
                "</body>" +
                "</html>";
        response.getWriter().print(html);
    }

}
