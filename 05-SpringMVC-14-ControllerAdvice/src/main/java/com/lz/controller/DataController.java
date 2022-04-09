package com.lz.controller;

import com.lz.entity.Student;
import com.lz.entity.Teacher;
import com.lz.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("data")
public class DataController {
    @RequestMapping("getDate")
    public void getData(Date date){
        System.out.println(date);
    }

    @RequestMapping("getName")
    @ResponseBody
    public Map<String,Object> getName(Student student, Teacher teacher){
        HashMap<String, Object> map = new HashMap<>();

        map.put("student",student);
        map.put("teacher",teacher);

        return map;
    }

    @RequestMapping("getCreatDateTime")
    @ResponseBody
    public Map<String,Object> getCreatDateTime(User user, @ModelAttribute("creatDateTime") Date creatDateTime){
        HashMap<String, Object> map = new HashMap<>();
        user.setCreatDateTime(creatDateTime);
        map.put("user",user);
        return map;
    }
}
