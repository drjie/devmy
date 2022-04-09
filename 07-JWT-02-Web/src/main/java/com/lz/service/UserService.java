package com.lz.service;

import com.lz.vo.UserVO;

public interface UserService {
    UserVO login(String username, String password);
}
