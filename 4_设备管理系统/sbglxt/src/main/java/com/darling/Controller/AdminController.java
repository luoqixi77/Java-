package com.darling.Controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.darling.Service.*;
import com.darling.pojo.*;
import com.darling.utils.DataUtil;
import com.darling.vo.MaterialVo;
import com.darling.vo.PutinVo;
import com.darling.vo.RequisitionVo;
import com.darling.vo.StoreVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/mh")
public class AdminController {
    @Autowired
    private KindService kindService;

    @Autowired
    private MaterialService materialService;

    @Autowired
    private PutinService putinService;

    @Autowired
    private StoreService storeService;

    @Autowired
    private RequisitionService requisitionService;

    @Autowired
    private IndexService indexService;

    @RequestMapping(value = "/info.html")
    public String materialInfo() {
        return "/mh/material-info.html";
    }

    /**
     * 获取全部种类
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/info/getOptions.action")
    public String getSelectOptions() {
        Map<String, Object> map = new HashMap<>();
        List<Kind> list = kindService.findAllKind();
        if (list != null) {
            map.put("success", true);
            map.put("data", list);
        } else {
            map.put("success", false);
            Kind kind = new Kind("005", "其它");
            map.put("data", kind);
        }
        System.out.println(map);
        return JSON.toJSONString(map);
    }

    /**
     * 上传设备图片
     *
     * @param file
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/info/uploadImage")
    public String uploadImage(MultipartFile file, HttpServletRequest request) {
        HashMap<String, Object> map = new HashMap<>();
        HashMap<String, Object> data = new HashMap<>();
        try {
            if (file != null) {
                String originalFilename = file.getOriginalFilename();
                Date date = new Date();
                String fileName = date.getTime() + "-" + originalFilename;
                // 类路径
                String classPath = "D:\\IDEA\\code\\sbglxt\\src\\main\\resources\\static";
                // 父路径
                String src = "/upload/";
                File directory = new File(classPath, src);
                if (!directory.exists()) {
                    directory.mkdir();
                }
                // 文件名
                String imagePath = directory.getPath() + "\\" + fileName;
                file.transferTo(new File(imagePath));
                data.put("src", src + fileName);
                map.put("code", 0);
                map.put("msg", "上传成功！");
                map.put("data", data);
                return JSON.toJSONString(map);
            } else {
                map.put("code", -1);
                map.put("msg", "请选择图片！");
                return JSON.toJSONString(map);
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code", -1);
            map.put("msg", "上传失败，请稍后重试！");
            return JSON.toJSONString(map);
        }
    }

    /**
     * 添加设备信息
     *
     * @param mi
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/info/add")
    public String addMaterialInfo(Material mi) {
        HashMap<String, Object> map = new HashMap<>();
        System.out.println(mi);
        boolean result = materialService.addMaterialInfo(mi);
        if (result) {
            map.put("success", true);
            map.put("msg", "添加成功！");
        } else {
            map.put("success", false);
            map.put("msg", "添加失败,请稍后再试！");
        }
        return JSON.toJSONString(map);
    }

    /**
     * 查看设备信息列表
     *
     * @param mv
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/info/list")
    public DataUtil materialInfoList(MaterialVo mv) {
        // 设置分页信息
        PageHelper.startPage(mv.getPage(), mv.getLimit());
        // 查询
        List<Material> list = materialService.findMaterialInfoListByPage(mv);
        // 创建分页对象
        PageInfo<Material> pageInfo = new PageInfo<Material>(list);
        // 按接口要求返回数据
        DataUtil data = new DataUtil(pageInfo.getTotal(), pageInfo.getList());
        return data;
    }

    /**
     * 修改设备信息
     *
     * @param mi
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/info/update")
    public String updateMaterialInfo(Material mi) {
        HashMap<String, Object> map = new HashMap<>();
        boolean result = materialService.updateMaterialInfo(mi);
        if (result) {
            map.put("success", true);
            map.put("msg", "更改成功！");
        } else {
            map.put("success", false);
            map.put("msg", "更改失败！");
        }
        return JSON.toJSONString(map);
    }


    /**
     * 删除设备信息
     *
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/info/delete")
    public String deleteMaterialInfo(HttpServletRequest request) {
        HashMap<String, Object> map = new HashMap<>();
        String params = request.getParameter("params");
        try {
            if (!params.equals("") && params != "") {
                // 获取mid数组
                JSONArray jsonArray = JSONArray.parseArray(params);
                List<String> list = new ArrayList<>();
                for (int i = 0; i < jsonArray.size(); i++) {
                    JSONObject obj = jsonArray.getJSONObject(i);
                    String mid = (String) obj.get("mid");
                    System.out.println(mid);
                    list.add(mid);
                }
                boolean result = materialService.deleteMaterialInfo(list);
                if (result) {
                    map.put("success", true);
                    map.put("msg", "删除成功！");
                } else {
                    map.put("success", false);
                    map.put("msg", "删除失败！");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
            map.put("msg", "删除失败！");
        }
        return JSON.toJSONString(map);
    }


    /**
     * 添加设备类别
     *
     * @param kd
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/kind/add")
    public String addKind(Kind kd) {
        HashMap<String, Object> map = new HashMap<>();
        System.out.println(kd);
        boolean result = kindService.addKind(kd);
        if (result) {
            map.put("success", true);
            map.put("msg", "添加成功！");
        } else {
            map.put("success", false);
            map.put("msg", "添加失败,请稍后再试！");
        }
        return JSON.toJSONString(map);
    }


    @RequestMapping(value = "/putin.html")
    public String putinRecords(){
        return "/mh/putin.html";
    }


    /**
     * 获取全部的设备名称
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/putin/getMname.action")
    public String getMnameOptions() {
        Map<String, Object> map = new HashMap<>();
        List<Material> list = materialService.findAllMname();
        if (list != null) {
            map.put("success", true);
            map.put("data", list);
        } else {
            map.put("success", false);
        }
        return JSON.toJSONString(map);
    }

    /**
     * 设备入库
     * @param pi
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/putin/add")
    public String addPutinInfo(Putin pi, HttpServletRequest request) {
        HashMap<String, Object> map = new HashMap<>();
        // 获取经办人信息
        String uname = (String)request.getSession().getAttribute("uname");
        pi.setPagent(uname);

        // 获取当前日期
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        pi.setPdate(sdf.format(date));

        // 生成时间戳，保证主键的唯一性
        String pno = String.valueOf(date.getTime());
        pi.setPno(pno);

        System.out.println(pi);
        boolean result = putinService.addPutin(pi);
        if (result) {
            map.put("success", true);
            map.put("msg", "入库成功！");
        } else {
            map.put("success", false);
            map.put("msg", "入库失败,请稍后再试！");
        }
        return JSON.toJSONString(map);
    }

    /**
     * 查询设备入库信息
     * @param pv
     * @return
     */
    @RequestMapping(value = "/putin/list")
    @ResponseBody
    public DataUtil findPutinList(PutinVo pv){
        // 设置分页信息
        PageHelper.startPage(pv.getPage(), pv.getLimit());
        // 查询
        List<Putin> list = putinService.findPutinList(pv);
        // 创建分页对象
        PageInfo<Putin> pageInfo = new PageInfo<Putin>(list);
        // 按接口要求返回数据
        DataUtil data = new DataUtil(pageInfo.getTotal(), pageInfo.getList());
        return data;
    }

