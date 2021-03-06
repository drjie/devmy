package com.lz._01_ThirdLayerApplication.control;

import com.lz._01_ThirdLayerApplication.entity.Student;
import com.lz._01_ThirdLayerApplication.service.StudentService;
import com.lz._01_ThirdLayerApplication.service.impl.StudentServiceImpl;
import com.lz._01_ThirdLayerApplication.vo.PageInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/page")
public class PageServlet extends HttpServlet {
    // 表示层依赖了业务逻辑层
    StudentService studentService = new StudentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取前端的请求参数
        String parameter = req.getParameter("pageNo");

        int pageNo = 1;

        if (parameter != null) {
            pageNo = Integer.parseInt(parameter);
        }

        // 每页显示多少条
        int pageSize = 5;

        // 通过依赖的传递获取了pageInfo
        PageInfo<Student> pageInfo = studentService.getPageInfo(pageNo, pageSize);

        // 设置域对象
        req.setAttribute("pageInfo", pageInfo);

        // 发送到前端
        req.getRequestDispatcher("page1.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
