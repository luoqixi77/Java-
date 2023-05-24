package com.luoluoli.mapper;

import com.luoluoli.Utils.SqlSessionUtils;
import com.luoluoli.pojo.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestDynamicSQL {
    @Test
   public void testGetEmpByUser(){
        DynamicSQLMapper mapper = SqlSessionUtils.getSqlSession().getMapper(DynamicSQLMapper.class);
        Employee employee = new Employee(null, "yinhe", 17, "女");
        List<Employee> list = mapper.getEmpByUser(employee);
        System.out.println(list);
    }
    @Test
    public void testGetEmpByChoose(){
        DynamicSQLMapper mapper = SqlSessionUtils.getSqlSession().getMapper(DynamicSQLMapper.class);
        Employee employee = new Employee(null, "yinhe", 17, "女");
        List<Employee> list = mapper.getEmpByChoose(employee);
        System.out.println(list);
    }
    @Test
    public void testInsertUser(){
        DynamicSQLMapper mapper = SqlSessionUtils.getSqlSession().getMapper(DynamicSQLMapper.class);
        Employee employee1 = new Employee(null, "女帝", 22, "女");
        Employee employee2 = new Employee(null, "梦", 18, "女");
        Employee employee3 = new Employee(null, "琉璃", 16, "女");
        List<Employee> list = Arrays.asList(employee1, employee2, employee3);
        mapper.insertUser(list);
    }
    @Test
    public void testDeleteUser(){
        DynamicSQLMapper mapper = SqlSessionUtils.getSqlSession().getMapper(DynamicSQLMapper.class);
       Integer[] del=new Integer[]{8,9,10,11,12,13,14,15,16};
       mapper.deleteUser(del);
    }
}
