package com.lz.service.impl;

import com.lz.dao.UserDao;
import com.lz.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao;
    @Override
    public void useDateBase() {
        userDao.useDateBase();
    }

    @Override
    public void setUserDao(UserDao userDao) {
        this.userDao=userDao;
    }
}
