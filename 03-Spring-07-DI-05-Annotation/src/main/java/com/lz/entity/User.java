package com.lz.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Data
@AllArgsConstructor
//把当前类的对象放进容器中
@Component
@Scope(value = "singleton")
public class User {
    @Value("1")
    private Integer id;
    @Value("迪丽热巴")
    private String username;
    @Value("000000")
    private String password;
    //和init-method相同会在对象创建后执行此方法

    public User() {
        System.out.println("无参构造");
    }

    @PostConstruct
    public void eat(){
        System.out.println("中午吃屎");
    }
    //在容器销毁之前和destroy-method 相同
    @PreDestroy
    public void sleep(){
        System.out.println("吃饱睡觉");
    }
}
