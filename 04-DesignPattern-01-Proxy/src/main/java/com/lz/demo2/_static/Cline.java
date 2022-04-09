package com.lz.demo2._static;

import org.junit.Test;

public class Cline {
    @Test
    public void test(){
        GamePlayer gamePlayer = new GamePlayer();
        GamePlay proxy = new GamePlayProxy(gamePlayer);
        proxy.login();
        proxy.killBoss();
        proxy.upgrade();
    }
}
