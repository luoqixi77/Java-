package api.Feign.CusFeign;

import gm.common.Return.JwtAuthenticationResponse;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author luoqixi77
 * @version V1.0
 * @date 2023/4/7 17:12
 * @Description 远程调用接口
 */
@EnableFeignClients("cus-service")
public interface CusClient {

    /**
     * 远程调用登录
     * @param username 用户名
     * @return 返回响应实体
     */
    @PostMapping("/cus/login")
    ResponseEntity<JwtAuthenticationResponse> login(String username);

    /**
     * 远程调用查询用户信息
     * @param username 用户名
     * @return 返回用户实体
     */
    @RequestMapping("/cus/getUserDetails")
    UserDetails getUserDetails(String username);
}
