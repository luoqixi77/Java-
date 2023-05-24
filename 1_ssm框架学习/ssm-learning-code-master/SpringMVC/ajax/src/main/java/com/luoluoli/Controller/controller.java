package com.luoluoli.Controller;

import com.luoluoli.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 1,@RequestBody:
 * 将请求体中的内容和控制器方法的形参进行绑定,
 * 使用该注解可以将json格式的请求参数转换为Java对象
 * 2，@ResponseBody：
 * 将标识的控制器方法的返回值作为响应报文的响应体响应到浏览器
 *使用该注解可以响应浏览器json格式的数据
 * 3,常用的java对象转换为json的结果：
 * 实体类：json对象
 * map：json对象
 * list：json数组
 */
@Controller
public class controller {
    @RequestMapping("/test/ajax")
    public void testAjax(Integer id, @RequestBody String requestBody, HttpServletResponse response) throws IOException {
        System.out.println("requestBody:"+requestBody);
        System.out.println("id"+id);
        response.getWriter().write("hello,axios");
    }

    //处理json格式请求参数
//    @RequestMapping("/test/json")
//    public void testJson(@RequestBody User user,HttpServletResponse response) throws IOException {
//        System.out.println("User:"+user);
//        response.getWriter().write("hello,json");
//    }

    @RequestMapping("/test/json")
    public void testJson(@RequestBody Map<String,Object> map, HttpServletResponse response) throws IOException {
        System.out.println("map:"+map);
        response.getWriter().write("hello,json");
    }

    @RequestMapping("/test/ResponseBody")
    @ResponseBody
    public Map<String,Object> test(){
        User user1 = new User(1333, "admin1", "123454", 10, "男");
        User user2 = new User(2333, "admin2", "123454", 10, "男");
        User user3 = new User(3333, "admin3", "123454", 10, "男");
        Map<String,Object>map=new HashMap<>();
        map.put("1333",user1);
        map.put("2333",user1);
        map.put("3333",user1);
        return map;
    }
//    public User testResponseBody(){
//        User user = new User(2333,"admin","123454",10,"男");
//        return user;
//    }


}
