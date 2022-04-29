package com.dzqc.controller;

import com.dzqc.domain.News;
import com.dzqc.service.NewsService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @GetMapping("/list/{pageNo}")
    public String list(@PathVariable Integer pageNo, Model model){

        PageInfo<News> pageInfo =  newsService.findByPage(pageNo);
        model.addAttribute("page",pageInfo);
        return "admin";

    }

}
