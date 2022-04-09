package com.lz.demo2._static;

public class GamePlayProxy implements GamePlay{
    private final GamePlay gamePlayer;

    public GamePlayProxy(GamePlay gamePlayer) {
        this.gamePlayer = gamePlayer;
    }

    @Override
    public void login() {
        this.verity();
        gamePlayer.login();
    }

    @Override
    public void killBoss() {
        gamePlayer.killBoss();
    }

    @Override
    public void upgrade() {
        gamePlayer.upgrade();
        this.addMoney();
    }
    private void verity(){
        System.out.println("请输入手机验证码");
    }
    private void addMoney(){
        System.out.println("掉了一堆金币 和一把屠龙宝刀");
    }
}
