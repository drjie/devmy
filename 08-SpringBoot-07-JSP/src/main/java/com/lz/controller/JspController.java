package com.lz.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class JspController {
    @RequestMapping("jsp")
    public String getJsp(Model model){
        // 添加model属性值
        model.addAttribute("username", "易烊千玺");

        // 跳转页面
        return "index";
    }

}
