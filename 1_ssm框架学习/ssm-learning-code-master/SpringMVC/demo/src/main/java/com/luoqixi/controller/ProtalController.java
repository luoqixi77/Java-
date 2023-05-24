//package com.luoqixi.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//@Controller
//public class ProtalController {
//    /**
//     * params属性有四种表达式：
//     * “param”：表示当前所匹配请求的请求参数中必须携带param参数
//     * “！param”：表示当前所匹配请求的请求参数中一定不能携带param参数
//     * “param=value”：表示当前所匹配请求中必须携带param且参数必须为value
//     * “param！=value”：表示当前所匹配请求的请求参数中可以不携带param，若携带一定能是value值
//     * @return
//     */
//    @RequestMapping(
//            value = "/",
//            method = RequestMethod.GET
////            params = {"username","!password","age=18","gender!=男"}
//    )
////    @GetMapping("/")
////    @PostMapping
////    @PutMapping
////    @DeleteMapping
//    public String protal(){
//        return "index";
//    }
//
//
//    /**
//     * ？：任意的单个字符（不包括？）
//     * *：任意个数的任意字符（不包括？和/）
//     * **：任意层数的任意目录，注意使用方式
//     * @return
//     */
//
////    @RequestMapping("/a?a/ant")
////    @RequestMapping("/**/ant")
////    @RequestMapping("/*/ant")
//    public String testAnt(){
//        return "success";
//    }
//}
