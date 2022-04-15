package com.lz.controller;

import com.lz.entity.Alleviation;
import com.lz.entity.VolunteerRecruitment;
import com.lz.service.VolunteerRecruitmentService;
import com.lz.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("volunteer")

public class VolunteerRecruitmentController {
    @Autowired
    private VolunteerRecruitmentService volunteerRecruitmentService;

    @GetMapping("sousuo")
    public ResultVo search(@RequestParam(value = "val")String val){
        return volunteerRecruitmentService.search(val);
    }

    @PostMapping("click")
    public ResultVo click(Alleviation alleviation) {
        return volunteerRecruitmentService.click(alleviation.getId(), alleviation.getLastClickTime());
    }

    @GetMapping("getlist")
    public ResultVo getList(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                            @RequestParam(value = "pageSize",defaultValue = "2") Integer pageSize, Long id){
        return volunteerRecruitmentService.getList(pageNum,pageSize,id);
    }

    @PostMapping("add")
    public ResultVo add(@RequestBody VolunteerRecruitment volunteerRecruitment){
        return volunteerRecruitmentService.add(volunteerRecruitment);
    }

    @PostMapping("update")
    public ResultVo update(@RequestBody VolunteerRecruitment volunteerRecruitment){
        return volunteerRecruitmentService.update(volunteerRecruitment);
    }

    @GetMapping("delete")
    public ResultVo delete(@RequestParam Long id){
        return volunteerRecruitmentService.delete(id);
    }
}
