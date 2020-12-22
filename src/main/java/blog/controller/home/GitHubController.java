package blog.controller.home;

import blog.mapper.UserMapper;
import blog.model.UserModel;
import blog.service.GitHubConstants;
import blog.service.HttpClientUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class GitHubController {


    @Autowired
    UserMapper userMapper;


    /**
     *  github登录 跳转地址
     * @return
     */
    @RequestMapping("/githubUrl")
    public String githubUrl()
    {

        String url = GitHubConstants.CODE_URL
                .replace("CLIENT_ID",GitHubConstants.getClient_id())
                .replace("CALLBACK",GitHubConstants.getCallback());
        System.out.println("github login err:" + url);
        return "redirect:" + url;
    }


    /**
     * github 回调地址
     * @param code
     * @param state
     * @return
     */
    @RequestMapping("/gitHub")
    public String callback(String code, String state) {
        //获取到code和state
//        System.out.println("code:" + code);
//        System.out.println("state:" + state);

        if (!StringUtils.isEmpty(code) && !StringUtils.isEmpty(state)) {
            try {
                //拿到我们的code,去请求token
                //发送一个请求到
                String token_url = GitHubConstants.TOKEN_URL.replace("CLIENT_ID", GitHubConstants.getClient_id())
                        .replace("CLIENT_SECRET", GitHubConstants.getClient_secret())
                        .replace("CALLBACK", GitHubConstants.getCallback())
                        .replace("CODE", code);

                String responseStr = HttpClientUtils.doGet(token_url);

                assert responseStr != null;
                String token = HttpClientUtils.parseResponseEntity(responseStr).get("access_token");

                //根据token发送请求获取登录人的信息
                String userinfo_url = GitHubConstants.USER_INFO_URL.replace("TOKEN", token);

                responseStr = HttpClientUtils.doGetGetHubUserInfo(userinfo_url,token);//json

                Map<String, String> responseMap = HttpClientUtils.parseResponseEntityJSON(responseStr);
                //System.out.println("登录用户信息:" + responseMap);//responseMap里面保存着用户登录信息
                //System.out.println("获取登录用户的用户名:" + responseMap.get("login"));

                String openid = responseMap.get("id");
                List<UserModel> userModels = userMapper.OneOpenid(openid);

                // 是否存在
                if (CollectionUtils.isEmpty(userModels)){
                    // 保存用户信息
                    UserModel userModel = new UserModel();
                    userModel.setType(1);
                    userModel.setEmail(responseMap.get("email"));
                    userModel.setName(responseMap.get("login"));
                    userModel.setAvatarUrl(responseMap.get("avatar_url"));
                    userModel.setOpenid(openid);
                    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
                    String date = df.format(new Date());
                    userModel.setCreatedAt(date);
                    userModel.setUpdatedAt(date);

                    userMapper.insert(userModel);
                }

                return "redirect:/";
            }catch (Exception e){
                System.out.println("github login err:" + e.getMessage());
                return "redirect:/";
            }

        }
        return "redirect:/";
    }
}
