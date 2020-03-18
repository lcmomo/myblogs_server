package cn.edu.nwsuaf.lims.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import cn.edu.nwsuaf.lims.model.User;
import org.springframework.stereotype.Service;

import static cn.edu.nwsuaf.lims.core.ProjectConstant.SCRECT_KEY;


/**
 * @author jinbin
 * @date 2018-07-08 21:04
 */
@Service("TokenService")
public class TokenService  {

    public String getToken(User user) {
        String token="";
//        token= JWT.create().withAudience(user.getUserid())// 将 user id 保存到 token 里面
//                .sign(Algorithm.HMAC256(secretKey));// 以 password 作为 token 的密钥

        token= JWT.create()
                .withClaim("userid",user.getUserid()).withClaim("username",user.getUsername())
                .withClaim("generatetime",System.currentTimeMillis())
                .withClaim("exptime",1000*1*60*60)
                .sign(Algorithm.HMAC256(SCRECT_KEY ));// 以 password 作为 token 的密钥
        return token;
    }
}