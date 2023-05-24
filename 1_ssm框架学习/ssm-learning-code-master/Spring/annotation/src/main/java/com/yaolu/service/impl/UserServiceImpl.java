package com.yaolu.service.impl;

import com.yaolu.dao.UserDao;
import com.yaolu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    @Qualifier("userDaoImpl")
    private UserDao userDao;

    @Override
    public void save() {
        userDao.save();
    }
}
