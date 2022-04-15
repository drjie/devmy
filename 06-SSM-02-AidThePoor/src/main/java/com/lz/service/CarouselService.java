package com.lz.service;

import com.lz.entity.Carousel;
import com.lz.vo.ResultVo;

public interface CarouselService {

    ResultVo getList(Integer pageNum, Integer pageSize, Integer id);

    ResultVo add(Carousel carousel);

    ResultVo update(Carousel carousel);

    ResultVo delete(Integer id);

    ResultVo changeStatus(Integer id);

    ResultVo search(String val);
}
