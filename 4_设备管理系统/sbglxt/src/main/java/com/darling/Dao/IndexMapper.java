package com.darling.Dao;


import com.darling.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IndexMapper {
    /**
     * 根据uid查找用户
     *
     * @param uid
     * @return
     */
    public User findUserByUid(String uid);

    /**
     * 查找指定类型的用户
     * @param utype
     * @return
     */
    public List<User> findUserByUtype(Integer utype);
}
