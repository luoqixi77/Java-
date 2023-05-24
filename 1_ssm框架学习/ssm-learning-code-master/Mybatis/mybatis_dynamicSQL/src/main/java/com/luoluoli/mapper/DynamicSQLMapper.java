package com.luoluoli.mapper;

import com.luoluoli.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DynamicSQLMapper {
    /**
     * 多条件查询
     * @param employee
     * @return
     */
    List<Employee> getEmpByUser(Employee employee);

    List<Employee> getEmpByChoose(Employee employee);

    void insertUser(@Param("employees") List<Employee> employees);

    void deleteUser(@Param("empId") Integer[] empId);
}
