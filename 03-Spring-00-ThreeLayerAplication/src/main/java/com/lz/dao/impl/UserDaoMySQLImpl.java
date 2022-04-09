package com.lz.dao.impl;

import com.lz.dao.UserDao;

public class UserDaoMySQLImpl implements UserDao {
    @Override
    public void useDateBase() {
        System.out.println("连接MySQL数据库");
    }
}
