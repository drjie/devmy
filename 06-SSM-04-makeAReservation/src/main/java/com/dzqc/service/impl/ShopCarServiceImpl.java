package com.dzqc.service.impl;

import com.dzqc.dao.DishMapper;
import com.dzqc.dao.ShopCarMapper;
import com.dzqc.domain.Dishes;
import com.dzqc.domain.ShopCar;
import com.dzqc.domain.User;
import com.dzqc.service.ShopCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShopCarServiceImpl implements ShopCarService {

    @Autowired
    private ShopCarMapper shopCarMapper;
    @Autowired
    private DishMapper dishMapper;

    @Override
    public void add(int dishId, HttpSession session) {

        //获取用户id
        User currUser = (User) session.getAttribute("currUser");
        int userId = currUser.getId();

        ShopCar shopCar = new ShopCar();
        shopCar.setDishId(dishId);
        shopCar.setUserId(userId);

        //通过菜品id查询菜品信息
        Dishes dish = dishMapper.findById(dishId);
        double price = dish.getPrice(); //获取菜品单价
        shopCar.setPrice(price); //设置单价
        shopCar.setDishName(dish.getDishName());

        //计算当前购买的菜品的数量
        ShopCar dishInfo = shopCarMapper.findDishInfo(shopCar);
        if(dishInfo == null){
            shopCar.setDishNum(1);
            shopCar.setTotalPrice(price);
            //第一加入购物：保存信息
            shopCarMapper.save(shopCar);
        }else{
            //购物车数量加一
            shopCar.setDishNum(dishInfo.getDishNum() + 1);
            shopCar.setTotalPrice(shopCar.getDishNum() * price);
            //如果不是第一次加入购物车：更新购物车信息
            shopCarMapper.update(shopCar);

        }


    }

    @Override
    public Map<String,Object> findByUserId(int userId) {

        Map<String,Object> result = new HashMap<>();

        List<ShopCar> shopCarList = shopCarMapper.findByUserId(userId);
        double totalPrice = 0;
        for(ShopCar shopCar : shopCarList){
            totalPrice += shopCar.getTotalPrice();
            /*double itemTotalPrice = shopCar.getTotalPrice();
            totalPrice += itemTotalPrice;*/
        }

        /*shopCarList.forEach(shopCar -> {

        });*/

        result.put("shopCarList",shopCarList);
        result.put("totalPrice",totalPrice);

        return result;
    }

    @Override
    public void remove(int dishId, int userId) {
        shopCarMapper.del(dishId,userId);
    }

    @Override
    public void del(int userId) {
        shopCarMapper.delById(userId);
    }
}
