package com.dzqc.service;

import com.dzqc.domain.ShopCar;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public interface ShopCarService {

    /**
     * 添加购物车
     * @param dishId
     * @param session
     */
    void add(int dishId, HttpSession session);

    /**
     * 查询当前登录者的购物信息
     * @param userId
     * @return
     */
    Map<String,Object> findByUserId(int userId);

    /**
     * 从购物车中移除菜品
     * @param dishId
     */
    void remove(int dishId,int userId);

    /**
     * 删除购物车信息
     * @param userId
     */
    void del(int userId);
}
