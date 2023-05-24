package cus.Controller;

import gm.common.Return.JsonResult;
import gm.common.Return.JwtAuthenticationResponse;
import gm.common.Return.ResultCode;
import cus.Service.UserDetailsServiceImpl;
import cus.config.JwtAuthenticationRequest;
import gm.common.utils.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;

/**
 * @author luoqixi77
 * @version V1.0
 * @date 2023/4/3 22:51
 * @Description 用户登录Controller层
 */
@Controller
@RequestMapping("/cus")
@Slf4j
public class LoginController {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;


    /**
     * 用户登录请求
     * @return ResponseEntity，其中包含JwtAuthenticationResponse，其中ResultCode为USER_NOT_LOGIN。
     */
    @GetMapping("/login")
    public String login(){
        //登录get请求，返回未登录，进行登录
        return "login";
    }

    /**
     * 用户登录请求
     * @param jwtAuthenticationRequest 包含用户登录凭据的请求正文。
     * @return ResponseEntity，其中包含JwtAuthenticationResponse，其中包含令牌和ResultCode为SUCCESS的JsonResult。
     * @throws Exception 如果生成身份验证令牌时出错。
     */
    @PostMapping(value = "/login")
    public ResponseEntity<JwtAuthenticationResponse> createAuthenticationToken(@RequestBody JwtAuthenticationRequest jwtAuthenticationRequest) throws Exception {
        //获取Customer用户
        final UserDetails userDetails = userDetailsService.loadUserByUsername(jwtAuthenticationRequest.getUsername());
        log.info("userDetails:",userDetails);
        System.out.println("1111");
        if (userDetails.getPassword().equals(jwtAuthenticationRequest.getPassword())){
            //获取token
            final String token = jwtTokenUtil.generateToken(userDetails);
            log.debug(token,"token");
            if (token!=null&&!("".equals(token))){
                //token不为空就将token放到请求头中
                HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
                jwtTokenUtil.addAuthentication(response,token);
                //封装返回的Json数据
                JsonResult jsonResult=new JsonResult(true, ResultCode.SUCCESS,userDetails);
                //再次封装返回的数据+其他（状态码，token）
                return ResponseEntity.ok(new JwtAuthenticationResponse<>(jsonResult, token, ResultCode.SUCCESS));
            }else {
                return ResponseEntity.ok(new JwtAuthenticationResponse(ResultCode.COMMON_FAIL));
            }
        }
        //没有用户,或者username，password输入错误
        return ResponseEntity.ok(new JwtAuthenticationResponse(ResultCode.PARAM_NOT_VALID));
    }

    /**
     *
     * 当用户获得token后，在gateway中拦截鉴权通过feign调用的方法
     * @param username 用户名
     * @return 返回一个UserDetails对象
     */
    @RequestMapping("/getUserDetails")
    public UserDetails getUser(String username){
        return userDetailsService.loadUserByUsername(username);
    }

}
