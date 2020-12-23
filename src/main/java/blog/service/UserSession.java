package blog.service;

import blog.mapper.UserMapper;
import blog.model.UserModel;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
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
        Jws<Claims> jws;
        if (openid != null){
            List<UserModel> userModels = userMapper.OneOpenid(openid);
            Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

            String jwss = Jwts.builder().setSubject(userModels.toString()).signWith(key).compact();
            jws = Jwts.parserBuilder()  // (1)
                    .setSigningKey(key)         // (2)
                    .build()                    // (3)
                    .parseClaimsJws(jwss); // (4)

            System.out.println(jws);
        }
    }


}

