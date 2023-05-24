package gw.Filter;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author luoqixi77
 * @version V1.0
 * @date 2023/5/9 22:48
 * @Description TODO
 */
@RestController
public class Fallback {

    @RequestMapping("/gatewayFallbackCus")
    public String gatewayFallbackCus(){
        return "{\"msg\":\"用户服务降级\",\"code\":200}";
    }
    @RequestMapping("/gatewayFallbackMod")
    public String gatewayFallbackMod(){
        return "{\"msg\":\"设备服务降级\",\"code\":200}";
    }
}
