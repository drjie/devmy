package com.dzqc.controller;

import com.dzqc.domain.ShopCar;
import com.dzqc.domain.User;
import com.dzqc.service.ShopCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/shopcar")
public class ShopCarController {

    @Autowired
    private ShopCarService shopCarService;

    @PostMapping("/add")
    @ResponseBody
    public String add(int dishId, HttpSession session){
        shopCarService.add(dishId,session);
        return "0";

    }

    @GetMapping("/list")
    public String list(HttpSession session, Model model){

        //获取当前登录者id
        int userId = ((User)session.getAttribute("currUser")).getId();
        //查询购物车信息
        Map<String,Object> result = shopCarService.findByUserId(userId);
        model.addAttribute("result",result);
        return "shopcarlist";
    }


    @GetMapping("/remove")
    public String remove(int dishId,HttpSession session){
        int userId = ((User)session.getAttribute("currUser")).getId();
        //从购物车中移除
        shopCarService.remove(dishId,userId);

        return "redirect:/shopcar/list";
    }

}
