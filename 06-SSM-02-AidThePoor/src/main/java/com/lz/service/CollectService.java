package com.lz.service;

import com.lz.entity.Collection;
import com.lz.vo.ResultVo;

public interface CollectService {

    ResultVo getList(Integer pageNum, Integer pageSize, Long id);

    ResultVo add(Collection collection);

    ResultVo update(Collection collection);

    ResultVo delete(Long id);

    ResultVo search(String val);

}
