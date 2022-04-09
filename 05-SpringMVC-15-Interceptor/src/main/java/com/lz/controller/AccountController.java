package com.lz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("account")
public class AccountController {
    @RequestMapping("getFoods")
    public ModelAndView getFoods(ModelAndView mv){
        //模拟连接数据库

        System.out.println("连接数据库操作");

        List<String> foods = new ArrayList<>();

        foods.add("麻辣烫");
        foods.add("麻辣香锅");
        foods.add("百媚鸡");
        mv.addObject("foods",foods);

        mv.setViewName("/account/getFoods");

        return mv;
    }
}
