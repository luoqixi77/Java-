package com.ssm.controller;


import com.ssm.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class HelloController {
    @Autowired
    public HelloService helloService;
}
