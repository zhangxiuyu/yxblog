package blog.controller.home;

import blog.mapper.UserMapper;
import blog.model.UserModel;
import blog.service.GitHubConstants;
import blog.service.HttpClientUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.Map;

@Controller
public class GitHubController {


    @Autowired
    UserMapper userMapper;


    @RequestMapping("/gitHub")
    public String callback(String code, String state) throws Exception {
        //获取到code和state
        System.out.println("code:" + code);
        System.out.println("state:" + state);

        if (!StringUtils.isEmpty(code) && !StringUtils.isEmpty(state)) {
            try {
                //拿到我们的code,去请求token
                //发送一个请求到
                String token_url = GitHubConstants.TOKEN_URL.replace("CLIENT_ID", GitHubConstants.CLIENT_ID)
                        .replace("CLIENT_SECRET", GitHubConstants.CLIENT_SECRET)
                        .replace("CALLBACK", GitHubConstants.CALLBACK)
                        .replace("CODE", code);

                String responseStr = HttpClientUtils.doGet(token_url);

                assert responseStr != null;
                String token = HttpClientUtils.parseResponseEntity(responseStr).get("access_token");

                //根据token发送请求获取登录人的信息
                String userinfo_url = GitHubConstants.USER_INFO_URL.replace("TOKEN", token);

                responseStr = HttpClientUtils.doGetUserInfo(userinfo_url,token);//json

                Map<String, String> responseMap = HttpClientUtils.parseResponseEntityJSON(responseStr);
                //System.out.println("登录用户信息:" + responseMap);//responseMap里面保存着用户登录信息
                //System.out.println("获取登录用户的用户名:" + responseMap.get("login"));

                // 保存用户信息
                UserModel userModel = new UserModel();
                userModel.setEmail(responseMap.get("email"));
                userModel.setName(responseMap.get("login"));
                userModel.setAvatarUrl(responseMap.get("avatar_url"));
                userModel.setOpenid(responseMap.get("id"));
                userModel.setCreatedAt(Date.from());
                userMapper.inst(userModel);


            }catch (Exception e){
                return null;
            }

        }
        return "redirect:/";
    }
}
