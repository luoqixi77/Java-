package cn.itcast.feign.Config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

public class FeignClientConfiguration {
    @Bean
    public Logger.Level feignLogLevel(){
        return Logger.Level.BASIC;
    }
}
