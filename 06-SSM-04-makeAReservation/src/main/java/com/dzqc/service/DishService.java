package com.dzqc.service;

import com.dzqc.domain.Dishes;

import java.util.List;

public interface DishService {

    /**
     * 查询所有菜品
     * @return
     */
    List<Dishes> list();

    /**
     * 点赞
     * @param dishId
     */
    void praise(int dishId);
}
