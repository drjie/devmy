package com.lz.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lz.dao.CollectionMapper;
import com.lz.entity.*;
import com.lz.entity.Collection;
import com.lz.service.CollectService;
import com.lz.vo.DataVo;
import com.lz.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CollectServiceImpl implements CollectService {
    @Autowired
    private CollectionMapper collectionMapper;

    @Override
    public ResultVo getList(Integer pageNum, Integer pageSize, Long id) {
        //返回前端的结果
        ResultVo resultVo;
        //分页相关的参数
        DataVo<Collection> collectionDataVo;
        //结果中data对应的用户数组
        List<Collection> collections;
        //说明传递了id那就是findById
        if (id != null) {
            collections = new ArrayList<>();

            Collection collection = collectionMapper.selectByPrimaryKey(id);

            if (collection == null) {

                collectionDataVo = new DataVo<>(0L, collections, pageNum, pageSize);

                resultVo = new ResultVo(4000, "查无此收藏表", false, collectionDataVo);
            } else {
                collections.add(collection);

                collectionDataVo = new DataVo<>(1L, collections, pageNum, pageSize);

                resultVo = new ResultVo(1000, "查到了收藏表", true, collectionDataVo);
            }
        } else {
            //开启分页
            PageHelper.startPage(pageNum, pageSize);

            collections = collectionMapper.selectByExample(null);

            if (collections.size() == 0) {
                collectionDataVo = new DataVo<>(0L, collections, pageNum, pageSize);

                resultVo = new ResultVo(4100, "没有收藏表", false, collectionDataVo);
            } else {
                //封装pageInfo 获取总数据量
                PageInfo<Collection> pageInfo = new PageInfo<>(collections);

                collectionDataVo = new DataVo<>(pageInfo.getTotal(), collections, pageNum, pageSize);

                resultVo = new ResultVo(1100, "收藏表查询成功", true, collectionDataVo);
            }
        }
        return resultVo;
    }

    @Override
    public ResultVo add(Collection collection) {
        ResultVo vo;

        //判断是否有创建时间没有就自己加上去
        if (collection.getCreateTime() == null) {
            collection.setCreateTime(Calendar.getInstance(Locale.CHINA).getTime());
        }

        int i = collectionMapper.insertSelective(collection);

        if (i > 0) {
            vo = new ResultVo(1000, "添加收藏表成功", true, collection);
        } else {
            vo = new ResultVo(5000, "添加收藏表失败", false, null);
        }


        return vo;
    }

    @Override
    public ResultVo update(Collection collection) {
        ResultVo vo;

        int i = collectionMapper.updateByPrimaryKeySelective(collection);

        if (i > 0) {
            //修改之后再重新查询一次保证返回给前端最新最全的数据
            collection = collectionMapper.selectByPrimaryKey(collection.getId());
            vo = new ResultVo(1000, "修改收藏表成功", true, collection);
        } else {
            vo = new ResultVo(5000, "修改收藏表失败", false, null);
        }
        return vo;
    }

    @Override
    public ResultVo delete(Long id) {
        ResultVo vo;

        int i = collectionMapper.deleteByPrimaryKey(id);

        if (i > 0) {
            vo = new ResultVo(1000, "删除收藏表成功", true, null);
        } else {
            vo = new ResultVo(5000, "删除收藏表失败", false, null);
        }
        return vo;
    }

    @Override
    public ResultVo search(String val) {
        DataVo<Collection> collectionDataVo;

        List<Collection> collections;

        ResultVo vo;

        CollectionExample collectionExample = new CollectionExample();

        CollectionExample.Criteria criteria = collectionExample.createCriteria();

        criteria.andNameLike("%" + val + "%");

        collections = collectionMapper.selectByExample(collectionExample);

        if (collections==null){
            collectionDataVo = new DataVo<>(0L, collections,null,null);
            vo = new ResultVo(4000, "没有搜索到", false, collectionDataVo);
        }else {

            collectionDataVo = new DataVo<>(1L, collections, null, null);
            vo = new ResultVo(1000, "搜索到了", true, collectionDataVo);
        }
        return vo;
    }
}
