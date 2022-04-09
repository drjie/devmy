package com.lz.service;

import com.lz.entity.User;
import com.lz.vo.ResultVo;

import java.util.List;
import java.util.Map;

public interface UserService {

    ResultVo getList(Integer pageNum, Integer pageSize, Long id);

    ResultVo add(User user);

    ResultVo update(User user);

    ResultVo delete(Long id);
}
