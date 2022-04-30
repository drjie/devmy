package com.lz.controller;

import com.lz.entity.TbUser;
import com.lz.service.TbUserService;
import com.lz.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private TbUserService tbUserService;

    @PostMapping("login")
    public ModelAndView login(TbUser tbUser,
                              Integer remember,
                              HttpSession session,
                              HttpServletResponse response,
                              ModelAndView mv) {
        ResultVO vo = tbUserService.login(tbUser.getUsername(), tbUser.getPassword());

        if (vo.getCode() == 0) {
            //登录失败
            mv.addObject("resultInfo", vo);

            mv.setViewName("forward:/login.jsp");
        } else {
            session.setAttribute("user", vo.getData());
            Cookie cookie;
            if (remember != null && remember == 1) {
                cookie = new Cookie("JSESSIONID", session.getId());

                cookie.setMaxAge(30 * 60);
            } else {
                cookie = new Cookie("JSESSIONID", null);

                cookie.setMaxAge(-1);
            }
            response.addCookie(cookie);
            mv.setViewName("forward:/index.jsp");
        }

        return mv;
    }

    @GetMapping("logout")
    public ModelAndView logout(HttpSession session,
                               HttpServletResponse response,
                               HttpServletRequest request,
                               ModelAndView mv){
        HttpSession httpSession = request.getSession(false);

        // 判断session是否为空
        if (session != null) {
            session.invalidate();
        }

        // 通过 JSESSIONID 获取 cookie 对象
        Cookie cookie = new Cookie("JSESSIONID", "");

        // 设置 cookie 的有效期为 0
        cookie.setMaxAge(0);

        // 发送Cookie数据至浏览器
        response.addCookie(cookie);

        mv.setViewName("forward:/login.jsp");

        return mv;
    }

    @RequestMapping("userCenter")
    public ModelAndView userCenter(ModelAndView mv){
        TbUser user = new TbUser();

        ResultVO vo=tbUserService.userCenter();

        mv.addObject("menu_page",user);
        mv.addObject("changePage","user/info.jsp");
        mv.setViewName("forward:/index.jsp");
        return mv;
    }

    @PostMapping("update")
    public ModelAndView update(ModelAndView mv, MultipartFile img,TbUser tbUser,String type,HttpSession session,HttpServletResponse response){

        TbUser user=tbUserService.update(img,tbUser,type);

        session.setAttribute("user",user);

        mv.setViewName("forward:/user/userCenter");
        return mv;
    }

    @GetMapping("checkNick")
    public int checkNick(@RequestBody TbUser tbUser){

        return tbUserService.checkNick(tbUser);

    }

}
