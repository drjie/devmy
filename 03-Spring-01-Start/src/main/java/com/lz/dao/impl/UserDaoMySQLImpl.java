package com.lz.dao.impl;

import com.lz.dao.UserDao;

public class UserDaoMySQLImpl implements UserDao {

    @Override
    public void findAll() {
        System.out.println("使用MySQL数据库");
    }
}
