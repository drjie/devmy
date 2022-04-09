package com.lz.test;

import com.lz.dao.impl.UserDaoMySQLImpl;
import com.lz.dao.impl.UserDaoOracleImpl;
import com.lz.service.impl.UserServiceImpl;
import org.junit.Test;

public class UserTest {
    @Test
    public void test(){
        UserServiceImpl userService = new UserServiceImpl();
        userService.setUserDao(new UserDaoMySQLImpl());
        userService.useDateBase();
    }
}
