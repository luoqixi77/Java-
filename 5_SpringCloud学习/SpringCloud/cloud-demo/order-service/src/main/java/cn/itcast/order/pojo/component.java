package cn.itcast.order.pojo;


import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 创建RestTemplate并注入Spring容器
 */
@Configuration
//@LoadBalancerClients(defaultConfiguration = {NacosSameClusterConfiguration.class})
public class component {
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
//
//    @Bean
//    @Scope(value="prototype")
//    public IRule load(){
//        return new NacosRule();
//    }
}
