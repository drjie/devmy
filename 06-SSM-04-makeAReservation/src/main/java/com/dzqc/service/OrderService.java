package com.dzqc.service;

import com.dzqc.domain.Order;

import javax.servlet.http.HttpSession;
import java.util.Map;

public interface OrderService {

    Map<String,Object> orderForm(HttpSession session);

    /**
     * 保存订单信息
     */
    void saveOrder(HttpSession session,Order order);
}
