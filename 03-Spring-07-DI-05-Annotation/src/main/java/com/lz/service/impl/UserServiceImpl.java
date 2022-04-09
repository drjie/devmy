package com.lz.service.impl;

import com.lz.dao.UserDao;
import com.lz.entity.User;
import com.lz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    //根据数据类型注入
    @Autowired
    //在数据类型相同的情况下再根据id进行注入 且qualifier要和autowired配合使用
    @Qualifier("userDaoMySQLImpl")
    //即根据类型又使用id
    @Resource(name = "userDaoMySQLImpl")
    private UserDao userDao;
    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }
}
