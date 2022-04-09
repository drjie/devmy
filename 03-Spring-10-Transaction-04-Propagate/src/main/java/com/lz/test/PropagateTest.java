package com.lz.test;

import com.lz.config.TxConfig;
import com.lz.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PropagateTest {
    @Test
    public void test(){
       ApplicationContext applicationContext = new AnnotationConfigApplicationContext(TxConfig.class);

        AccountService accountService = applicationContext.getBean(AccountService.class);

        accountService.addAccount("胡图图","翻斗花园");
    }
}
