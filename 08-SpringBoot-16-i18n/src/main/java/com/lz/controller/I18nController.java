package com.lz.controller;

import com.lz.util.MessageUtil;
import com.lz.vo.LoginVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("i18n")
public class I18nController {
    @RequestMapping("get")
    public LoginVO get(){
        LoginVO loginVO = new LoginVO();

        loginVO.setLogin(MessageUtil.get("login"));
        loginVO.setWelcome(MessageUtil.get("welcome"));
        loginVO.setUsername(MessageUtil.get("username"));
        loginVO.setPassword(MessageUtil.get("password"));
        loginVO.setTitle(MessageUtil.get("title"));
        loginVO.setRememberMe(MessageUtil.get("rememberMe"));
        loginVO.setPasswordInput(MessageUtil.get("passwordInput"));
        loginVO.setUsernameInput(MessageUtil.get("usernameInput"));

        return loginVO;
    }
}
