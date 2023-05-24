package com.darling.Controller;


import com.alibaba.fastjson.JSON;
import com.darling.Service.IndexService;
import com.darling.Service.MenuService;
import com.darling.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.LinkedHashMap;
import java.util.Map;


@Controller
@RequestMapping("/")
public class LoginController {
    @Autowired
    private IndexService indexService;

    @Autowired
    private MenuService menuService;

    @RequestMapping( "/")
    public String index() {
        return "/login";
    }

    @RequestMapping("/login.html")
    public String toLogin() {
        return "/login";
    }

    @RequestMapping("/home.html")
    public String home() {
        return "/home";
    }

    @RequestMapping("/welcome.html")
    public String welcome() {
        return "/welcome";
    }

    /**
     * 登录
     *
     * @param request
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping( value = "/login.action")
    public String login(@RequestBody Map<String, String> request, HttpSession session) {
        Map<String, Object> map = new LinkedHashMap<>();
        String uid = request.get("uid");
        String password = request.get("password");
        System.out.println("uid:" + uid + "--pwd:" + password);
        User user = indexService.findUser(uid, password);
        if (user != null) {
            session.setAttribute("uid", uid);
            session.setAttribute("uname", user.getUname());
            session.setAttribute("utype", user.getUtype());
            map.put("msg","登录成功");
            map.put("success", true);
        } else {
            map.put("success", false);
            map.put("msg", "账号或密码错误！");
        }
        return JSON.toJSONString(map);
    }

    /**
     * 加载菜单列表
     *
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping( "/api/loadMenuList")
    public String loadMenuList(HttpSession session ) {
        Integer utype = (Integer) session.getAttribute("utype");
        String initJson = menuService.loadMenuList(utype);
        return initJson;
    }

    /**
     * 退出登录
     *
     * @param session
     * @return 返回到登录界面
     */
    @RequestMapping( "/logout.action")
    public String logout(HttpSession session) {
        // 清空session中的属性
        session.removeAttribute("uid");
        session.removeAttribute("uname");
        session.removeAttribute("utype");
        //让session无效
        session.invalidate();
        return "redirect:/login.html";
    }
}
