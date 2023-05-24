package com.darling.mapper;

import com.darling.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SpecialSql {
    List<User> SpecialSelect(@Param("mohu") String mohu);

    /**
     * 批量删除
     */
    void deletes(@Param("ids") String ids);
    /**
     * 动态设置表名
     */
    List<User> selectTableName(@Param("tablename") String tablename);
    /**
     * 获取自增的主键
     */
    void insertUser(User user);
}


