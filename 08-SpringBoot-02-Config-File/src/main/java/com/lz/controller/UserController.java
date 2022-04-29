package com.lz.controller;

import com.lz.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @RequestMapping("hello")
    public String hello() {
        return "猪脚饭，鸡公煲，凉皮，泡面加火腿肠加蛋";
    }
}
