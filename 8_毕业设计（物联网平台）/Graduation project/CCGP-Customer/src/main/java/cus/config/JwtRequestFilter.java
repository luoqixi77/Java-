package cus.config;

import gm.common.utils.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author luoqixi77
 * @version V1.0
 * @date 2023/4/4 15:35
 * @Description  这个类过滤传入的请求并在安全上下文持有者中添加身份验证信息，如果授权标头中存在有效的JWT，则添加。
 */
@Component
@Slf4j
public class JwtRequestFilter extends OncePerRequestFilter {

        @Autowired
        private UserDetailsService userDetailsService;

        @Autowired
        private JwtTokenUtil jwtTokenUtil;

        @Autowired
        private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    /**
     * 如果授权标头中存在有效的JWT，则过滤传入的请求并在安全上下文持有者中添加身份验证信息。
     * @param request 传入的HttpServletRequest
     * @param response 传出的HttpServletResponse
     * @param chain 过滤器链
     * @throws ServletException 处理请求时发生错误
     * @throws IOException 处理请求时发生错误
     */
        @Override
        protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
                throws ServletException, IOException {

            final String authorizationHeader = request.getHeader("Authorization");
            log.debug("authorizationHeader={}",authorizationHeader);
            String username = null;
            String jwt = null;

            if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
                jwt = authorizationHeader.substring(7);
                log.debug("jwt={}",jwt);
                try {
                    username = jwtTokenUtil.getUsernameFromToken(jwt);
                    log.debug("username={}",username);
                } catch (Exception e){
                    jwtAuthenticationEntryPoint.commence(request,response,null);
                    return;
                }
            }

            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

                UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
                log.debug("userDetails={}",userDetails);
                if (jwtTokenUtil.validateToken(jwt, userDetails)) {
                    log.debug("jwtUtils.validateToken(jwt,userDetails)={}",jwtTokenUtil.validateToken(jwt, userDetails));
                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                            userDetails, null, userDetails.getAuthorities());
                    usernamePasswordAuthenticationToken
                            .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                }
            }
            chain.doFilter(request, response);
        }

}
