package com.ssm.darling.service.impl;

import com.ssm.darling.mapper.EmployeeMapper;
import com.ssm.darling.pojo.Employee;
import com.ssm.darling.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> getAllUser() {
        return employeeMapper.getAllUser();
    }
}
