package com.tiyamate.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class testController {
    @RequestMapping("/test/hello")
    public String test(){
        return "success";
    }
}
