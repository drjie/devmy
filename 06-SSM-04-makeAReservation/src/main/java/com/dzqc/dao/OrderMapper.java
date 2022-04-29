package com.dzqc.dao;

import com.dzqc.domain.Order;
import com.dzqc.domain.OrderItem;

import java.util.List;

public interface OrderMapper {
    /**
     * 保存订单信息
     * @param order
     */
    int save(Order order);

    /**
     * 批量插入
     * @param orderItems
     */
    void saveBatch(List<OrderItem> orderItems);
}
