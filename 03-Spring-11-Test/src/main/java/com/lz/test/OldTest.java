package com.lz.test;

import com.lz.entity.Student;
import com.lz.entity.Teacher;
import org.junit.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.logging.SocketHandler;

public class OldTest {
    static ApplicationContext applicationContext=null;
    @BeforeClass
    public static void before(){
        System.out.println("获取容器");
        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    }
    @AfterClass
    public static void after(){
        ((ClassPathXmlApplicationContext)applicationContext).close();
        System.out.println("容器已关闭");
    }

    @Test
    public void test(){

        Student student = applicationContext.getBean(Student.class);
        System.out.println(student);
        Teacher teacher = applicationContext.getBean(Teacher.class);
        System.out.println(teacher);
    }
    @Test
    public void test2(){

        Student student = applicationContext.getBean(Student.class);
        System.out.println(student);
        Teacher teacher = applicationContext.getBean(Teacher.class);
        System.out.println(teacher);
    }
    @Test
    public void test3(){

        Student student = applicationContext.getBean(Student.class);
        System.out.println(student);
        Teacher teacher = applicationContext.getBean(Teacher.class);
        System.out.println(teacher);
    }
}
