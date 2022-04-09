package com.lz.controller;

import com.lz.entity.Alleviation;
import com.lz.entity.Alleviation;
import com.lz.service.AlleviationService;
import com.lz.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("alleviation")
public class AlleviationController {
    @Autowired
    private AlleviationService alleviationService;

    @PostMapping("click")
    public ResultVo click(Alleviation alleviation) {
        return alleviationService.click(alleviation.getId(), alleviation.getLastClickTime());
    }

    @GetMapping("getList")
    public ResultVo getList(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                            @RequestParam(value = "pageSize",defaultValue = "2") Integer pageSize, Long id){
        return alleviationService.getList(pageNum,pageSize,id);
    }

    @PostMapping("add")
    public ResultVo add(@RequestBody Alleviation alleviation){
        return alleviationService.add(alleviation);
    }

    @PostMapping("update")
    public ResultVo update(@RequestBody Alleviation alleviation){
        return alleviationService.update(alleviation);
    }

    @GetMapping("delete")
    public ResultVo delete(@RequestParam Long id){
        return alleviationService.delete(id);
    }
}
