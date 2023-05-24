package test.Fegin;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author luoqixi77
 * @version 1.0
 * @date 2023/3/24 15:11
 * @Description TODO
 */

@RestController
public class test {
        public static ResponseEntity<String> httpPost(String url){
            long l = System.currentTimeMillis();
            //打开RestTemplate
            RestTemplate restTemplate=new RestTemplate();
            //创建请求体的容器
            MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
            requestEntity.add("Account","15153780254");
            requestEntity.add("Password","zizuoduoqing");
            //发送post请求，并接收返回来的数据，返回类型是String类型
            ResponseEntity<String> entity = restTemplate.postForEntity(url, requestEntity, String.class);

            //解析json数据
            JSONObject jsonObject = JSONObject.parseObject(entity.getBody());
            //获取json数据里面的某个value
            Object RO = jsonObject.get("ResultObj");
            //创建map集合存放接收到的json数据
            HashMap<Object, Object> hashMap = new HashMap<>();
            hashMap.putAll((Map<?, ?>) RO);
            //通过key去查找Token
            Object accessToken = hashMap.get("AccessToken");
            System.out.println(accessToken);
            long l1 = System.currentTimeMillis();
            System.out.println(l1-l);
            return entity;
        }
        @GetMapping("/kk/wuhu")
        public void t(){
            test.httpPost("http://api.nlecloud.com/Users/Login");
        }

    }