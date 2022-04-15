package com.lz.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lz.dao.PoorMapper;
import com.lz.entity.*;
import com.lz.entity.Collection;
import com.lz.service.PoorService;
import com.lz.vo.DataVo;
import com.lz.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PoorServiceImpl implements PoorService {
    @Autowired
    private PoorMapper poorMapper;

    @Override
    public ResultVo getList(Integer pageNum, Integer pageSize, Long id) {
        //返回前端的结果
        ResultVo resultVo;
        //分页相关的参数
        DataVo<PoorWithBLOBs> poorDataVo;
        //结果中data对应的贫困户数组
        List<PoorWithBLOBs> poors;
        //说明传递了id那就是findById
        if (id != null) {
            poors = new ArrayList<>();

            PoorWithBLOBs poorWithBLOBs = poorMapper.selectByPrimaryKey(id);

            if (poorWithBLOBs == null) {

                poorDataVo = new DataVo<>(0L, poors, pageNum, pageSize);

                resultVo = new ResultVo(4000, "查无此贫困户", false, poorDataVo);
            } else {
                //如果是查询单个那么点击量应该加1
                click(poorWithBLOBs.getId(), null);

                //更新点击次数

                poorWithBLOBs.setClickNum(poorWithBLOBs.getClickNum() + 1);

                poors.add(poorWithBLOBs);

                poorDataVo = new DataVo<>(1L, poors, pageNum, pageSize);

                resultVo = new ResultVo(1000, "查到了贫困户", true, poorDataVo);
            }
        } else {
            //开启分页
            PageHelper.startPage(pageNum, pageSize);

            poors = poorMapper.selectByExampleWithBLOBs(null);

            if (poors.size() == 0) {
                poorDataVo = new DataVo<>(0L, poors, pageNum, pageSize);

                resultVo = new ResultVo(4100, "没有贫困户", false, poorDataVo);
            } else {
                //封装pageInfo 获取总数据量
                PageInfo<PoorWithBLOBs> pageInfo = new PageInfo<>(poors);

                poorDataVo = new DataVo<>(pageInfo.getTotal(), poors, pageNum, pageSize);

                resultVo = new ResultVo(1100, "贫困户查询成功", true, poorDataVo);
            }
        }
        return resultVo;
    }

    @Override
    public ResultVo add(PoorWithBLOBs poor) {
        ResultVo vo;

        //判断是否有创建时间没有就自己加上去
        if (poor.getCreateTime() == null) {
            poor.setCreateTime(Calendar.getInstance(Locale.CHINA).getTime());
        }

        // 新创建的扶贫政策，点击量应该是0
        poor.setClickNum(0);
        poor.setLastClickTime(null);

        int i = poorMapper.insertSelective(poor);

        if (i > 0) {
            vo = new ResultVo(1000, "添加贫困户成功", true, poor);
        } else {
            vo = new ResultVo(5000, "添加贫困户失败", false, null);
        }


        return vo;
    }

    @Override
    public ResultVo update(PoorWithBLOBs poor) {
        ResultVo vo;

        int i = poorMapper.updateByPrimaryKeySelective(poor);

        if (i > 0) {
            //修改之后再重新查询一次保证返回给前端最新最全的数据
            poor = poorMapper.selectByPrimaryKey(poor.getId());
            vo = new ResultVo(1000, "修改贫困户成功", true, poor);
        } else {
            vo = new ResultVo(5000, "修改贫困户失败", false, null);
        }
        return vo;
    }

    @Override
    public ResultVo delete(Long id) {
        ResultVo vo;

        int i = poorMapper.deleteByPrimaryKey(id);

        if (i > 0) {
            vo = new ResultVo(1000, "删除贫困户成功", true, null);
        } else {
            vo = new ResultVo(5000, "删除贫困户失败", false, null);
        }
        return vo;
    }

    @Override
    public ResultVo click(Long id, Date lastClickTime) {
        if (lastClickTime == null) {
            lastClickTime = new Date();
        }

        ResultVo vo;

        int i = poorMapper.click(id, lastClickTime);

        if (i > 0) {
            vo = new ResultVo(1000, "播放量加1成功！！", true, null);
        } else {
            vo = new ResultVo(5000, "播放量加1失败！！", false, null);
        }
        return vo;
    }

    @Override
    public ResultVo search(String val) {

        DataVo<PoorWithBLOBs> poorWithBLOBsDataVo;

        List<PoorWithBLOBs> poorWithBLOBs;

        ResultVo vo;

        PoorExample poorExample = new PoorExample();

        PoorExample.Criteria criteria = poorExample.createCriteria();

        criteria.andNameLike("%" + val + "%");

        poorWithBLOBs = poorMapper.selectByExampleWithBLOBs(poorExample);

        if (poorWithBLOBs==null){
            poorWithBLOBsDataVo = new DataVo<>(0L, poorWithBLOBs,null,null);
            vo = new ResultVo(4000, "没有搜索到", false, poorWithBLOBsDataVo);
        }else {

            poorWithBLOBsDataVo = new DataVo<>(1L, poorWithBLOBs, null, null);
            vo = new ResultVo(1000, "搜索到了", true, poorWithBLOBsDataVo);
        }
        return vo;
    }
}
