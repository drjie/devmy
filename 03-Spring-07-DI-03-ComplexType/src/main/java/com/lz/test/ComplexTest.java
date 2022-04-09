package com.lz.test;

import com.lz.entity.ComplexType;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ComplexTest {
    @Test
    public void test(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        ComplexType bean = applicationContext.getBean(ComplexType.class);
        System.out.println(bean);
    }
}
