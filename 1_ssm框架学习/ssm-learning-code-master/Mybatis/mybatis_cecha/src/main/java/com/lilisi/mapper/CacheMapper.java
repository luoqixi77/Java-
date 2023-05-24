package com.lilisi.mapper;

import com.lilisi.pojo.Emp;
import org.apache.ibatis.annotations.Param;

public interface CacheMapper {
    Emp getSelectUserById(@Param("empId") Integer empId);
}
