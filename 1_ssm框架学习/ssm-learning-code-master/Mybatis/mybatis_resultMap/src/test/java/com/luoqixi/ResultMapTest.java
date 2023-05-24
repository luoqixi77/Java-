package com.luoqixi;

import com.luoqixi.Utils.SqlSessionUtils;
import com.luoqixi.mapper.DeptMapper;
import com.luoqixi.mapper.EmpMapper;
import com.luoqixi.pojo.Dept;
import com.luoqixi.pojo.Emp;
import org.junit.Test;

public class ResultMapTest {
    @Test
    public void testSelectUserById(){
        EmpMapper mapper = SqlSessionUtils.getSqlSession().getMapper(EmpMapper.class);
        Emp emp = mapper.selectUser(1);
        System.out.println(emp);
    }
    @Test
    public void testSelectUserAndDeptById(){
        EmpMapper mapper = SqlSessionUtils.getSqlSession().getMapper(EmpMapper.class);
        Emp emp = mapper.selectUserAndDeptById(1);
        System.out.println(emp);
    }
    @Test
    public void testSelectUserAndDeptStepById(){
        EmpMapper mapper = SqlSessionUtils.getSqlSession().getMapper(EmpMapper.class);
        Emp emp = mapper.selectUserAndDeptStepOne(3);
        System.out.println(emp.getEmpId());
    }
    @Test
    public void testSelectDeptAndUserById(){
        DeptMapper mapper = SqlSessionUtils.getSqlSession().getMapper(DeptMapper.class);
        Dept dept = mapper.selectDeptAndUser(1);
        System.out.println(dept);
    }
    @Test
    public void testSelectDeptAndUserStep(){
        DeptMapper mapper = SqlSessionUtils.getSqlSession().getMapper(DeptMapper.class);
        Dept dept = mapper.selectDeptAndUserStepOne(1);
        System.out.println(dept);
    }
}
