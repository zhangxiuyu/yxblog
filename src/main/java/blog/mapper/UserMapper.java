package blog.mapper;


import blog.model.UserModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {


    @Insert("inset int user (name,openid,avatar_url,email,created_at) values (${name},${openid},${avatar_url},${email},${created_at}})")
    List<UserModel> inst(UserModel userModel);

}
