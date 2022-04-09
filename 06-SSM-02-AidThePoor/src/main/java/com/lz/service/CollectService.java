package com.lz.service;

import com.lz.entity.Collection;
import com.lz.vo.ResultVo;

import java.util.List;
import java.util.Map;

public interface CollectService {

    ResultVo getList(Integer pageNum, Integer pageSize, Long id);

    ResultVo add(Collection collection);

    ResultVo update(Collection collection);

    ResultVo delete(Long id);
}
