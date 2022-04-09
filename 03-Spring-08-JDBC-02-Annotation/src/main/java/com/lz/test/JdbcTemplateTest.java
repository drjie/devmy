package com.lz.test;

import com.lz.Config.JdbcConfig;
import com.lz.dao.impl.JDBCTemplateDaoImpl;
import com.lz.entity.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class JdbcTemplateTest {
    @Test
    public void test(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(JdbcConfig.class);
        JDBCTemplateDaoImpl templateDao = applicationContext.getBean(JDBCTemplateDaoImpl.class);
        User user = templateDao.findById(1);
        System.out.println(user);
    }
}
