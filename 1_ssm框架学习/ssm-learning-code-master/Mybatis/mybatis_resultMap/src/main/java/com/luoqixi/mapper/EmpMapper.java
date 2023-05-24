package com.luoqixi.mapper;

import com.luoqixi.pojo.Dept;
import com.luoqixi.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper {
    Emp selectUser(@Param("empId") Integer empId);
    /**
     * 通过用户id查询用户信息及所对应的部门表
     */
    Emp selectUserAndDeptById(@Param("empId") Integer empId);
    /**
     * 分步查询
     */
    Emp selectUserAndDeptStepOne(@Param("empId") Integer empId);

    List<Emp> selectDeptAndUserStepTwo(@Param("deptId") Integer deptId);
}
