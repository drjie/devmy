package com.lz.test;

import com.lz.dao.impl.JDBCTemplateDaoImpl;
import com.lz.entity.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class JdbcTemplateTest {
    @Test
    public void testDelete(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        JDBCTemplateDaoImpl jdbcTemplateDao = applicationContext.getBean(JDBCTemplateDaoImpl.class);
        int delete = jdbcTemplateDao.delete(4);
    }
    @Test
    public void testUpdate(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        JDBCTemplateDaoImpl jdbcTemplateDao = applicationContext.getBean(JDBCTemplateDaoImpl.class);
        int update = jdbcTemplateDao.update(new User(4, null, "666666"));

    }
    @Test
    public void testInsert(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        JDBCTemplateDaoImpl jdbcTemplateDao = applicationContext.getBean(JDBCTemplateDaoImpl.class);
        int insert = jdbcTemplateDao.insert(new User(null, "老坛酸菜", "123465"));
        System.out.println(insert);
    }
    @Test
    public void testFindCount(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        JDBCTemplateDaoImpl jdbcTemplateDao = applicationContext.getBean(JDBCTemplateDaoImpl.class);
        int count = jdbcTemplateDao.findCount();
        System.out.println(count);
    }
    @Test
    public void testFindAll(){
       ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        JDBCTemplateDaoImpl jdbcTemplateDao = applicationContext.getBean(JDBCTemplateDaoImpl.class);
        List<User> list = jdbcTemplateDao.findAll();
        for (User user : list) {
            System.out.println(user);
        }
    }
    @Test
    public void testFindById(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        JDBCTemplateDaoImpl jdbcTemplateDao = applicationContext.getBean(JDBCTemplateDaoImpl.class);
        User user = jdbcTemplateDao.findById(1);
        System.out.println(user);
    }
}
