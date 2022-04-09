package com.lz.controller;

import com.lz.entity.Collection;
import com.lz.entity.MessageBoard;
import com.lz.entity.MessageBoardWithBLOBs;
import com.lz.entity.User;
import com.lz.service.MessageBoardService;
import com.lz.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("msgboard")
public class MessageBoardController {
    @Autowired
    private MessageBoardService messageBoardService;

    @PostMapping("reply")
    public ResultVo reply(@RequestBody MessageBoardWithBLOBs messageBoard){
        return messageBoardService.reply(messageBoard);
    }

    @GetMapping("getList")
    public ResultVo getList(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                            @RequestParam(value = "pageSize",defaultValue = "2") Integer pageSize, Long id){
        return messageBoardService.getList(pageNum,pageSize,id);
    }

    @PostMapping("add")
    public ResultVo add(@RequestBody MessageBoardWithBLOBs messageBoard){
        return messageBoardService.add(messageBoard);
    }

    @PostMapping("update")
    public ResultVo update(@RequestBody MessageBoardWithBLOBs messageBoard){
        return messageBoardService.update(messageBoard);
    }

    @GetMapping("delete")
    public ResultVo delete(@RequestParam Long id){
        return messageBoardService.delete(id);
    }
}
