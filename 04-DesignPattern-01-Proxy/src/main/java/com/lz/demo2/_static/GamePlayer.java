package com.lz.demo2._static;

public class GamePlayer implements GamePlay{
    @Override
    public void login() {
        System.out.println("使用 君莫问 登陆游戏ing");
    }

    @Override
    public void killBoss() {
        System.out.println("君莫问 一枪9999");
    }

    @Override
    public void upgrade() {
        System.out.println("恭喜 君莫问 升了120级");
    }
}
