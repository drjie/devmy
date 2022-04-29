package com.dzqc.controller;

import com.dzqc.domain.Dishes;
import com.dzqc.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/dish")
public class DishController {

    @Autowired
    private DishService dishService;

    /**
     * 查询所有菜品
     * @return
     */
    @GetMapping("/list")
    public String list(Model model){
        List<Dishes> dishesList = dishService.list();
        model.addAttribute("dishesList",dishesList);
        return "list";
    }


    @GetMapping("/praise")
    public String praise(int dishId){
        //点赞
        dishService.praise(dishId);
        return "redirect:/dish/list";
    }

}
