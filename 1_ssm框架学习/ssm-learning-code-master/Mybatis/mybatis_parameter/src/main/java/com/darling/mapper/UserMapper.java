package com.darling.mapper;

import com.darling.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface UserMapper {

    /**
    * 根据用户名查询用户信息
    */
   User selectUserByUsername(String username);
    /**
     * 用户验证登录
     */
    User loginin(String username,String password);
    /**
     * 用户验证登录（Map集合）
     */
    User loginMap(Map<String ,Object>map);
    /**
     * 添加用户
     */
    void insert(User user);
    /**
     * 测试登录@Param
     */
    User loginParam(@Param("username") String username, @Param("password") String password);
}
