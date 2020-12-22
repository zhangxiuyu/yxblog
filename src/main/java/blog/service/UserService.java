package blog.service;


import blog.mapper.UserMapper;
import blog.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserSession userSession;


    public void createOrUpdate(UserModel user)
    {

        UserModel userModelData = (UserModel) userMapper.OneOpenid(user.getOpenid());

        // 为空就新增 存在就更新
        if (CollectionUtils.isEmpty((Collection<?>) userModelData)) {
            userMapper.insert(user);
        }else{
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            String date = df.format(new Date());

            userModelData.setUpdatedAt(date);
            userModelData.setAvatarUrl(user.getAvatarUrl());
            userModelData.setName(user.getName());
            userModelData.setEmail(user.getEmail());
            userMapper.update(userModelData);
        }
//        userSession.addUserSession(user.getOpenid());


    }

}
