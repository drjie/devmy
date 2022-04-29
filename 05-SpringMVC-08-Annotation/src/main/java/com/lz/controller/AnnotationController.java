package com.lz.controller;

import com.lz.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("annotation")
public class AnnotationController {
    @RequestMapping("testRequestParam")
    public String testRequestParam(@RequestParam(value = "id",required = true,defaultValue = "1")String id){
        System.out.println("获取到的参数:"+id);
        return "success.jsp";
    }

    @RequestMapping("page")
    public String page(@RequestParam(value = "pageNo",defaultValue = "1") Integer pageNo,
                       @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize){
        System.out.println("当前页:"+pageNo+",每页显示多少条数据"+pageSize);
        return "/success.jsp";
    }
    @RequestMapping("keyWord")
    public String keyWord(@RequestParam(value = "name",defaultValue = "") String name,
                          @RequestParam(value = "gender",defaultValue = "") String gender){
        System.out.println("是否有姓名："+name+",是否有年龄："+gender);

        return "/success.jsp";
    }

    @GetMapping("user/{id}")
    public String getUser(@PathVariable("id") Integer id){
        System.out.println("查询学生："+id);

        return "/success.jsp";
    }

    @DeleteMapping("user/{id}")
    public String deleteUser(@PathVariable("id") Integer id){
        System.out.println("删除学生："+id);

        return "/success.jsp";
    }

    @PostMapping("user/{id}")
    public String addUser(@PathVariable("id") Integer id){
        System.out.println("添加学生："+id);

        return "/success.jsp";
    }

    @PutMapping("user/{id}")
    public String updateUser(@PathVariable("id") Integer id){
        System.out.println("修改学生："+id);

        return "/success.jsp";
    }

    @RequestMapping("testJson")
    public String testJson(@RequestBody String json){
        System.out.println(json);
        return "/success.jsp";
    }

    @RequestMapping(value = "testObjectJson",consumes = "application/json;charset=UTF-8")
    public String testObjectJson(@RequestBody User user){
        System.out.println(user);
        return "/success.jsp";
    }
}
