<%@ page import="java.util.List" %>
<%@ page import="com.bjpowernode.entity.Question" %><%--
  Created by IntelliJ IDEA.
  User: Hasee
  Date: 2021/3/16
  Time: 22:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="2px" align="center">
    <tr align="center">
        <td>题目编号</td>
        <td>题目信息</td>
        <td>A</td>
        <td>B</td>
        <td>C</td>
        <td>D</td>
        <td>正确答案</td>
        <td colspan="2px">操作</td>
    </tr>
    <%
        List list = (List) request.getAttribute("key");
        for (int i = 0; i < list.size();i++){
            Question question = (Question) list.get(i);
    %>

        <%
            if (i%2==0){
        %>
            <tr style="background-color: green">
        <%
            }else {
        %>
            <tr style="background-color: yellow">
        <%
            }
        %>
        <td><%=question.getQuestionId()%></td>
        <td><%=question.getTitle()%></td>
        <td><%=question.getOptionA()%></td>
        <td><%=question.getOptionB()%></td>
        <td><%=question.getOptionC()%></td>
        <td><%=question.getOptionD()%></td>
        <td><%=question.getAnswer()%></td>
        <td>
            <a href="/myWeb/question/delete?questionId=<%=question.getQuestionId()%>">删除试题</a>
        </td>
        <td>
            <a href="/myWeb/question/findById?questionId=<%=question.getQuestionId()%>">详细信息</a>
        </td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
