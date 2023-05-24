package com.ssm.darling.controller;


import com.ssm.darling.pojo.Employee;
import com.ssm.darling.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/employee",method = RequestMethod.GET)
    public String getAll(Model model){
        List<Employee> list=employeeService.getAllUser();
        model.addAttribute("list",list);
        return "Employee_list";
    }
}
