package gw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @author luoqixi77
 * @version V1.0
 * @date 2023/4/7 10:54
 * @Description 网关模块启动类
 */
@SpringBootApplication(scanBasePackages = {"gm.common.utils"})
@EnableHystrix
public class GatewayApplication {
    /**
     * gateway模块启动主方法
     * @param args 方法参数
     */
    public static void main(String[] args){
        SpringApplication.run(GatewayApplication.class,args);
    }
}
