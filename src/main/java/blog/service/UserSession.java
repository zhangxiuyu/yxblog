package blog.service;

import blog.mapper.UserMapper;
import blog.model.UserModel;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.security.Key;
import java.util.List;

@Service
public class UserSession {


    @Autowired
    UserMapper userMapper;

    public void addUserSession(String openid,HttpServletRequest request) {

        if (openid != null){
            List<UserModel> userModels = userMapper.OneOpenid(openid);
            Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

            String jws = Jwts.builder().setSubject(userModels.toString()).signWith(key).compact();


        }
    }


}

