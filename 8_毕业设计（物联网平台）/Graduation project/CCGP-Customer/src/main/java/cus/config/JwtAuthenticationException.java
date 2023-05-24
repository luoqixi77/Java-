package cus.config;

import org.springframework.security.core.AuthenticationException;

/**
 * @author luoqixi77
 * @version V1.0
 * @date 2023/4/4 16:01
 * @Description TODO
 */
public class JwtAuthenticationException extends AuthenticationException {

    /**
     * 构造函数
     * @param msg 异常信息
     */
    public JwtAuthenticationException(String msg) {
        super(msg);
    }

}
