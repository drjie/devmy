package com.lz.test;

import com.lz.dao.impl.UserDaoImpl;
import org.junit.Test;

public class UserTest {
    @Test
    public void test(){
        UserDaoImpl userDao = new UserDaoImpl();
        userDao.findAll();
    }
}
