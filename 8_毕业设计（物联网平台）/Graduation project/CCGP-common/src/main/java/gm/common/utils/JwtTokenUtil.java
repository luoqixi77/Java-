package gm.common.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * @author luoqixi77
 * @version V1.0
 * @date 2023/4/4 15:31
 * @Description Jwt工具类
 */
@Component
@Slf4j
public class JwtTokenUtil implements Serializable {

    private static final long serialVersionUID = -2550185165626007488L;
    /**
     * token过期时间
     */
    public static final long JWT_TOKEN_VALIDITY = 1000 * 60 * 60;
    private static final String SECRET = "wcslzh";


    /**
     * 从token中获取用户名
     * @param token 令牌
     * @return 用户名
     */
    public String getUsernameFromToken(String token) {
        try {
            return getClaimFromToken(token, Claims::getSubject);
        } catch (Exception e) {
            log.error("从token中获取用户名出错: {}", e.getMessage());
            return null;
        }
    }

    /**
     * 从 Token 中获取 Token 的创建时间
     *
     * @param token 令牌
     * @return 创建时间
     */
    public Date getCreatedDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getIssuedAt);
    }

    /**
     * 从 Token 中获取 Token 的过期时间
     *
     * @param token 令牌
     * @return 过期时间
     */
    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    /**
     * 从 Token中获取claims过载信息
     *
     * @param token          令牌
     * @param claimsResolver 获取的token里面的相关信息
     * @param <T>            任意类型
     * @return claims
     */
    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    /**
     * 为了从token中检索任何信息，我们将需要密钥
     *
     * @param token 令牌
     * @return claims对象
     */
    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
    }

    /**
     * 判断 Token 是否过期
     *
     * @param token 令牌
     * @return true表示过期，false表示未过期
     */
    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    /**
     * 根据用户信息生成 Token
     *
     * @param userDetails 用户信息
     * @return 生成的 Token
     */
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("roles", userDetails.getAuthorities());
        return doGenerateToken(claims, userDetails.getUsername());
    }

    /**
     * 根据用户信息生成 Token
     *
     * @param claims  claims
     * @param subject username
     * @return 生成的 Token
     */
    private String doGenerateToken(Map<String, Object> claims, String subject) {
        final Date createdDate = new Date();
        final Date expirationDate = new Date(createdDate.getTime() + JWT_TOKEN_VALIDITY * 1000);
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(createdDate)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
    }

    /**
     * 将token添加到请求头
     *
     * @param response 请求
     * @param token    令牌
     */
    public void addAuthentication(HttpServletResponse response, String token) {
        String bearerToken = "Bearer " + token;
        response.addHeader("Authorization", bearerToken);
    }

    /**
     * 验证token是否正确
     *
     * @param token       令牌
     * @param userDetails 用户信息
     * @return true表示正确，false表示错误
     */
    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}

