package com.lz.controller;

import com.lz.entity.Carousel;
import com.lz.entity.Carousel;
import com.lz.service.CarouselService;
import com.lz.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("carousel")
public class CarouselController {
    @Autowired
    private CarouselService carouselService;

    @PostMapping("state")
    public ResultVo changeStatus(@RequestParam Integer id) {
        return carouselService.changeStatus(id);
    }

    @GetMapping("getList")
    public ResultVo getList(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                            @RequestParam(value = "pageSize",defaultValue = "2") Integer pageSize, Integer id){
        return carouselService.getList(pageNum,pageSize,id);
    }

    @PostMapping("add")
    public ResultVo add(@RequestBody Carousel carousel){
        return carouselService.add(carousel);
    }

    @PostMapping("update")
    public ResultVo update(@RequestBody Carousel carousel){
        return carouselService.update(carousel);
    }

    @GetMapping("delete")
    public ResultVo delete(@RequestParam Integer id){
        return carouselService.delete(id);
    }
}
