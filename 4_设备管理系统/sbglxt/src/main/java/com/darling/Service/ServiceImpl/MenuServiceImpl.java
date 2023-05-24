package com.darling.Service.ServiceImpl;


import com.alibaba.fastjson.JSON;
import com.darling.Dao.MenuMapper;
import com.darling.Service.MenuService;
import com.darling.pojo.Menu;
import com.darling.utils.Information;
import com.darling.utils.CUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    /**
     * 加载所有菜单列表
     *
     * @return
     */
    @Override
    public String loadMenuList(Integer utype) {
        // 用来保存menuInfo信息
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        // 保存homeInfo信息
        Map<String, Object> home = new LinkedHashMap<String, Object>();
        // 保存logoInfo信息
        Map<String, Object> logo = new LinkedHashMap<String, Object>();

        // 先查出所有的菜单列表
        List<Menu> menuList = menuMapper.findMenuList(utype);
        // 保存菜单关系
        List<Information> informationList = new ArrayList<>();
        for (Menu menu : menuList) {
            // 遍历菜单列表，创建菜单节点对象，以构建菜单间的层级关系
            Information information = new Information();
            information.setId(menu.getId());
            information.setPid(menu.getPid());
            information.setTitle(menu.getTitle());
            information.setHref(menu.getHref());
            information.setTarget(menu.getTarget());
            information.setIcon(menu.getIcon());
            information.setUtype(menu.getUtype());
            informationList.add(information);
        }
        home.put("title", "首页");
        home.put("href", "/welcome.html");//控制器路由,自行定义
        logo.put("title", "设备管理系统");
        logo.put("image", "../image/logo.png");
        logo.put("href", "");
        // 构建init.json数据
        map.put("homeInfo", home);
        map.put("logoInfo", logo);
        map.put("menuInfo", CUtil.toTree(informationList, 0));
        return JSON.toJSONString(map);
    }
}
