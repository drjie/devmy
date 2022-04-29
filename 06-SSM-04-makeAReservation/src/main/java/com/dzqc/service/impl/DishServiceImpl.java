package com.dzqc.service.impl;

import com.dzqc.dao.DishMapper;
import com.dzqc.domain.Dishes;
import com.dzqc.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishServiceImpl implements DishService {


    @Autowired
    private DishMapper dishMapper;

    @Override
    public List<Dishes> list(){
        List<Dishes> dishesList = dishMapper.findAll();
        return dishesList;
    }

    @Override
    public void praise(int dishId) {
        dishMapper.updatePraiseNum(dishId);
    }


}
