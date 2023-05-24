package com.yaolu.dao.impl;

import com.yaolu.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("测试方法");
    }
}
