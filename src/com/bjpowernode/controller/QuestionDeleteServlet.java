package com.bjpowernode.controller;

import com.bjpowernode.dao.QuestionDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QuestionDeleteServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String questionId;
        QuestionDao dao = new QuestionDao();
        int result = 0;
        //1.调用请求对象读取请求头参数信息，得到试题编号
        questionId = request.getParameter("questionId");
        //2.调用Dao对象将删除命令推送到数据库服务器
        result = dao.delete(questionId);
        //3.调用info.jsp将处理结果写入响应体
        if (result == 1){
            request.setAttribute("info","试题删除成功");
        }else {
            request.setAttribute("info","试题删除失败");
        }
        request.getRequestDispatcher("/info.jsp").forward(request,response);
    }
}
