package com.lz.service;

import com.lz.entity.TbUser;
import com.lz.vo.ResultVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface TbUserService {

    ResultVO login(String username, String password);

    ResultVO userCenter();

    TbUser update(MultipartFile img, TbUser tbUser, String type);

    int checkNick(TbUser tbUser);

}
