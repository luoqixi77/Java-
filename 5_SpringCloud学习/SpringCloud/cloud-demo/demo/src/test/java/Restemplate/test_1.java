package Restemplate;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

/**
 * @author luoqixi77
 * @version 1.0
 * @date 2023/3/24 15:11
 * @Description TODO
 */
public class test_1 {

    public class HttpTemplate {

        public static String httpGet(String url){
            RestTemplate restTemplate=new RestTemplate();
            restTemplate.put("Account","15153780254");
            restTemplate.put("Password","zizuoduoqing");
            restTemplate.put("IsRememberMe",true);
            String result=restTemplate.exchange(url, HttpMethod.GET,null,String.class).getBody();
            return result;
        }

        public static String httpPost(String url,String name){
            RestTemplate restTemplate=new RestTemplate();
            restTemplate.put("Account","15153780254");
            restTemplate.put("Password","zizuoduoqing");
            restTemplate.put("IsRememberMe",true);
            return restTemplate.postForEntity(url,name,String.class).getBody();
        }

        public static void main(String str[]){
            System.out.println(HttpTemplate.httpPost("http://api.nlecloud.com/Users/Login","ming"));
        }
    }
}
