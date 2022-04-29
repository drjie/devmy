package com.dzqc.service.impl;

import com.dzqc.dao.OrderMapper;
import com.dzqc.dao.ShopCarMapper;
import com.dzqc.domain.Order;
import com.dzqc.domain.OrderItem;
import com.dzqc.domain.ShopCar;
import com.dzqc.domain.User;
import com.dzqc.service.OrderService;
import com.dzqc.service.ShopCarService;
import com.dzqc.service.UserService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.*;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private UserService userService;
    @Autowired
    private ShopCarService shopCarService;

    @Autowired
    private OrderMapper orderMapper;


    @Override
    public Map<String, Object> orderForm(HttpSession session) {
        //获取当前登录者id
        User currUser = (User) session.getAttribute("currUser");

        Map<String, Object> result = shopCarService.findByUserId(currUser.getId());
        //获取总价
        double totalPrice = (double) result.get("totalPrice");

        //获取所有菜品
        List<ShopCar> shopCarList = (List<ShopCar>) result.get("shopCarList");
        List<OrderItem> orderItems = new ArrayList<>();
        for (ShopCar shopCar : shopCarList) {
            OrderItem orderItem = new OrderItem();
            BeanUtils.copyProperties(shopCar,orderItem);
            orderItems.add(orderItem);
        }

        Map<String,Object> orderInfo = new HashMap<>();
        orderInfo.put("totalPrice",totalPrice);

        return orderInfo;
    }

    @Override
    public void saveOrder(HttpSession session,Order order) {
        User currUser = (User) session.getAttribute("currUser");
        order.setOrderTime(new Date(System.currentTimeMillis()));
        order.setOrderState(0);
        order.setUserid(currUser.getId());
        //保存订单信息
        int row = orderMapper.save(order);
        //保存订单项信息
        saveOrderItem(session,order.getId());
        //清空我的购物车
        shopCarService.del(currUser.getId());

    }

    /**
     * 保存订单项
     *
     * @param session
     */
    private void saveOrderItem(HttpSession session,int orderId) {
        User currUser = (User) session.getAttribute("currUser");
        Map<String, Object> result = shopCarService.findByUserId(currUser.getId());
        //获取所有菜品
        List<ShopCar> shopCarList = (List<ShopCar>) result.get("shopCarList");

        List<OrderItem> orderItems = new ArrayList<>();
        for (ShopCar shopCar : shopCarList) {
            OrderItem orderItem = new OrderItem();
            BeanUtils.copyProperties(shopCar,orderItem);
            orderItem.setOrderId(orderId);
            orderItems.add(orderItem);
        }
        //批量插入
        orderMapper.saveBatch(orderItems);
    }



}
