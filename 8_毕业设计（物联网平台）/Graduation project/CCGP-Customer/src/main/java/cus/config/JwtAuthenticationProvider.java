package cus.config;

import gm.common.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

/**
 * @author luoqixi77
 * @version V1.0
 * @date 2023/4/4 15:30
 * @Description jwt验证类
 */
@Service
public class JwtAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    /**
     * 验证给定的JWT令牌。
     * @param authentication JWT身份验证令牌。
     * @return 已验证的JWT身份验证令牌。
     * @throws AuthenticationException 如果令牌无效。
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken) authentication;

        String authToken = jwtAuthenticationToken.getToken();

        String username = jwtTokenUtil.getUsernameFromToken(authToken);

        if (username == null || SecurityContextHolder.getContext().getAuthentication() != null) {
            throw new JwtAuthenticationException("Token is invalid");
        }

        UserDetails userDetails = userDetailsService.loadUserByUsername(username);

        if (!jwtTokenUtil.validateToken(authToken, userDetails)) {
            throw new JwtAuthenticationException("Token is invalid");
        }

        return new JwtAuthenticationToken(userDetails, authToken, userDetails.getAuthorities());
    }

    /**
     * 检查是否支持给定的身份验证类。
     * @param authentication 要检查的身份验证类。
     * @return 如果支持身份验证类，则为true，否则为false。
     */
    @Override
    public boolean supports(Class<?> authentication) {
        return JwtAuthenticationToken.class.isAssignableFrom(authentication);
    }

}
