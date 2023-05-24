package cus.config;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @author luoqixi77
 * @version V1.0
 * @date 2023/4/4 15:59
 * @Description jwt实体类
 */
public class JwtAuthenticationToken extends UsernamePasswordAuthenticationToken {

    /**
     * 令牌
     */
    private String token;

    /**
     * 构造函数
     * @param token 令牌
     */
    public JwtAuthenticationToken(String token) {
        super(null, null);
        this.token = token;
    }

    /**
     * 构造函数
     * @param userDetails 用户详情
     * @param token 令牌
     * @param authorities 权限集合
     */
    public JwtAuthenticationToken(UserDetails userDetails, String token, Collection<? extends GrantedAuthority> authorities) {
        super(userDetails, null, authorities);
        this.token = token;
    }

    /**
     * 获取令牌
     * @return 令牌
     */
    public String getToken() {
        return this.token;
    }

    /**
     * 获取凭证
     * @return null
     */
    @Override
    public Object getCredentials() {
        return null;
    }

    /**
     * 获取主体
     * @return null
     */
    @Override
    public Object getPrincipal() {
        return null;
    }

}
