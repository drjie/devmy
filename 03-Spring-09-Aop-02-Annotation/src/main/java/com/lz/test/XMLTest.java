package com.lz.test;

import com.lz.config.AopConfig;
import com.lz.service.UserService;
import com.lz.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XMLTest {
    @Test
    public void testAnnotation(){
       ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AopConfig.class);
        UserService userService = applicationContext.getBean(UserServiceImpl.class);
        userService.add();
    }
    @Test
    public void test(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = applicationContext.getBean(UserService.class);
        userService.add();
        System.out.println("-------------");
        userService.update();
    }
}
