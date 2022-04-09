package com.lz.controller;

import com.lz.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {
    @RequestMapping("getUser")
    public void getUser(User user){
        System.out.println(user);
    }
}
