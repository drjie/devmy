package com.dzqc.service.impl;

import com.dzqc.dao.UserMapper;
import com.dzqc.domain.User;
import com.dzqc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void register(User user) {
        userMapper.save(user);
    }

    public boolean checkUserName(String userName){

        //数据库查找是否有相同用户名称
        User user = userMapper.findByUserName(userName);
        if(user != null){
            return false; //false:代表找到了，用户名有重复的
        }
        return true; //用户名没重复
    }

    @Override
    public User login(User user) {
        User currUser = userMapper.login(user);
        return currUser;
    }



}
