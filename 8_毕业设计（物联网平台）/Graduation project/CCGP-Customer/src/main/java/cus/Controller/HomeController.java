package cus.Controller;

import cus.Service.HomeService;
import cus.pojo.Customer;
import gm.common.Return.JwtAuthenticationResponse;
import gm.common.Return.ResultCode;
import io.jsonwebtoken.Jwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author luoqixi77
 * @version V1.0
 * @date 2023/4/4 9:51
 * @Description 用户相关操作controller层
 */
@RestController("/cus")
public class HomeController {

    @Autowired
    private HomeService homeService;

    /**
     * 获取除了密码外所有的用户的所有信息
     * @return 状态码和相关信息
     */
    @GetMapping("/getAllCusInfo")
    public ResponseEntity<JwtAuthenticationResponse> getAllCusInfo(){
        List<Customer> allCusInfo = homeService.getAllCusInfo();
        if (allCusInfo==null){
            return ResponseEntity.ok(new JwtAuthenticationResponse(ResultCode.PARAM_IS_BLANK));
        }
        return ResponseEntity.ok(new JwtAuthenticationResponse(allCusInfo, ResultCode.SUCCESS));
    }

    /**
     * 根据id获取用户信息
     * @param id 前台传来的id
     * @return 状态码和单个的用户信息
     */
    @GetMapping("/getSignCusInfo")
    public ResponseEntity<JwtAuthenticationResponse> getSignCusInfo(@RequestParam Integer id){
        Customer signCusInfo = homeService.getSignCusInfo(id);
        if (signCusInfo==null){
            return ResponseEntity.ok(new JwtAuthenticationResponse(ResultCode.PARAM_IS_BLANK));
        }
        return ResponseEntity.ok(new JwtAuthenticationResponse(signCusInfo, ResultCode.SUCCESS));
    }
}
