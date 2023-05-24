package com.luoqixi.controller;

import com.luoqixi.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
//@RequestMapping("/test")
public class DomeController {
    @RequestMapping(value = {"/hello","/abc"},method = {RequestMethod.POST,RequestMethod.GET})
    public String demo(){
        return "success";
    }


    @RequestMapping("test/rest/{username}/{id}")
    public String testRest(@PathVariable Integer id,@PathVariable String username){
        System.out.println(id+username);
        return "success";
    }

    @RequestMapping("/test/admin")
    public String testServletApi(HttpServletRequest request){
        HttpSession session = request.getSession();
        String s = request.getParameter("username");
        String p = request.getParameter("password");
        System.out.println("username:"+s+",password:"+p);
        return "success";
    }

    @RequestMapping("/param")
    public String getParam(

            /**
             * value:设置与请求中相对应的属性名，即形参绑定的请求参数的名字
             * required：默认值为true，表示必须获取这一请求参数
             * defaultValue:如果没有赋值，会自动为参数赋值
             */
            @RequestParam(value = "username",required = true,defaultValue ="admin")
            String username,
            String password,
            @RequestHeader(value = "referer") String referer,
            @CookieValue(value = "JSESSIONID") String JsessionId
    ){
        System.out.println(JsessionId);
        System.out.println(referer);
        System.out.println("username:"+username+",password:"+password);
        return "success";
    }


    @RequestMapping("/param/pojo")
    public String testPojo(User user){
        System.out.println(user);
        return "success";
    }
}
