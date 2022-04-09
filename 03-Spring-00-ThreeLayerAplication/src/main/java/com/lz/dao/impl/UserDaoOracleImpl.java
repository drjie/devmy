package com.lz.dao.impl;

import com.lz.dao.UserDao;

public class UserDaoOracleImpl implements UserDao {
    @Override
    public void useDateBase() {
        System.out.println("连接Oracle数据库");
    }
}
