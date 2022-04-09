package com.lz.demo2._cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class GameOffice implements MethodInterceptor {
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        if (method.getName().equals("login")){
            System.out.println("欢迎大神玩家君莫笑进入游戏");
        }
        Object o = proxy.invokeSuper(obj, args);
        if(method.getName().equals("killBoss")){
            System.out.println("玩家君莫笑打破刷怪记录");
        }
        return o;
    }
}
