package utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

public class JwtUtils {
    /**
     * 生成token
     */
    private static final long time=1000*60*60*24;
    private static final String signature = "!~#@$%KjkaKm23532*#";
    //自定义传入参数，设置为Map集合
    public static String getToken(Map<String,String> map) {
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DATE, 7);//默认7天过期

        //创建jwt builder
        JWTCreator.Builder builder = JWT.create();

        map.forEach((k, v) -> {
            builder.withClaim(k, v);
        });

        String jetToken = builder.withExpiresAt(instance.getTime())
                .sign(Algorithm.HMAC256(signature));
        return jetToken;
    }
        /**
     * 验证token
     */
    public static void verify(String jetToken){
        JWT.require(Algorithm.HMAC256(signature)).build().verify(jetToken);
    }

    /**
     * 获取token信息
     */
    public static DecodedJWT getTokenInfo(String jetToken){
        DecodedJWT verify = JWT.require(Algorithm.HMAC256(signature)).build().verify(jetToken);
        return verify;
    }
}
