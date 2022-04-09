package com.lz.test;

import com.lz.controller.UserController;
import com.lz.entity.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class UserTest {
    @Test
    public void testIoc(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.lz");
        UserController userController = applicationContext.getBean(UserController.class);
        System.out.println(userController);
    }
    @Test
    public void testDI(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserController userController = applicationContext.getBean(UserController.class);
        List<User> userList = userController.findAll();

        System.out.println(userList);
    }
    @Test
    public void testValue(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = applicationContext.getBean(User.class);
        applicationContext.close();
    }
}
