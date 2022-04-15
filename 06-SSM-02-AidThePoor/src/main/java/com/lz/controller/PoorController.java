package com.lz.controller;

import com.lz.entity.*;
import com.lz.service.MessageBoardService;
import com.lz.service.PoorService;
import com.lz.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("poor")

public class PoorController {
    @Autowired
    private PoorService poorService;

    @GetMapping("sousuo")
    public ResultVo search(@RequestParam(value = "val")String val){
        return poorService.search(val);
    }

    @PostMapping("click")
    public ResultVo click(Poor poor) {
        return poorService.click(poor.getId(), poor.getLastClickTime());
    }

    @GetMapping("getlist")
    public ResultVo getList(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                            @RequestParam(value = "pageSize",defaultValue = "2") Integer pageSize, Long id){
        return poorService.getList(pageNum,pageSize,id);
    }

    @PostMapping("add")
    public ResultVo add(@RequestBody PoorWithBLOBs poor){
        return poorService.add(poor);
    }

    @PostMapping("update")
    public ResultVo update(@RequestBody PoorWithBLOBs poor){
        return poorService.update(poor);
    }

    @GetMapping("delete")
    public ResultVo delete(@RequestParam Long id){
        return poorService.delete(id);
    }
}
