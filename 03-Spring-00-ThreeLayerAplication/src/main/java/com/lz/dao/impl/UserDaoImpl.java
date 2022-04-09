package com.lz.dao.impl;

import com.lz.dao.UserDao;

public class UserDaoImpl implements UserDao {
    @Override
    public void useDateBase() {
        System.out.println("连接数据库");
    }
}
