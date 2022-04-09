package com.lz.demo1._cglib;

import net.sf.cglib.proxy.Enhancer;
import org.junit.Test;

public class Court {
    @Test
    public void test(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Parties.class);
        enhancer.setCallback(new LawOffice());
        Parties proxy = (Parties) enhancer.create();
        proxy.submit();
        proxy.defend();
    }
    @Test
    public void test2(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Parties.class);
        enhancer.setCallback(new LawOffice());
        Parties parties= (Parties) enhancer.create();
        parties.submit();
        parties.defend();
    }
    @Test
    public void test3(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Parties.class);
        enhancer.setCallback(new LawOffice());
        Parties parties= (Parties) enhancer.create();
        parties.submit();
        parties.defend();
    }
}
