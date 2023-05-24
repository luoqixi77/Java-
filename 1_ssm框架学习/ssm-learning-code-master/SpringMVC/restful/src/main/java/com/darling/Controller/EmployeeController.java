package com.darling.Controller;

import com.darling.Dao.EmployeeDao;
import com.darling.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.context.Context;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping("/employee")
    public String getAll(Model model){
        //获取所有员工的信息
        Collection<Employee> emp = employeeDao.getAll();
        //将所有的员工信息在请求域中共享
        model.addAttribute("emp",emp);
        //跳转到列表页面
        return "employee_list";
    }

    @RequestMapping(value = "/add/employee",method = RequestMethod.POST)
    public String addUser(Employee employee){
        employeeDao.save(employee);
        return "redirect:/employee";
    }

    @RequestMapping(value = "/employee/{id}",method = RequestMethod.GET)
    public String toupdate(@PathVariable("id") Integer id,Model model){

        //通过id获取employee数据
        Employee employee = employeeDao.get(id);
        //视图
        model.addAttribute("employee",employee);
        //转发
        return "employee_update";
    }

    @RequestMapping(value = "/employee",method = RequestMethod.PUT)
    public String update(Employee employee){
        employeeDao.save(employee);
        return "redirect:/employee";
    }

    @RequestMapping(value = "/employee/{id}",method = RequestMethod.DELETE)
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/employee";
    }
}
