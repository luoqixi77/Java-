package gw.Filter;

import api.Feign.CusFeign.CusClient;
import gm.common.Return.ResultCode;
import gm.common.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author luoqixi77
 * @version V1.0
 * @date 2023/4/7 14:14
 * @Description jwt鉴权，是否有权限查看资源
 */
@Order(1)
@Component
public class JwtFilter  implements GlobalFilter {
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private CusClient cusClient;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpResponse response = exchange.getResponse();
        //获取请求参数
        ServerHttpRequest request = exchange.getRequest();
        //如果是登录请求直接放行
        if (request.getURI().getPath().contains("/cus/login")) {
            return chain.filter(exchange);
        }
        MultiValueMap<String, String> queryParams = request.getQueryParams();
        //获取参数中的token
        String token = queryParams.getFirst("Authorization");
        String username = queryParams.getFirst("username");
        //获取请求参数中的username
        //解析token中的role，判断是否有权限查看资源
        if (token!=null){
            //判断token是否正确,是否过期
            UserDetails userDetails = cusClient.getUserDetails(username);
            if (jwtTokenUtil.validateToken(token,userDetails)){
                return Mono.error(new Error(String.valueOf(ResultCode.USER_ACCOUNT_EXPIRED)));
            }else {
                //如果为false，则没有权限
                if (userDetails.isEnabled()){
                    return chain.filter(exchange);
                }else {
                    response.setStatusCode(HttpStatus.valueOf("没有权限"));
                    return response.setComplete();
                }
            }
        }
        return Mono.error(new Error("jwt为空,重新登录"));
    }
}
