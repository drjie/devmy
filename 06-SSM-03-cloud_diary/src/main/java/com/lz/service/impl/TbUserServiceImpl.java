package com.lz.service.impl;

import com.lz.dao.TbUserMapper;
import com.lz.entity.TbUser;
import com.lz.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TbUserServiceImpl implements TbUserService {
    @Autowired
    private TbUserMapper tbUserMapper;

    @Override
    public int login(String username, String password) {
        TbUser tbUser=tbUserMapper.selectUser(username);

        if (tbUser!=null&&tbUser.getPassword().equals(password)){
            return tbUser.getId();
        }

        return -1;
    }
}
