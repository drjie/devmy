package com.dzqc.service.impl;

import com.dzqc.dao.NewsMapper;
import com.dzqc.domain.News;
import com.dzqc.service.NewsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsMapper newsMapper;

    @Override
    public PageInfo<News> findByPage(Integer pageNo) {
        PageHelper.startPage(pageNo,15);
        List<News> newsList = newsMapper.findAll();

        PageInfo<News> page = new PageInfo<>(newsList);

        return page;
    }
}
