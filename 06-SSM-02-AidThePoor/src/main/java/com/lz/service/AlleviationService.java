package com.lz.service;

import com.lz.entity.Alleviation;
import com.lz.vo.ResultVo;

import java.util.Date;
import java.util.Map;

public interface AlleviationService {

    ResultVo getList(Integer pageNum, Integer pageSize, Long id);

    ResultVo add(Alleviation alleviation);

    ResultVo update(Alleviation alleviation);

    ResultVo delete(Long id);

    ResultVo click(Long id, Date lastClickTime);

}
