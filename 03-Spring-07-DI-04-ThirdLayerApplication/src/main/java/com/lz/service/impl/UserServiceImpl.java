package com.lz.service.impl;

import com.lz.dao.UserDao;
import com.lz.entity.User;
import com.lz.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao;
    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }
    public void setUserDao(UserDao userDao){
        this.userDao=userDao;
    }
}
