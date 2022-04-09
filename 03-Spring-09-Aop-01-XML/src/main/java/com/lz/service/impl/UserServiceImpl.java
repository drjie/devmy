package com.lz.service.impl;

import com.lz.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public void add() {
        System.out.println("添加一个学生");
    }

    @Override
    public void update() {
        System.out.println("修改学生信息");
    }
}
