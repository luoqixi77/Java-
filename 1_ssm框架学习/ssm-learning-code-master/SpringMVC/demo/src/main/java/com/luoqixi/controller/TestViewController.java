package com.luoqixi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestViewController {

    @RequestMapping("/test/thymeleafview")
    public String testview(){
        return "success";
    }

    @RequestMapping("/test/internal")
    public String testinter(){
        return "forward:/test/model";
    }

    @RequestMapping("test/redirect")
    public String testRedirect(){
        return "redirect:/test/model";
    }
}
