package com.dzqc.dao;

import com.dzqc.domain.User;

public interface UserMapper {

    /**
     * 保存用户信息
     * @param user
     */
    void save(User user);

    /**
     * 通过用户名查找用户
     * @param userName
     * @return
     */
    User findByUserName(String userName);

    /**
     * 登录
     * @param user
     * @return
     */
    User login(User user);

    /**
     * 通过id查询用户信息
     * @param userId
     * @return
     */
    User findById(int userId);
}
