package com.bjpowernode.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class OneFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = null;
        //1.调用请求对象读取请求包中请求行中URI,了解用户访问的资源文件是谁
        String uri = request.getRequestURI();
        //2.如果本次请求资源文件与登录相关
        if (uri.indexOf("login") != -1 || "/myWeb/".equals(uri)){
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }
        //3.如果本次请求访问的是其他资源文件，需要得到用户在服务端HttpSession
        session = request.getSession(false);
        if (session != null){
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }
        //4.做拒绝请求
        request.getRequestDispatcher("/login_error.html").forward(servletRequest,servletResponse);
    }
}
