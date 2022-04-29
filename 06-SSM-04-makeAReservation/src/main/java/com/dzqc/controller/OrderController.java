package com.dzqc.controller;

import com.dzqc.domain.Order;
import com.dzqc.domain.User;
import com.dzqc.service.OrderService;
import com.dzqc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/order")
public class OrderController {


    @Autowired
    private OrderService orderService;

    @GetMapping("/orderform")
    public String orderForm(HttpSession session, Model model){

        Map<String,Object> orderInfo = orderService.orderForm(session);
        model.addAttribute("orderInfo",orderInfo);
        return "order";
    }

    @PostMapping("/save")
    public String saveOrder(Order order,HttpSession session){
        //保存订单信息
        orderService.saveOrder(session,order);
        return "redirect:/dish/list";
    }

}
