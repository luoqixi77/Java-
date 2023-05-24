package test.Fegin;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;

/**
 * @author luoqixi77
 * @version 1.0
 * @date 2023/3/24 20:34
 * @Description TODO
 */
@RestController
public class test_1 {
    public static void test_2(String url){
        long l = System.currentTimeMillis();
        RestTemplate restTemplate=new RestTemplate();
        //设置请求体
        HashMap<String,Object> map = new HashMap<>();
        map.put("Account","15153780254");
        map.put("Password","zizuoduoqing");
        //发送请求
        String result= restTemplate.postForObject(url,map,String.class);
        System.out.println(result);
        //将接收到的String类型转化为json对象
        JSONObject jsonObject = JSONObject.parseObject(result);
        //通过key值去查找Token
        Object o = jsonObject.getJSONObject("ResultObj").get("AccessToken");
        System.out.println(o);
        long l1 = System.currentTimeMillis();
        System.out.println(l1-l);
    }
    @GetMapping("/kk/awu")
    public void PostYun(){
        test_1.test_2("http://api.nlecloud.com/Users/Login");
    }
}
