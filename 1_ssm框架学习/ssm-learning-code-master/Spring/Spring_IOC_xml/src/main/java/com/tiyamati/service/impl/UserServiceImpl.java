package com.tiyamati.service.impl;

import com.tiyamati.dao.UserDao;
import com.tiyamati.service.UserService;

public class UserServiceImpl implements UserService {
private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }


    public void save() {
        userDao.testsave();
    }
}
