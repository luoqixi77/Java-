package test.Fegin;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.http.HttpClient;
import java.util.HashMap;

/**
 * @author luoqixi77
 * @version 1.0
 * @date 2023/3/26 17:24
 * @Description 带着Token去访问数据
 */
@RestController
@Slf4j
public class test_2 {
    @GetMapping("/kk/dev")
    public void PostYun() throws UnsupportedEncodingException {
        String url1="http://api.nlecloud.com/Users/Login";
        String url2="http://api.nlecloud.com/devices/654178/Sensors/yanwu";
//        String url3=url2+"/devices";
//        String devices="{\"deviceId\":\"654178\"}";
        //登录
        RestTemplate restTemplate = new RestTemplate();
        //设置请求体
        HashMap<String, Object> map = new HashMap<>();
        map.put("Account", "15153780254");
        map.put("Password", "zizuoduoqing");
        map.put("IsRememberMe",true);
        HttpEntity<HashMap<String,Object>> tHttpEntity = new HttpEntity<>(map, null);
        //发送请求
        ResponseEntity<String> result = restTemplate.exchange(url1,HttpMethod.POST,tHttpEntity,String.class);
        //返回的json数据
        System.out.println("result=========>"+result);
        String body = result.getBody();
        //返回的body
        System.out.println("body=======>"+body);
        //String转化为json对象，获取AccessToken
        JSONObject jsonObject = JSONObject.parseObject(body);
        Object AccessToken = jsonObject.getJSONObject("ResultObj").get("AccessToken");
        System.out.println("AccessToken======>"+AccessToken);

        String AccessToken1=(String)AccessToken;
        RestTemplate restTemplate1 = new RestTemplate();
        //设置请求头
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_PROBLEM_JSON);
        httpHeaders.set("AccessToken",AccessToken1);
        //设置请求体
        MultiValueMap<String, Object> requestEntity = new LinkedMultiValueMap<>();
//        requestEntity.add("devicesId",654178);
//        requestEntity.add("msg",1);

        HttpEntity<Object> stringHttpEntity = new HttpEntity<>(requestEntity, httpHeaders);
        ResponseEntity<String> exchange = restTemplate1.exchange(url2, HttpMethod.GET, stringHttpEntity, String.class);
        System.out.println(exchange);
    }
}
