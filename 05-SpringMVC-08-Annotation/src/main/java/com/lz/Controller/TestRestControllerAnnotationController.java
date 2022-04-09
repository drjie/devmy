package com.lz.Controller;

import com.lz.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("controller")
public class TestRestControllerAnnotationController {
    @RequestMapping("user")
    public User testUser(){
        return new User("迪丽热巴",22,"女",new Date(),"美女美女");
    }
}
