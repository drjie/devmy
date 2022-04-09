package com.lz.service;


import com.lz.entity.MessageBoardWithBLOBs;
import com.lz.vo.ResultVo;

public interface MessageBoardService {

    ResultVo getList(Integer pageNum, Integer pageSize, Long id);

    ResultVo add(MessageBoardWithBLOBs messageBoard);

    ResultVo update(MessageBoardWithBLOBs messageBoard);

    ResultVo delete(Long id);


    ResultVo reply(MessageBoardWithBLOBs messageBoard);

}
