package com.lz.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lz.dao.CarouselMapper;
import com.lz.entity.Alleviation;
import com.lz.entity.AlleviationExample;
import com.lz.entity.Carousel;
import com.lz.entity.CarouselExample;
import com.lz.service.CarouselService;
import com.lz.vo.DataVo;
import com.lz.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CarouselServiceImpl implements CarouselService {
    @Autowired
    private CarouselMapper carouselMapper;

    @Override
    public ResultVo getList(Integer pageNum, Integer pageSize, Integer id) {
        ResultVo resultVo;
        DataVo<Carousel> carouselDataVo;
        List<Carousel> carousels;
        if (id != null) {
            carousels = new ArrayList<>();

            Carousel carousel = carouselMapper.selectByPrimaryKey(id);

            if (carousel == null) {
                carouselDataVo = new DataVo<>(0L, carousels, pageNum, pageSize);

                resultVo = new ResultVo(4000, "查无此图", false, carouselDataVo);
            } else {
                carousels.add(carousel);
                carouselDataVo = new DataVo<>(1L, carousels, pageNum, pageSize);
                resultVo = new ResultVo(1000, "查到图片", true, carouselDataVo);
            }
        } else {
            //开启分页
            PageHelper.startPage(pageNum, pageSize);

            carousels = carouselMapper.selectByExample(null);

            if (carousels.size() == 0) {
                carouselDataVo = new DataVo<>(0L, carousels, pageNum, pageSize);
                resultVo = new ResultVo(4100, "没有图片", true, carouselDataVo);
            } else {
                //封装pageinfo获取的数据总数
                PageInfo<Carousel> pageInfo = new PageInfo<>(carousels);
                carouselDataVo = new DataVo<>(pageInfo.getTotal(), carousels, pageNum, pageSize);
                resultVo = new ResultVo(1100, "图片查询成功", true, carouselDataVo);
            }
        }
        return resultVo;
    }

    @Override
    public ResultVo add(Carousel carousel) {
        ResultVo vo;
        int i = carouselMapper.insertSelective(carousel);

        if (i > 0) {
            vo = new ResultVo(1000, "添加图片成功", true, carousel);
        } else {
            vo = new ResultVo(5000, "添加图片失败", false, null);
        }

        return vo;
    }

    @Override
    public ResultVo update(Carousel carousel) {
        ResultVo vo;
        int i = carouselMapper.updateByPrimaryKeySelective(carousel);

        if (i > 0) {
            carousel = carouselMapper.selectByPrimaryKey(carousel.getId());
            vo = new ResultVo(1000, "图片修改成功", true, carousel);
        } else {
            vo = new ResultVo(5000, "图片修改失败", false, null);
        }


        return vo;
    }

    @Override
    public ResultVo delete(Integer id) {
        ResultVo vo;
        int i = carouselMapper.deleteByPrimaryKey(id);

        if (i > 0) {
            vo = new ResultVo(1000, "图片删除成功", true, null);
        } else {
            vo = new ResultVo(5000, "图片删除失败", false, null);
        }
        return vo;
    }

    @Override
    public ResultVo changeStatus(Integer id) {
        ResultVo vo;

        int i = carouselMapper.changeStatus(id);

        if (i > 0) {
            vo = new ResultVo(1000, "修改当前的状态成功！！", true, null);
        } else {
            vo = new ResultVo(5000, "修改当前的状态失败！！", false, null);
        }

        return vo;
    }

    @Override
    public ResultVo search(String val) {
        DataVo<Carousel> carouselDataVo;

        List<Carousel> carousels;

        ResultVo vo;

        CarouselExample carouselExample = new CarouselExample();

        CarouselExample.Criteria criteria = carouselExample.createCriteria();

        criteria.andNameLike("%" + val + "%");

        carousels = carouselMapper.selectByExample(carouselExample);

        if (carousels==null){
            carouselDataVo = new DataVo<>(0L, carousels,null,null);
            vo = new ResultVo(4000, "没有搜索到", false, carouselDataVo);
        }else {

            carouselDataVo = new DataVo<>(1L, carousels, null, null);
            vo = new ResultVo(1000, "搜素到了", true, carouselDataVo);
        }
        return vo;
    }
}
