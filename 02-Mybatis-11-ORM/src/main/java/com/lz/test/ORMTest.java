package com.lz.test;

import com.lz.dao.AccountDao;
import com.lz.entity.Account;
import com.lz.entity.TAccount;
import com.lz.util.MyBatisUtil;
import org.junit.Test;

import java.util.List;

public class ORMTest {
    @Test
    public void testCamelCase(){
        AccountDao accountDao = MyBatisUtil.getMapper(AccountDao.class);
        List<TAccount> accounts = accountDao.findByCamelCase();
        for (TAccount account : accounts) {
            System.out.println(account);
        }
        MyBatisUtil.commit();
    }
    @Test
    public void testFindById(){
        AccountDao accountDao = MyBatisUtil.getMapper(AccountDao.class);
        Account account = accountDao.findById(1);
        System.out.println(account);
        MyBatisUtil.commit();
    }
    @Test
    public void testFindAll(){
        AccountDao accountDao = MyBatisUtil.getMapper(AccountDao.class);
        List<Account> accounts = accountDao.findAll();
        for (Account account : accounts) {
            System.out.println(account);
        }
        MyBatisUtil.commit();
    }
}
