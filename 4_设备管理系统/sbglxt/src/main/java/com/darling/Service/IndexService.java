package com.darling.Service;

import com.darling.pojo.User;

import java.util.List;

public interface IndexService {
    /**
     * 查找用户
     *
     * @param uid
     * @param pwd
     * @return
     */
    public User findUser(String uid, String pwd);

    /**
     * 获取指定类型的用户
     * @param utype
     * @return
     */
    public List<User> getUname(Integer utype);
}
