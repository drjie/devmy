package com.lz.test;

import com.lz.entity.Student;
import com.lz.entity.Teacher;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetTest {
    @Test
    public void test(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = applicationContext.getBean(Student.class);
        System.out.println(student);
        Teacher teacher = applicationContext.getBean(Teacher.class);
        System.out.println(teacher);
    }
}
