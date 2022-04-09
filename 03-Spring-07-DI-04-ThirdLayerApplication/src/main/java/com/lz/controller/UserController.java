package com.lz.controller;

import com.lz.entity.User;
import com.lz.service.UserService;

import java.util.List;

public class UserController {
    private UserService userService;
    public List<User> findAll(){
        return userService.findAll();
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
