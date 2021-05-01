package com.bjpowernode.controller;

import com.bjpowernode.dao.QuestionDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class QuestionFindServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QuestionDao dao = new QuestionDao();
        //1.调用DAO推送查询命令得到所有的试题
        List list = dao.findAll();
        //2.得到试题添加到请求作用域对象作为共享数据
        request.setAttribute("key",list);
        //3.请求转发向tomcat调用question.jsp将结果与html标签写入到响应体
        request.getRequestDispatcher("/questions.jsp").forward(request,response);
    }
}
