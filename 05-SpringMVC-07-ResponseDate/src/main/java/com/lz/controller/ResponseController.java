package com.lz.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lz.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("response")
public class ResponseController {
    @RequestMapping("testVoid")
    public void testVoid(){
        System.out.println("测试返回值是void 无法被视图解析了");
    }

    @RequestMapping("testString")
    public String testString(){
        System.out.println("测试返回值是String 直接跳转到");
        return "/success.jsp";
    }

    @RequestMapping("testModelAndView")
    public ModelAndView testModelAndView(){
        ModelAndView mv = new ModelAndView();
        //设置模型
        mv.addObject("username","迪丽热巴");
        //设置视图
        mv.setViewName("/success.jsp");

        return mv;
    }
    @RequestMapping("testModelAndView2")
    public ModelAndView testModelAndView2(){
        ModelAndView mv = new ModelAndView();
        //设置模型
        mv.addObject("username","鞠婧祎");
        //设置视图
        mv.setViewName("/success.jsp");

        return mv;
    }
    @RequestMapping("testModelAndView3")
    public ModelAndView testModelAndView3(){
        ModelAndView mv = new ModelAndView();
        //设置模型
        mv.addObject("username","古力娜扎");
        //设置视图
        mv.setViewName("/success.jsp");

        return mv;
    }


    @RequestMapping("testVoidRedirect")
    public void testVoidRedirect(HttpServletRequest request, HttpServletResponse response){
        try {
            response.sendRedirect("/success.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("testVoidForward")
    public void testVoidForward(HttpServletRequest request,HttpServletResponse response){
        request.setAttribute("username","张天爱");
        try {
            request.getRequestDispatcher("/success.jsp").forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("testStringRedirect")
    public String testStringRedirect(){
        return "redirect:/success.jsp";
    }


    @RequestMapping("testStringForward")
    public String testStringForward(Model model){
        model.addAttribute("username","宋祖儿");
        return "/success.jsp";
    }

    //ResponseBody注解自动跳过视图解析器
    //并且返回json数据结构
    @RequestMapping("testResponseBody")
    @ResponseBody
    public void testResponseBody(){
        System.out.println("测试@ResponseBody");
    }

    @RequestMapping("testResponseBodyString")
    @ResponseBody
    public String testResponseBodyString(){
        //如果直接使用字符串返回就相当于调用
        //resp.getWriter.writer（“/success.jsp”）
        return "/success.jsp";
    }

    @RequestMapping(value = "testHtmlString" ,produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String testHtmlString(){

        return "<h1 align='center' style='color:green'>迪丽热巴</h1>";
    }

    @RequestMapping(value = "testJsonString" ,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String testJsonString(){

        return "{\"username\":\"鞠婧祎\",\"password\":\"123456\"}";
    }

    @RequestMapping(value = "testJsonObject" ,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String testJsonObject(){
        User user = new User();
        user.setName("迪丽热巴");
        user.setAge(22);
        user.setGender("女");
        user.setBirthday(new Date());
        user.setInfo("美女");
        //获取对象映射器

        ObjectMapper objectMapper = new ObjectMapper();
        String json=null;

        try {
            objectMapper.writeValueAsString(user);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(json);

        return json;
    }

    @RequestMapping(value = "testObject" ,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public User testObject(){
        User user = new User();
        user.setName("迪丽热巴");
        user.setAge(22);
        user.setGender("女");
        user.setBirthday(new Date());
        user.setInfo("美女");

        return user;
    }

    @RequestMapping(value = "testMap" ,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Map<String,Object> testMap(){
        User user = new User();
        user.setName("迪丽热巴");
        user.setAge(22);
        user.setGender("女");
        user.setBirthday(new Date());
        user.setInfo("美女");


        List<String> foods = new ArrayList<>();

        foods.add("烤羊排");
        foods.add("烤乳猪");
        foods.add("烤红薯");
        foods.add("烤玉米");

        HashMap<String, Object> map = new HashMap<>();

        map.put("code",200);
        map.put("success",true);
        map.put("message","成功");
        map.put("data",user);
        map.put("foods",foods);

        return map;
    }
}
