package Restemplate;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author luoqixi77
 * @version 1.0
 * @date 2023/3/24 15:03
 * @Description TODO
 */
public class test {

    @Configuration
    public class RestTemplateConfig {

        @Bean
        public RestTemplate restTemplate(ClientHttpRequestFactory factory){
            return new RestTemplate(factory);
        }

        @Bean
        public ClientHttpRequestFactory simpleClientHttpRequestFactory(){
            SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
            factory.setConnectTimeout(15000);
            factory.setReadTimeout(5000);
            return factory;
        }
    }

    @Autowired
    RestTemplate restTemplate;

    @Test
    public void postTest() throws Exception {
        MultiValueMap<String, Object> requestEntity = new LinkedMultiValueMap<>();
        Map paraMap = new HashMap();
        requestEntity.add("Account", "15153780254");
        requestEntity.add("Password", "zizuoduoqing");
        requestEntity.add("IsRememberMe", true);
        RestTemplate restTemplate = new RestTemplate();
        System.out.println(restTemplate.postForObject("http://api.nlecloud.com/Users/Login", requestEntity, String.class));
    }
}
