package com.lz.controller;


import com.lz.entity.MessageBoardWithBLOBs;
import com.lz.service.MessageBoardService;
import com.lz.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("msgboard")

public class MessageBoardController {
    @Autowired
    private MessageBoardService messageBoardService;

    @GetMapping("sousuo")
    public ResultVo search(@RequestParam(value = "val")String val){
        return messageBoardService.search(val);
    }

    @PostMapping("reply")
    public ResultVo reply(@RequestBody MessageBoardWithBLOBs messageBoard){
        return messageBoardService.reply(messageBoard);
    }

    @GetMapping("getlist")
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
