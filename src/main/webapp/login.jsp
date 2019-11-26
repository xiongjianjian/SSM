<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2019/11/22
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户登录页面</title>
</head>
<body>
<div align="center">
    <h2 align="center"><font color=red>用户登录页面</font></h2>
    <form action="${pageContext.request.contextPath}/user/login" method="post">
        <table align="center" border="1">
            <tr>
                <td>用户名:</td>
                <td><input type="text" name="username"></td>
            </tr>
            <tr>
                <td>密&nbsp;&nbsp;码:</td>
                <td><input type="text" name="password"></td>
            </tr>
            <tr>
                <td><input type="submit" value="登录" name="login"></td>
                <td style="color: red"><input type="reset" value="重置" name="reset">
                </td>
            </tr>
        </table>
        <p align="center"><a href="registered.jsp" color=blue>注册用户</a></p>
    </form>
        <%
    String MSG = "";
    if (request.getParameter("errorMsg")==null){

    }else {
        MSG = request.getParameter("errorMsg");
    }
%>
        <%=MSG%>

</body>
</html>

