package com.lz.demo2._jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class GameOffice implements InvocationHandler {
    private final Object target;

    public GameOffice(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("login")){
            System.out.println("扫码登录");
        }
        Object invoke = method.invoke(target, args);
        if (method.getName().equals("killBoss")){
            System.out.println("单子打炸了 跑路了");
        }
        return invoke;
    }
}
