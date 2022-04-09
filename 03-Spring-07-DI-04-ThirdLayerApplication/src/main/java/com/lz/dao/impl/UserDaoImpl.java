package com.lz.dao.impl;

import com.lz.dao.UserDao;
import com.lz.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public List<User> findAll() {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User(1,"迪丽热巴","123456"));
        users.add(new User(2,"古力娜扎","123456"));
        users.add(new User(3,"鞠婧祎","123456"));
        return users;
    }
}
