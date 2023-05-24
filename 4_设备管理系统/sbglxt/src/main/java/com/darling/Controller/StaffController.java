package com.darling.Controller;


import com.alibaba.fastjson.JSON;
import com.darling.Service.RequisitionService;
import com.darling.pojo.Requisition;
import com.darling.utils.DataUtil;
import com.darling.vo.RequisitionVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private RequisitionService requisitionService;

    @RequestMapping(value = "/apply.html")
    public String apply() {
        return "/staff/apply.html";
    }

    /**
     * 查看申领信息，只能查看自己的
     * @param rv
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/apply/list")
    public DataUtil applyList(RequisitionVo rv, HttpServletRequest request) {
        String uname = (String)request.getSession().getAttribute("uname");
        rv.setRtaker(uname);
        // 设置分页信息
        PageHelper.startPage(rv.getPage(), rv.getLimit());
        // 查询
        List<Requisition> list = requisitionService.findRequisitionList(rv);
        // 创建分页对象
        PageInfo<Requisition> pageInfo = new PageInfo<>(list);
        // 按接口要求返回数据
        DataUtil data = new DataUtil(pageInfo.getTotal(), pageInfo.getList());
        return data;
    }

    /**
     * 提交申请
     *
     * @param rt
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/apply/add")
    public String addPutinInfo(Requisition rt, HttpServletRequest request) {
        HashMap<String, Object> map = new HashMap<>();
        // 获取领用人
        String uname = (String) request.getSession().getAttribute("uname");
        rt.setRtaker(uname);

        // 生成时间戳，保证主键的唯一性
        Date date = new Date();
        String rid = String.valueOf(date.getTime());
        rt.setRid(rid);

        rt.setRstatus("申请中");
        rt.setRtype("申请发放");

        System.out.println(rt);
        boolean result = requisitionService.add(rt);
        if (result) {
            map.put("success", true);
            map.put("msg", "提交申请成功！");
        } else {
            map.put("success", false);
            map.put("msg", "提交申请失败,请稍后再试！");
        }
        return JSON.toJSONString(map);
    }

    /**
     * 撤销申请
     * @param rid
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/apply/revoke")
    public String revoke(@RequestParam("rid") String rid) {
        HashMap<String, Object> map = new HashMap<>();
        boolean result = requisitionService.revoke(rid);
        if (result) {
            map.put("success", true);
            map.put("msg", "撤销成功！");
        } else {
            map.put("success", false);
            map.put("msg", "撤销失败，请稍后重试！");
        }
        return JSON.toJSONString(map);
    }

    @RequestMapping(value = "/todo.html")
    public String todo(){
        return "/staff/todo.html";
    }

    /**
     * 待领取列表
     * @param rv
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/todo/list")
    public DataUtil todoList(RequisitionVo rv, HttpServletRequest request){
        String uname = (String)request.getSession().getAttribute("uname");
        rv.setRtaker(uname);
        rv.setRstatus("待领取");
        // 设置分页信息
        PageHelper.startPage(rv.getPage(), rv.getLimit());
        // 查询
        List<Requisition> list = requisitionService.findRequisitionList(rv);
        // 创建分页对象
        PageInfo<Requisition> pageInfo = new PageInfo<Requisition>(list);
        // 按接口要求返回数据
        DataUtil data = new DataUtil(pageInfo.getTotal(), pageInfo.getList());
        return data;
    }
}
