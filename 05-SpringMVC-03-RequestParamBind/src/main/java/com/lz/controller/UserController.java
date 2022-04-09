package com.lz.controller;

import com.lz.entity.Clazz;
import com.lz.entity.User;
import com.lz.entity.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Controller
@RequestMapping("user")
public class UserController {
    @RequestMapping("testRegister")
    public String testParam(String name, Integer age, String birthday, String gender, String info) {
        System.out.println(name + ":" + age + ":" + gender  + ":" + birthday+ ":" + info);

        return "/success.jsp";
    }

    @RequestMapping("testObject")
    public String testParam(User user) {
        System.out.println(user);

        return "/success.jsp";
    }
    @RequestMapping("getNestedObject")
    public String getNestedObject(UserInfo userInfo){
        System.out.println(userInfo);
        return "/success.jsp";
    }
    @RequestMapping("testListAndMap")
    public String testListAndMap(Clazz clazz){
        System.out.println(clazz);
        return "/success.jsp";
    }
    @RequestMapping("testServlet")
    public void testServlet(HttpServletRequest request, HttpServletResponse response){
        String username = request.getParameter("username");
        request.getSession(true).setAttribute("username","迪丽热巴");

        try {
            request.getRequestDispatcher("/success.jsp").forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
