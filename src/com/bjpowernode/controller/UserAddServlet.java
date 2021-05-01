package com.bjpowernode.controller;

import com.bjpowernode.dao.UserDao;
import com.bjpowernode.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class UserAddServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName,password,sex,email;
        UserDao dao = new UserDao();
        Users user = null;
        int result = 0;
        PrintWriter out = null;
        //1.【调用请求对象】读取【请求头】参数信息，得到用户的信息
        userName = request.getParameter("userName");
        password = request.getParameter("password");
        sex = request.getParameter("sex");
        email = request.getParameter("email");

        //2.【调用UserDao】将用户信息填充到INSERT命令并借助JDBC规范发送到数据库服务器
        user = new Users(null,userName,password,sex,email);
        Date starDate = new Date();
        result = dao.add(user);
        Date endDate = new Date();
        System.out.println("添加消耗时间 = "+(endDate.getTime() - starDate.getTime())+"毫秒");
        //3.【调用响应对象】将【处理结果】以二进制形式写入到响应体
        response.setContentType("text/html;charset=utf-8");
        out = response.getWriter();
        if (result == 1){
            out.print("<font style='color:red;font-size:40px'>用户信息注册成功</font>");
        }else {
            out.print("<font style='color:red;font-size:40px'>用户信息注册失败</font>");
        }
    }
        //Tomcat负责销毁【请求对象】和【响应对象】
        //Tomcat负责将Http响应协议包推送到发起请求对象的浏览器上
        //浏览器根据响应头conten-type指定编译器对响应体二进制内容编辑
        //浏览器将编辑后结果在窗口中展示给用户【结束】
}
