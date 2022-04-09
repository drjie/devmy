package com.lz.dao;

import com.lz.entity.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();
}
