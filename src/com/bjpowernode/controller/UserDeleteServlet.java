package com.bjpowernode.controller;

import com.bjpowernode.dao.UserDao;
import com.bjpowernode.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserDeleteServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId;
        UserDao dao = new UserDao();
        int result = 0;
        PrintWriter out = null;
        //1.[调用请求对象]读取【请求头】参数（用户编号）
        userId = request.getParameter("userId");
        //2.[调用DAO]将用户编号填充到delete命令并发送到数据库服务器
        result = dao.delete(userId);
        //3.[调用响应对象]将处理结果以二进制写入到响应体，交给浏览器
        response.setContentType("text/html;charset=utf-8");
        out = response.getWriter();
        if (result == 1){
            out.print("<font style='color:red;font-size:40px'>用户信息删除成功</font>");
        }else {
            out.print("<font style='color:red;font-size:40px'>用户信息删除失败</font>");
        }
    }
}
