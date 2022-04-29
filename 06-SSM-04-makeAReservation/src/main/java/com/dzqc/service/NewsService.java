package com.dzqc.service;

import com.dzqc.domain.News;
import com.github.pagehelper.PageInfo;

public interface NewsService {

    /**
     * 按页查询新闻列表
     * @param pageNo
     * @return
     */
    PageInfo<News> findByPage(Integer pageNo);


}
