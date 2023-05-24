package jwt;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.Test;

import java.util.Date;
import java.util.UUID;

public class TEST {

    private long time=1000*60*60*24;
    private String signature = "admin";
    @Test
    public void jwt(){
        JwtBuilder jwt = Jwts.builder();
        String  jetToken = jwt
                //设置Header
                .setHeaderParam("typ","JWT")
                .setHeaderParam("alg","HS256")
                //设置Payload
                .claim("username","tom")
                .claim("role","admin")
                .setSubject("admin-test")
                .setExpiration(new Date(System.currentTimeMillis()+time))
                .setId(UUID.randomUUID().toString())
                //配置signature
                .signWith(SignatureAlgorithm.HS256,signature)
                .compact();
        System.out.println(jetToken);
    }
}
