package com.lz.dao.impl;

import com.lz.dao.UserDao;
import com.lz.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserDaoMySQLImpl implements UserDao {
    @Override
    public List<User> findAll() {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User(1,"杨幂","555555"));
        users.add(new User(2,"范冰冰","666666"));
        users.add(new User(3,"刘亦菲","888888"));
        return users;
    }
}
