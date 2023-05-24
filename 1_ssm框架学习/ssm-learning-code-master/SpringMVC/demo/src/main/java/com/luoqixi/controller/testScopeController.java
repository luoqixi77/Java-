package com.luoqixi.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelExtensionsKt;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.Objects;


@Controller
public class testScopeController {

    @RequestMapping("/test/mav")
    public ModelAndView testMAV(){
        /*
          ModelAndView包含model和view两个功能
          model：向请求域中共享数据
          view：设置逻辑视图实现页面跳转
         */
        ModelAndView mav = new ModelAndView();
        //向请求域中共享数据
        mav.addObject("testRequestScope","hello,ModelAndView");
        //设置逻辑视图
        mav.setViewName("success");
        return mav;
    }

    @RequestMapping("/test/model")
    public String testmodel(Model model){
        System.out.println(model.getClass().getName());
        model.addAttribute("testRequestScope","hello,Model");
        return "success";
    }

    @RequestMapping("/test/modelmap")
    public String testmodelmap(ModelMap modelMap){
        System.out.println(modelMap.getClass().getName());
        modelMap.addAttribute("testRequestScope","hello,Modelmap");
        return "success";
    }

    @RequestMapping("/test/map")
    public String testmap(Map<String,Object> map){
        System.out.println(map.getClass().getName());
        map.put("testRequestScope","hello,map");
        return "success";
    }

    @RequestMapping("/test/session")
    public String testSession(HttpSession session){
        session.setAttribute("testSessionScope","hello,session");
        return "success";
    }


    @RequestMapping("/test/application")
    public String testApplication(HttpSession session){
        ServletContext servletContext = session.getServletContext();
        servletContext.setAttribute("testApplicationScope","hello,application");
        return "success";
    }
}
