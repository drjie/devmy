package com.lz.controller;

import com.lz.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("index")
public class indexController {
    @Autowired
    private IndexService indexService;

    @PostMapping("page")
    public ModelAndView page(ModelAndView mv){
        indexService.page();

        return mv;
    }

}
