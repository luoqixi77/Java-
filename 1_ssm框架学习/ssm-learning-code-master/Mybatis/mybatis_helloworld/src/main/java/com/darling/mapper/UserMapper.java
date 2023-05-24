package com.darling.mapper;

import com.darling.pojo.User;

import java.util.List;

public interface UserMapper {
    /**
     * 添加用户信息
     * @return
     */
    int insertUser();

    /**
     * 修改用户信息
     */
    void updateUser();

    /**
     * 删除用户信息
     */
    void deleteUser();

    /**
     * 根据id查找用户信息
     */
    User selectUserById();
    /**
     * 查询所有用户信息
     */
    List<User> selectUserAll();
}
