package com.lz;

import com.lz.entity.Car;
import com.lz.entity.GirlFriend;
import com.lz.entity.Son;
import com.lz.entity.Wife;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

        if (context.containsBean("girlFriend")){
            GirlFriend girlFriend = context.getBean(GirlFriend.class);
            System.out.printf("有对象："+girlFriend);
        }else {
            System.out.printf("没有女朋友");
        }

        if (context.containsBean("son")){
            Son son = context.getBean(Son.class);
            System.out.printf("有孩子："+son);
        }else {
            System.out.printf("没有孩子");
        }

        if (context.containsBean("wife")){
            Wife wife = context.getBean(Wife.class);
            System.out.printf("有老婆"+wife);
        }else {
            System.out.printf("没有老婆");
        }

//        Car car = context.getBean("car2", Car.class);
//        System.out.printf(car);

    }

}
