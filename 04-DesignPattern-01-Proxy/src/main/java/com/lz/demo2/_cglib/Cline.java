package com.lz.demo2._cglib;

import net.sf.cglib.proxy.Enhancer;
import org.junit.Test;

public class Cline {
    @Test
    public void test(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(GamePlayer.class);
        enhancer.setCallback(new GameOffice());
        GamePlayer gamePlayer = (GamePlayer) enhancer.create();
        gamePlayer.login();
        gamePlayer.killBoss();
        gamePlayer.upgrade();
    }
    @Test
    public void test2(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(GamePlayer.class);
        enhancer.setCallback(new GameOffice());
        GamePlayer gamePlayer = (GamePlayer) enhancer.create();
        gamePlayer.login();
        gamePlayer.killBoss();
        gamePlayer.upgrade();
    }
    @Test
    public void test3(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(GamePlayer.class);
        enhancer.setCallback(new GameOffice());
        GamePlayer gamePlayer= (GamePlayer) enhancer.create();
        gamePlayer.login();
        gamePlayer.killBoss();
        gamePlayer.upgrade();
    }
}
