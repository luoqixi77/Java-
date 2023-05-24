package com.darling.mapper;

import com.darling.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SelectMapper {
    /**
     * 查询单个数据
     */
    User SelectUserById(@Param("id")Integer id);
    /**
     * 查询多个数据
     */
    List<User> selectUser();
    /**
     * 查询用户总数量
     */
    Integer count();
    /**
     * 根据用户id查询
     */
    Map<String,Object> UserToMap(@Param("id") Integer id);
    /**
     * 查询所有用户在一个map集合中
     */
//   List<Map<String,Object>>selectAll();
    @MapKey("id")
   Map<String,Object> selectAll();
}
