package com.lz.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lz.dao.MessageBoardMapper;
import com.lz.entity.Collection;
import com.lz.entity.MessageBoardExample;
import com.lz.entity.MessageBoardWithBLOBs;
import com.lz.service.MessageBoardService;
import com.lz.vo.DataVo;
import com.lz.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MessageBoardServiceImpl implements MessageBoardService {
    @Autowired
    private MessageBoardMapper messageBoardMapper;

    @Override
    public ResultVo getList(Integer pageNum, Integer pageSize, Long id) {
        //返回前端的结果
        ResultVo resultVo;
        //分页相关的参数
        DataVo<MessageBoardWithBLOBs> DataVo;
        //结果中data对应的用户数组
        List<MessageBoardWithBLOBs> messageBoards;
        //说明传递了id那就是findById
        if (id!=null){
            messageBoards= new ArrayList<>();

            MessageBoardWithBLOBs messageBoardWithBLOBs = messageBoardMapper.selectByPrimaryKey(id);

            if (messageBoardWithBLOBs==null){

                DataVo=new DataVo<>(0L,messageBoards,pageNum,pageSize);

                resultVo =new ResultVo(4000,"查无此留言",false,DataVo);
            }else {
                messageBoards.add(messageBoardWithBLOBs);

                DataVo=new DataVo<>(1L,messageBoards,pageNum,pageSize);

                resultVo=new ResultVo(1000,"查到了留言",true,DataVo);
            }
        }else {
            //开启分页
            PageHelper.startPage(pageNum,pageSize);

            messageBoards=messageBoardMapper.selectByExampleWithBLOBs(null);

            if (messageBoards.size()==0){
                DataVo=new DataVo<>(0L,messageBoards,pageNum,pageSize);

                resultVo =new ResultVo(4100,"没有留言",false,DataVo);
            }else {
                //封装pageInfo 获取总数据量
                PageInfo<MessageBoardWithBLOBs> pageInfo = new PageInfo<>(messageBoards);

                DataVo=new DataVo<>(pageInfo.getTotal(),messageBoards,pageNum,pageSize);

                resultVo=new ResultVo(1100,"留言查询成功",true,DataVo);
            }
        }
        return resultVo;
    }

    @Override
    public ResultVo add(MessageBoardWithBLOBs messageBoard) {
        ResultVo vo;

        //判断是否有创建时间没有就自己加上去
        if (messageBoard.getCreateTime()==null){
            messageBoard.setCreateTime(Calendar.getInstance(Locale.CHINA).getTime());
        }

        int i = messageBoardMapper.insertSelective((MessageBoardWithBLOBs) messageBoard);

        if (i>0){
            vo=new ResultVo(1000,"添加留言成功",true,messageBoard);
        }else {
            vo=new ResultVo(5000,"添加留言失败",false,null);
        }


        return vo;
    }

    @Override
    public ResultVo update(MessageBoardWithBLOBs messageBoard) {
        ResultVo vo;

        int i = messageBoardMapper.updateByPrimaryKeySelective(messageBoard);

        if (i>0){
            //修改之后再重新查询一次保证返回给前端最新最全的数据
            messageBoard = messageBoardMapper.selectByPrimaryKey(messageBoard.getId());
            vo=new ResultVo(1000,"修改留言成功",true,messageBoard);
        }else {
            vo=new ResultVo(5000,"修改留言失败",false,null);
        }
        return vo;
    }

    @Override
    public ResultVo delete(Long id) {
        ResultVo vo;

        int i = messageBoardMapper.deleteByPrimaryKey(id);

        if (i>0){
            vo=new ResultVo(1000,"删除留言成功",true,null);
        }else {
            vo=new ResultVo(5000,"删除留言失败",false,null);
        }
        return vo;
    }

    @Override
    public ResultVo reply(MessageBoardWithBLOBs messageBoard) {
        ResultVo vo;
        int i = messageBoardMapper.updateByPrimaryKeySelective(messageBoard);

        if (i>0){
            vo=new ResultVo(1000,"回复成功",true,null);
        }else {
            vo=new ResultVo(5000,"回复失败",false,null);
        }

        if (messageBoard.getIsdel().equals(true)){
            messageBoardMapper.del(messageBoard.getId());
            vo=new ResultVo(1000,"删除回复成功",true,null);
        }

        return vo;
    }

    @Override
    public ResultVo search(String val) {
        DataVo<MessageBoardWithBLOBs> messageBoardWithBLOBsDataVo;

        List<MessageBoardWithBLOBs> messageBoardWithBLOBs;

        ResultVo vo;

        MessageBoardExample messageBoardExample = new MessageBoardExample();

        MessageBoardExample.Criteria criteria = messageBoardExample.createCriteria();

        criteria.andUsernameLike("%" + val + "%");

        messageBoardWithBLOBs = messageBoardMapper.selectByExampleWithBLOBs(messageBoardExample);

        if (messageBoardWithBLOBs==null){
            messageBoardWithBLOBsDataVo = new DataVo<>(0L, messageBoardWithBLOBs,null,null);
            vo = new ResultVo(4000, "没有搜索到", false, messageBoardWithBLOBsDataVo);
        }else {

            messageBoardWithBLOBsDataVo = new DataVo<>(1L, messageBoardWithBLOBs, null, null);
            vo = new ResultVo(1000, "搜索到了", true, messageBoardWithBLOBsDataVo);
        }
        return vo;

    }

}
