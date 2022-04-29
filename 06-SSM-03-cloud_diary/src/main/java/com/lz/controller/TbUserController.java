package com.lz.controller;

import com.lz.entity.TbUser;
import com.lz.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("user")
public class TbUserController {
    @Autowired
    private TbUserService tbUserService;

    @PostMapping("login")
    public ModelAndView login(@RequestBody TbUser tbUser){
        int id= tbUserService.login(tbUser.getUsername(),tbUser.getPassword());
        ModelAndView mv = new ModelAndView();
        if (id!=-1){
            mv.setViewName("/index/page");
        }else {
            mv.setViewName("/login.jsp");
        }
        return mv;
    }

}
