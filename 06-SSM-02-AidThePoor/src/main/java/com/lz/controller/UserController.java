package com.lz.controller;

import com.lz.entity.User;
import com.lz.service.UserService;
import com.lz.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("sousuo")
    public ResultVo search(@RequestParam(value = "val")String val){
        return userService.search(val);
    }

    @GetMapping("getlist")
    public ResultVo getList(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                            @RequestParam(value = "pageSize",defaultValue = "2") Integer pageSize, Long id){
        return userService.getList(pageNum,pageSize,id);
    }

    @PostMapping("add")
    public ResultVo add(@RequestBody User user){
        return userService.add(user);
    }

    @PostMapping("update")
    public ResultVo update(@RequestBody User user){
        return userService.update(user);
    }

    @GetMapping("delete")
    public ResultVo delete(@RequestParam Long id){
        return userService.delete(id);
    }
}
