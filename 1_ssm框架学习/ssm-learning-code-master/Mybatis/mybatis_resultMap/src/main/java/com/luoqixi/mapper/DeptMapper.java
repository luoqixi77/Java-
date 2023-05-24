package com.luoqixi.mapper;

import com.luoqixi.pojo.Dept;
import org.apache.ibatis.annotations.Param;

public interface DeptMapper {
    Dept selectUserAndDeptStepTwo(@Param("deptId") Integer deptId);
    Dept selectDeptAndUser(@Param("deptId") Integer deptId);
    /**
     * 分步查询
     */
    Dept selectDeptAndUserStepOne(@Param("deptId")Integer deptId);
}
