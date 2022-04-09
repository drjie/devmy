package com.lz.demo2._jdk;

import org.junit.Test;

import java.lang.reflect.Proxy;

public class Cline {
    @Test
    public void test(){
        GamePlayer player = new GamePlayer();
        GameOffice office = new GameOffice(player);
        GamePlay proxy = (GamePlay) Proxy.newProxyInstance(player.getClass().getClassLoader(), player.getClass().getInterfaces(), office);
        proxy.login();
        proxy.killBoss();
        proxy.upgrade();
    }
    @Test
    public void test2(){
        GamePlayer player = new GamePlayer();
        GameOffice office = new GameOffice(player);
        GamePlay proxy = (GamePlay) Proxy.newProxyInstance(player.getClass().getClassLoader(), player.getClass().getInterfaces(), office);
        proxy.login();
        proxy.killBoss();
        proxy.upgrade();
    }
    @Test
    public void test3(){
        GamePlayer player = new GamePlayer();
        GameOffice office = new GameOffice(player);
       GamePlay proxy = (GamePlay) Proxy.newProxyInstance(player.getClass().getClassLoader(), player.getClass().getInterfaces(), office);
       proxy.login();
       proxy.killBoss();
       proxy.upgrade();
    }
}