    @RequestMapping(value = "/store.html")
    public String storeInfo(){
        return "/mh/store.html";
    }

    /**
     * 查询设备的库存信息
     * @param sv
     * @return
     */
    @RequestMapping(value = "/store/list")
    @ResponseBody
    public DataUtil findStoreList(StoreVo sv){
        // 设置分页信息
        PageHelper.startPage(sv.getPage(), sv.getLimit());
        // 查询
        List<Store> list = storeService.findStoreList(sv);
        // 创建分页对象
        PageInfo<Store> pageInfo = new PageInfo<Store>(list);
        // 按接口要求返回数据
        DataUtil data = new DataUtil(pageInfo.getTotal(), pageInfo.getList());
        return data;
    }

    @ResponseBody
    @RequestMapping(value = "/store/delete")
    public String deleteStore(HttpServletRequest request) {
        HashMap<String, Object> map = new HashMap<>();
        String params = request.getParameter("params");
        try {
            if (!params.equals("") && params != "") {
                // 获取mid数组
                JSONArray jsonArray = JSONArray.parseArray(params);
                List<String> list = new ArrayList<>();
                for (int i = 0; i < jsonArray.size(); i++) {
                    JSONObject obj = jsonArray.getJSONObject(i);
                    String mid = (String) obj.get("mid");
                    System.out.println(mid);
                    list.add(mid);
                }
                boolean result = storeService.deleteStore(list);
                if (result) {
                    map.put("success", true);
                    map.put("msg", "删除成功！");
                } else {
                    map.put("success", false);
                    map.put("msg", "删除失败！");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
            map.put("msg", "删除失败！");
        }
        return JSON.toJSONString(map);
    }


    @RequestMapping(value = "/approve.html")
    public String approve(){
        return "/mh/approve.html";
    }


    /**
     * 查询待审核的领用申请
     * @param rv
     * @return
     */
    @RequestMapping(value = "/approve/list")
    @ResponseBody
    public DataUtil approveList(RequisitionVo rv){
        rv.setRstatus("申请中");
        // 设置分页信息
        PageHelper.startPage(rv.getPage(), rv.getLimit());
        // 查询
        List<Requisition> list = requisitionService.findApproveList(rv);
        // 创建分页对象
        PageInfo<Requisition> pageInfo = new PageInfo<>(list);
        // 按接口要求返回数据
        DataUtil data = new DataUtil(pageInfo.getTotal(), pageInfo.getList());
        return data;
    }

    /**
     * 审批申请
     * @param rt
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/approve/approve.action")
    public String doApprove(Requisition rt,HttpServletRequest request){
        // 审核人
        String uname = (String)request.getSession().getAttribute("uname");
        rt.setRverifier(uname);

        System.out.println(rt);
        HashMap<String, Object> map = new HashMap<>();
        boolean result = requisitionService.updateRstatus(rt);
        if (result) {
            map.put("success", true);
            map.put("msg", "审核成功！");
        } else {
            map.put("success", false);
            map.put("msg", "审核失败,请稍后再试！");
        }
        return JSON.toJSONString(map);
    }

    /**
     * 设备发放页面
     * @return
     */
    @RequestMapping(value = "/distribute.html")
    public String distribute(){
        return "/mh/distribute.html";
    }

    /**
     * 查询所有的领用记录
     * @param rv
     * @return
     */
    @RequestMapping(value = "/distribute/list")
    @ResponseBody
    public DataUtil distributeList(RequisitionVo rv){
        // 设置分页信息
        PageHelper.startPage(rv.getPage(), rv.getLimit());
        // 查询
        List<Requisition> list = requisitionService.findAll(rv);
        // 创建分页对象
        PageInfo<Requisition> pageInfo = new PageInfo<>(list);
        // 按接口要求返回数据
        DataUtil data = new DataUtil(pageInfo.getTotal(), pageInfo.getList());
        return data;
    }

    /**
     * 领用登记
     * @param rt
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/distribute/received.action")
    public String received(Requisition rt,HttpServletRequest request){
        // 发放人
        String uname = (String)request.getSession().getAttribute("uname");
        rt.setRagent(uname);

        // 领用日期
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        rt.setRtaketime(sdf.format(date));

        HashMap<String, Object> map = new HashMap<>();
        boolean result = requisitionService.received(rt);
        if (result) {
            map.put("success", true);
            map.put("msg", "登记成功！");
        } else {
            map.put("success", false);
            map.put("msg", "登记失败,库存不足或系统错误,请稍后重试！");
        }
        return JSON.toJSONString(map);
    }

    /**
     * 获取普通员工
     * @return
     */
    @RequestMapping(value = "/distribute/getUname.action")
    @ResponseBody
    public String getUname(){
        Map<String, Object> map = new HashMap<>();
        Integer utype = 0;
        List<User> list = indexService.getUname(utype);
        if (list != null) {
            map.put("success", true);
            map.put("data", list);
        } else {
            map.put("success", false);
        }
        return JSON.toJSONString(map);
    }

    /**
     * 发布领取任务
     * @param rt
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/distribute/give")
    public String give(Requisition rt,HttpServletRequest request){
        // 审核人
        String uname = (String)request.getSession().getAttribute("uname");
        rt.setRverifier(uname);

        // 任务发布日期（即申请日期）
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        rt.setRapplytime(sdf.format(date));

        // 申请类型
        rt.setRtype("直接发放");

        // 时间戳，作为主键
        String rid = String.valueOf(date.getTime());
        rt.setRid(rid);

        // 申请进度
        rt.setRstatus("待领取");

        System.out.println(rt);

        HashMap<String, Object> map = new HashMap<>();
        boolean result = requisitionService.give(rt);
        if (result) {
            map.put("success", true);
            map.put("msg", "发布任务成功！");
        } else {
            map.put("success", false);
            map.put("msg", "发布任务失败,请稍后重试！");
        }
        return JSON.toJSONString(map);
    }
}
