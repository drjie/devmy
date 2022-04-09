package com.lz.demo1._jdk;

import org.junit.Test;

import java.lang.reflect.Proxy;

public class Court {
    @Test
    public void test(){
        //原告
        Parties parties = new Parties();
        //获取律师事务所
        LawOffice lawOffice = new LawOffice(parties);
        //获取代理
        Lawsuit proxy = (Lawsuit) Proxy.newProxyInstance(parties.getClass().getClassLoader(), parties.getClass().getInterfaces(), lawOffice);
        proxy.submit();
        proxy.defend();
    }
    @Test
    public void test2(){
        Parties parties = new Parties();
        LawOffice office = new LawOffice(parties);
        Lawsuit proxy= (Lawsuit) Proxy.newProxyInstance(parties.getClass().getClassLoader(), parties.getClass().getInterfaces(), office);
        proxy.submit();
        proxy.defend();
    }
    @Test
    public void test3(){
        Parties parties = new Parties();
        LawOffice office = new LawOffice(parties);
        Lawsuit proxy= (Lawsuit) Proxy.newProxyInstance(parties.getClass().getClassLoader(), parties.getClass().getInterfaces(),office);
        proxy.submit();
        proxy.defend();
    }
}
