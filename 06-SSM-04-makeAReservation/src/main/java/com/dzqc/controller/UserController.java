package com.dzqc.controller;

import com.dzqc.domain.Dishes;
import com.dzqc.domain.User;
import com.dzqc.service.DishService;
import com.dzqc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private DishService dishService;

    @GetMapping("/reg")
    public String reg(){
        return "register";
    }

    @PostMapping("/register")
    public String register(User user, Model model){

        //判断用户名是否有相同的
        boolean result = userService.checkUserName(user.getUsername());
        if(result){
            userService.register(user);
        }else{
            model.addAttribute("code","101");
            //用户名重复了 code = 101
        }

        return "register";
    }

    @GetMapping("/checkUserName")
    @ResponseBody
    public boolean checkUserName(String userName){
        System.out.println("userName:" + userName);
        //校验
        boolean result = userService.checkUserName(userName);
        return result;
    }

    /**
     * ajax请求注册用户
     * @param user
     * @return
     */
    @PostMapping("/ajaxRegister")
    public @ResponseBody String ajaxRegister(@RequestBody User user){
        System.out.println(user);

        //保存注册信息
        userService.register(user);

        return "1";
    }


    @GetMapping("/loginform")
    public String loginForm(){
        return "login2";
    }


    @PostMapping("/login")
    public String login(User user, Model model, HttpSession session){
          User currUser = userService.login(user);
          if(currUser == null){
              //用户名或密码错误
              model.addAttribute("code",102);
              return "login2";
          }else {
              //把当前登录者存入到session 空间
              session.setAttribute("currUser",currUser);
              return "redirect:/dish/list";
          }
    }



}
