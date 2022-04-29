package com.dzqc.dao;

import com.dzqc.domain.Dishes;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DishMapper {

    /**
     * 查询所有菜品
     * @return
     */
    List<Dishes> findAll();

    /**
     * 通过菜品id查询菜品信息
     * @param dishId
     * @return
     */
    Dishes findById(int dishId);

    /**
     * 点赞
     * @param dishId
     */
    void updatePraiseNum(int dishId);
}
