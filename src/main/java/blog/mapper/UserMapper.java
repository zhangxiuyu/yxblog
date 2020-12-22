package blog.mapper;


import blog.model.UserModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface UserMapper {

    // 插入数据
    @Insert("insert into user (name,openid,avatar_url,email,created_at,updated_at,type) values ('${name}','${openid}','${avatarUrl}','${email}','${createdAt}','${updatedAt}','${type}')")
    void  insert(UserModel userModel);


    @Select("select * from user where id = ${id}")
    List<UserModel> One(int id);

    @Select("select * from user where openid = '${openid}'")
    List<UserModel> OneOpenid(String openid);
}
