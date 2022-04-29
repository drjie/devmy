package com.dzqc.service;

import com.dzqc.domain.User;

public interface UserService {

    /**
     * 注册接口
     * @param user
     */
    void register(User user);

    /**
     * 校验用户名是否相同
     * @param userName
     * @return
     */
    boolean checkUserName(String userName);

    /**
     * 登录
     * @param user
     * @return
     */
    User login(User user);


}
