package com.lz.demo1._static;

public class Parties implements Lawsuit{
    @Override
    public void submit() {
        System.out.println("江南皮革厂倒闭了，老板带着小姨子跑了");
    }

    @Override
    public void defend() {
        System.out.println("还我血汗钱");
    }
}
