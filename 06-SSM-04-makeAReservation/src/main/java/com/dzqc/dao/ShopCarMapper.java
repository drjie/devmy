package com.dzqc.dao;

import com.dzqc.domain.Dishes;
import com.dzqc.domain.ShopCar;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopCarMapper {

    /**
     * 通过用户id和菜品id查找加入购物车的信息
     * @param shopCar
     * @return
     */
    ShopCar findDishInfo(ShopCar shopCar);

    /**
     * 保存购物车信息
     * @param shopCar
     */
    void save(ShopCar shopCar);

    /**
     * 更新购物车
     * @param shopCar
     */
    void update(ShopCar shopCar);

    /**
     * 查询当前登录者的购物车信息
     * @param userId
     * @return
     */
    List<ShopCar> findByUserId(int userId);

    /**
     * 根据当前登录者id和菜品id从购物车中移除
     * @param dishId
     * @param userId
     */
    void del(@Param("dishId") int dishId, @Param("userId")int userId);

    /**
     * 删除购物车信息
     * @param userId
     */
    void delById(int userId);
}
