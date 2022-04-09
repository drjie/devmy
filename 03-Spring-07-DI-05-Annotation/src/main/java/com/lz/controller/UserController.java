package com.lz.controller;

import com.lz.entity.User;
import com.lz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import java.util.List;
@Controller
public class UserController {
    //自动转配，会自动从容器中找到对应的数据类型注入
    @Autowired
    private UserService userService;
    public List<User> findAll(){
        return userService.findAll();
    }
}
