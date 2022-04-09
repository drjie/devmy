package com.lz.test;

import com.lz.entity.Student;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.plaf.synth.SynthUI;

public class ScopeTest {
    @Test
    public void testScope(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student1 = applicationContext.getBean("student", Student.class);
        Student student2 = applicationContext.getBean("student", Student.class);

        System.out.println(student1);
        System.out.println(student2);
        System.out.println(student1==student2);
    }
}
