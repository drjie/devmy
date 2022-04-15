package com.lz.controller;

import com.lz.entity.Collection;
import com.lz.service.CollectService;
import com.lz.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("collection")

public class CollectController {
    @Autowired
    private CollectService collectService;

    @GetMapping("sousuo")
    public ResultVo search(@RequestParam(value = "val")String val){
        return collectService.search(val);
    }

    @GetMapping("getlist")
    public ResultVo getList(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                            @RequestParam(value = "pageSize",defaultValue = "2") Integer pageSize, Long id){
        return collectService.getList(pageNum,pageSize,id);
    }

    @PostMapping("add")
    public ResultVo add(@RequestBody Collection collection){
        return collectService.add(collection);
    }

    @PostMapping("update")
    public ResultVo update(@RequestBody Collection collection){
        return collectService.update(collection);
    }

    @GetMapping("delete")
    public ResultVo delete(@RequestParam Long id){
        return collectService.delete(id);
    }

}
